package com.stardust.imagetoblocks;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ImageToBlocks extends JavaPlugin {

    ImagePlacer placer;

    @Override
    public void onEnable() {
        // Plugin startup logic
        placer = new ImagePlacer(this);
        getCommand("img2blocks").setExecutor(this);
        getLogger().info("Image to blocks loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        final Player player = (Player) sender;

        if (args.length != 2 || args[0].equals("help")) {
            player.sendMessage("Usage: /img2blocks [URL] [downscale percent: (1 - 100)]");
        }
        else {
            String url = args[0];
            int percent = Integer.parseInt(args[1]);
            if (percent > 0 && percent < 100) {
                if (url.startsWith("http")) {
                    Location loc = player.getLocation().add(player.getLocation().getDirection());
                    placer.placeImage(player, loc, url, percent);
                } else {
                    player.sendMessage("Invalid URL must start with http://");
                }
            } else {
                player.sendMessage("Invalid percentage. Must be an integer from 1 - 100");
            }
        }
        return true;
    }
}
