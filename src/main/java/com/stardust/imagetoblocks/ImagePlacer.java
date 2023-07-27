package com.stardust.imagetoblocks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Barrel;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getLogger;

public class ImagePlacer {
    ImageToBlocks plugin;
    RGB2Material rgb2Material;

    ImagePlacer(ImageToBlocks plugin) {
        rgb2Material = new RGB2Material();
        this.plugin = plugin;
    }

    void placeImage(Player player, Location loc, String urlloc, int percent) {

        Map<Location, Material> blockBuf = new HashMap<>();

        BukkitTask t = Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                URL url = null;
                BufferedImage imgBuf;
                try {
                    url = new URL(urlloc);
                    imgBuf = ImageIO.read(url);
                } catch (MalformedURLException e) {
                    player.sendMessage("Could not parse given URL!");
                    return;
                } catch (IOException e) {
                    player.sendMessage("Could access remote URL!");
                    return;
                }

                getLogger().info("Downloaded image...");


                Image image = imgBuf.getScaledInstance(
                        (int) Math.round(imgBuf.getWidth() * (percent/100.0)),
                        (int) Math.round(imgBuf.getHeight() * (percent/100.0)),
                        Image.SCALE_DEFAULT);
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                bufferedImage.getGraphics().drawImage(image, 0, 0, null);

                getLogger().info("Resized image...");

                getLogger().info(bufferedImage.getWidth() + ", " + bufferedImage.getHeight());
                if (bufferedImage.getWidth() > 200 || bufferedImage.getHeight() > 200) {
                    getLogger().info("Image too big!...");
                    player.sendMessage("Image size is too big. Pick a smaller image or decrease the scaling factor!");
                    return;
                }

                int pix = 0;
                int lastDone = 0;
                int totalPixels = image.getWidth(null) * image.getHeight(null);
                for (int x = 0; x < image.getWidth(null); x++) {
                    for (int y = 0; y < image.getHeight(null); y++) {
                        Color rgb = new Color(bufferedImage.getRGB(x, y));
                        int a = (bufferedImage.getRGB(x, y) >> 24) & 0xff;
                        Material mat = a == 0? Material.AIR : rgb2Material.closesMatFromRGB(rgb);
                        Location blockLoc = loc.clone().add(x, image.getHeight(null) - y, 0);
                        int done = (int) Math.round(100 * (double) pix / (double) totalPixels);
                        if (done - lastDone > 10) {
                            getLogger().info(done + "% done!");
                            lastDone = done;
                            Bukkit.getScheduler().runTask(plugin, () -> {
                                player.sendMessage(done + "% done...");
                            });
                        }
                        //world.getBlockAt(blockLoc).setType(mat);
                        blockBuf.put(blockLoc, mat);
                    }
                }

                Bukkit.getScheduler().runTask(plugin, () -> {
                    getLogger().info("Starting building materials...");
                    World world = player.getWorld();
                    for (Map.Entry<Location, Material> entry : blockBuf.entrySet()) {
                        world.getBlockAt(entry.getKey()).setType(entry.getValue());
                    }
                    getLogger().info("Done!");
                    player.sendMessage("Done!");
                });
            }
        });
    }
}
