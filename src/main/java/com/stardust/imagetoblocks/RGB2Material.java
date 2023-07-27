package com.stardust.imagetoblocks;

import org.bukkit.Material;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RGB2Material {
    Map<Color, Material> colorToMat;

    double dist(Color c1, Color c2) {
        return  Math.pow((c1.getRed()-c2.getRed()) * 0.3, 2) +
                Math.pow((c1.getGreen()-c2.getGreen()) * 0.59, 2) +
                Math.pow((c1.getBlue()-c2.getBlue()) * 0.11, 2);
    }

    double dist2(Color c1, Color c2) {
        // works better than adjusting with scaling
        return  Math.pow((c1.getRed()-c2.getRed()), 2) +
                Math.pow((c1.getGreen()-c2.getGreen()), 2) +
                Math.pow((c1.getBlue()-c2.getBlue()), 2);
    }

    Material closesMatFromRGB(Color color) {
        double smallestDist = 1e9;
        Material bestMat = Material.OBSIDIAN;
        for (Map.Entry<Color, Material> entry : colorToMat.entrySet()) {
           double dist = dist2(entry.getKey(), color);
           if (dist < smallestDist) {
               smallestDist = dist;
               bestMat = entry.getValue();
           }
        }
        return bestMat;
    }

    RGB2Material() {
        colorToMat = new HashMap<>();
        colorToMat.put(new Color(168, 90, 50), Material.ACACIA_PLANKS);
        colorToMat.put(new Color(133, 97, 191), Material.AMETHYST_BLOCK);
        colorToMat.put(new Color(136, 136, 136), Material.ANDESITE);
        colorToMat.put(new Color(190, 170, 78), Material.BAMBOO_MOSAIC);
        colorToMat.put(new Color(193, 173, 80), Material.BAMBOO_PLANKS);
        colorToMat.put(new Color(117, 220, 215), Material.BEACON);
        colorToMat.put(new Color(192, 175, 121), Material.BIRCH_PLANKS);
        colorToMat.put(new Color(42, 35, 40), Material.BLACKSTONE);
        colorToMat.put(new Color(8, 10, 15), Material.BLACK_CONCRETE);
        colorToMat.put(new Color(37, 22, 16), Material.BLACK_TERRACOTTA);
        colorToMat.put(new Color(20, 21, 25), Material.BLACK_WOOL);
        colorToMat.put(new Color(44, 46, 143), Material.BLUE_CONCRETE);
        colorToMat.put(new Color(116, 167, 253), Material.BLUE_ICE);
        colorToMat.put(new Color(74, 59, 91), Material.BLUE_TERRACOTTA);
        colorToMat.put(new Color(53, 57, 157), Material.BLUE_WOOL);
        colorToMat.put(new Color(117, 94, 59), Material.BOOKSHELF);
        colorToMat.put(new Color(207, 91, 159), Material.BRAIN_CORAL_BLOCK);
        colorToMat.put(new Color(150, 97, 83), Material.BRICKS);
        colorToMat.put(new Color(96, 59, 31), Material.BROWN_CONCRETE);
        colorToMat.put(new Color(77, 51, 35), Material.BROWN_TERRACOTTA);
        colorToMat.put(new Color(114, 71, 40), Material.BROWN_WOOL);
        colorToMat.put(new Color(165, 26, 162), Material.BUBBLE_CORAL_BLOCK);
        colorToMat.put(new Color(132, 96, 186), Material.BUDDING_AMETHYST);
        colorToMat.put(new Color(223, 224, 220), Material.CALCITE);
        colorToMat.put(new Color(226, 178, 172), Material.CHERRY_PLANKS);
        colorToMat.put(new Color(54, 54, 54), Material.CHISELED_DEEPSLATE);
        colorToMat.put(new Color(47, 23, 28), Material.CHISELED_NETHER_BRICKS);
        colorToMat.put(new Color(53, 48, 56), Material.CHISELED_POLISHED_BLACKSTONE);
        colorToMat.put(new Color(231, 226, 218), Material.CHISELED_QUARTZ_BLOCK);
        colorToMat.put(new Color(183, 96, 27), Material.CHISELED_RED_SANDSTONE);
        colorToMat.put(new Color(216, 202, 155), Material.CHISELED_SANDSTONE);
        colorToMat.put(new Color(119, 118, 119), Material.CHISELED_STONE_BRICKS);
        colorToMat.put(new Color(160, 166, 179), Material.CLAY);
        colorToMat.put(new Color(16, 15, 15), Material.COAL_BLOCK);
        colorToMat.put(new Color(105, 105, 105), Material.COAL_ORE);
        colorToMat.put(new Color(119, 85, 59), Material.COARSE_DIRT);
        colorToMat.put(new Color(77, 77, 80), Material.COBBLED_DEEPSLATE);
        colorToMat.put(new Color(127, 127, 127), Material.COBBLESTONE);
        colorToMat.put(new Color(192, 107, 79), Material.COPPER_BLOCK);
        colorToMat.put(new Color(124, 125, 120), Material.COPPER_ORE);
        colorToMat.put(new Color(64, 64, 65), Material.CRACKED_DEEPSLATE_BRICKS);
        colorToMat.put(new Color(52, 52, 52), Material.CRACKED_DEEPSLATE_TILES);
        colorToMat.put(new Color(40, 20, 23), Material.CRACKED_NETHER_BRICKS);
        colorToMat.put(new Color(44, 37, 43), Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        colorToMat.put(new Color(118, 117, 118), Material.CRACKED_STONE_BRICKS);
        colorToMat.put(new Color(130, 31, 31), Material.CRIMSON_NYLIUM);
        colorToMat.put(new Color(101, 48, 70), Material.CRIMSON_PLANKS);
        colorToMat.put(new Color(32, 10, 60), Material.CRYING_OBSIDIAN);
        colorToMat.put(new Color(191, 106, 80), Material.CUT_COPPER);
        colorToMat.put(new Color(189, 101, 31), Material.CUT_RED_SANDSTONE);
        colorToMat.put(new Color(217, 206, 159), Material.CUT_SANDSTONE);
        colorToMat.put(new Color(21, 119, 136), Material.CYAN_CONCRETE);
        colorToMat.put(new Color(86, 91, 91), Material.CYAN_TERRACOTTA);
        colorToMat.put(new Color(21, 137, 145), Material.CYAN_WOOL);
        colorToMat.put(new Color(66, 43, 20), Material.DARK_OAK_PLANKS);
        colorToMat.put(new Color(51, 91, 75), Material.DARK_PRISMARINE);
        colorToMat.put(new Color(124, 117, 114), Material.DEAD_BRAIN_CORAL_BLOCK);
        colorToMat.put(new Color(131, 123, 119), Material.DEAD_BUBBLE_CORAL_BLOCK);
        colorToMat.put(new Color(131, 123, 119), Material.DEAD_FIRE_CORAL_BLOCK);
        colorToMat.put(new Color(133, 126, 122), Material.DEAD_HORN_CORAL_BLOCK);
        colorToMat.put(new Color(130, 123, 119), Material.DEAD_TUBE_CORAL_BLOCK);
        colorToMat.put(new Color(70, 70, 71), Material.DEEPSLATE_BRICKS);
        colorToMat.put(new Color(74, 74, 76), Material.DEEPSLATE_COAL_ORE);
        colorToMat.put(new Color(92, 93, 89), Material.DEEPSLATE_COPPER_ORE);
        colorToMat.put(new Color(83, 106, 106), Material.DEEPSLATE_DIAMOND_ORE);
        colorToMat.put(new Color(78, 104, 87), Material.DEEPSLATE_EMERALD_ORE);
        colorToMat.put(new Color(115, 102, 78), Material.DEEPSLATE_GOLD_ORE);
        colorToMat.put(new Color(106, 99, 94), Material.DEEPSLATE_IRON_ORE);
        colorToMat.put(new Color(79, 90, 115), Material.DEEPSLATE_LAPIS_ORE);
        colorToMat.put(new Color(104, 73, 74), Material.DEEPSLATE_REDSTONE_ORE);
        colorToMat.put(new Color(54, 54, 55), Material.DEEPSLATE_TILES);
        colorToMat.put(new Color(98, 237, 228), Material.DIAMOND_BLOCK);
        colorToMat.put(new Color(121, 141, 140), Material.DIAMOND_ORE);
        colorToMat.put(new Color(188, 188, 188), Material.DIORITE);
        colorToMat.put(new Color(12, 9, 15), Material.DRAGON_EGG);
        colorToMat.put(new Color(134, 107, 92), Material.DRIPSTONE_BLOCK);
        colorToMat.put(new Color(42, 203, 87), Material.EMERALD_BLOCK);
        colorToMat.put(new Color(108, 136, 115), Material.EMERALD_ORE);
        colorToMat.put(new Color(219, 222, 158), Material.END_STONE);
        colorToMat.put(new Color(218, 224, 162), Material.END_STONE_BRICKS);
        colorToMat.put(new Color(161, 125, 103), Material.EXPOSED_COPPER);
        colorToMat.put(new Color(154, 121, 101), Material.EXPOSED_CUT_COPPER);
        colorToMat.put(new Color(163, 35, 46), Material.FIRE_CORAL_BLOCK);
        colorToMat.put(new Color(55, 42, 38), Material.GILDED_BLACKSTONE);
        colorToMat.put(new Color(171, 131, 84), Material.GLOWSTONE);
        colorToMat.put(new Color(246, 208, 61), Material.GOLD_BLOCK);
        colorToMat.put(new Color(145, 133, 106), Material.GOLD_ORE);
        colorToMat.put(new Color(149, 103, 85), Material.GRANITE);
        colorToMat.put(new Color(131, 127, 126), Material.GRAVEL);
        colorToMat.put(new Color(54, 57, 61), Material.GRAY_CONCRETE);
        colorToMat.put(new Color(57, 42, 35), Material.GRAY_TERRACOTTA);
        colorToMat.put(new Color(62, 68, 71), Material.GRAY_WOOL);
        colorToMat.put(new Color(73, 91, 36), Material.GREEN_CONCRETE);
        colorToMat.put(new Color(76, 83, 42), Material.GREEN_TERRACOTTA);
        colorToMat.put(new Color(84, 109, 27), Material.GREEN_WOOL);
        colorToMat.put(new Color(229, 148, 29), Material.HONEYCOMB_BLOCK);
        colorToMat.put(new Color(216, 199, 66), Material.HORN_CORAL_BLOCK);
        colorToMat.put(new Color(145, 183, 253), Material.ICE);
        colorToMat.put(new Color(220, 220, 220), Material.IRON_BLOCK);
        colorToMat.put(new Color(136, 129, 122), Material.IRON_ORE);
        colorToMat.put(new Color(160, 115, 80), Material.JUNGLE_PLANKS);
        colorToMat.put(new Color(30, 67, 140), Material.LAPIS_BLOCK);
        colorToMat.put(new Color(107, 117, 141), Material.LAPIS_ORE);
        colorToMat.put(new Color(35, 137, 198), Material.LIGHT_BLUE_CONCRETE);
        colorToMat.put(new Color(113, 108, 137), Material.LIGHT_BLUE_TERRACOTTA);
        colorToMat.put(new Color(58, 175, 217), Material.LIGHT_BLUE_WOOL);
        colorToMat.put(new Color(125, 125, 115), Material.LIGHT_GRAY_CONCRETE);
        colorToMat.put(new Color(135, 106, 97), Material.LIGHT_GRAY_TERRACOTTA);
        colorToMat.put(new Color(142, 142, 134), Material.LIGHT_GRAY_WOOL);
        colorToMat.put(new Color(94, 168, 24), Material.LIME_CONCRETE);
        colorToMat.put(new Color(103, 117, 52), Material.LIME_TERRACOTTA);
        colorToMat.put(new Color(112, 185, 25), Material.LIME_WOOL);
        colorToMat.put(new Color(169, 48, 159), Material.MAGENTA_CONCRETE);
        colorToMat.put(new Color(149, 88, 108), Material.MAGENTA_TERRACOTTA);
        colorToMat.put(new Color(189, 68, 179), Material.MAGENTA_WOOL);
        colorToMat.put(new Color(117, 54, 48), Material.MANGROVE_PLANKS);
        colorToMat.put(new Color(110, 118, 94), Material.MOSSY_COBBLESTONE);
        colorToMat.put(new Color(115, 121, 105), Material.MOSSY_STONE_BRICKS);
        colorToMat.put(new Color(89, 109, 45), Material.MOSS_BLOCK);
        colorToMat.put(new Color(60, 57, 60), Material.MUD);
        colorToMat.put(new Color(137, 103, 79), Material.MUD_BRICKS);
        colorToMat.put(new Color(66, 61, 63), Material.NETHERITE_BLOCK);
        colorToMat.put(new Color(44, 21, 26), Material.NETHER_BRICKS);
        colorToMat.put(new Color(115, 54, 42), Material.NETHER_GOLD_ORE);
        colorToMat.put(new Color(117, 65, 62), Material.NETHER_QUARTZ_ORE);
        colorToMat.put(new Color(114, 2, 2), Material.NETHER_WART_BLOCK);
        colorToMat.put(new Color(88, 58, 40), Material.NOTE_BLOCK);
        colorToMat.put(new Color(162, 130, 78), Material.OAK_PLANKS);
        colorToMat.put(new Color(15, 10, 24), Material.OBSIDIAN);
        colorToMat.put(new Color(224, 97, 0), Material.ORANGE_CONCRETE);
        colorToMat.put(new Color(161, 83, 37), Material.ORANGE_TERRACOTTA);
        colorToMat.put(new Color(240, 118, 19), Material.ORANGE_WOOL);
        colorToMat.put(new Color(82, 162, 132), Material.OXIDIZED_COPPER);
        colorToMat.put(new Color(79, 153, 126), Material.OXIDIZED_CUT_COPPER);
        colorToMat.put(new Color(141, 180, 250), Material.PACKED_ICE);
        colorToMat.put(new Color(142, 106, 79), Material.PACKED_MUD);
        colorToMat.put(new Color(213, 101, 142), Material.PINK_CONCRETE);
        colorToMat.put(new Color(161, 78, 78), Material.PINK_TERRACOTTA);
        colorToMat.put(new Color(237, 141, 172), Material.PINK_WOOL);
        colorToMat.put(new Color(132, 134, 133), Material.POLISHED_ANDESITE);
        colorToMat.put(new Color(53, 48, 56), Material.POLISHED_BLACKSTONE);
        colorToMat.put(new Color(48, 42, 49), Material.POLISHED_BLACKSTONE_BRICKS);
        colorToMat.put(new Color(72, 72, 73), Material.POLISHED_DEEPSLATE);
        colorToMat.put(new Color(192, 193, 194), Material.POLISHED_DIORITE);
        colorToMat.put(new Color(154, 106, 89), Material.POLISHED_GRANITE);
        colorToMat.put(new Color(248, 253, 253), Material.POWDER_SNOW);
        colorToMat.put(new Color(99, 156, 151), Material.PRISMARINE);
        colorToMat.put(new Color(99, 171, 158), Material.PRISMARINE_BRICKS);
        colorToMat.put(new Color(100, 31, 156), Material.PURPLE_CONCRETE);
        colorToMat.put(new Color(118, 70, 86), Material.PURPLE_TERRACOTTA);
        colorToMat.put(new Color(121, 42, 172), Material.PURPLE_WOOL);
        colorToMat.put(new Color(169, 125, 169), Material.PURPUR_BLOCK);
        colorToMat.put(new Color(234, 229, 221), Material.QUARTZ_BRICKS);
        colorToMat.put(new Color(154, 105, 79), Material.RAW_COPPER_BLOCK);
        colorToMat.put(new Color(221, 169, 46), Material.RAW_GOLD_BLOCK);
        colorToMat.put(new Color(166, 135, 107), Material.RAW_IRON_BLOCK);
        colorToMat.put(new Color(175, 24, 5), Material.REDSTONE_BLOCK);
        colorToMat.put(new Color(140, 109, 109), Material.REDSTONE_ORE);
        colorToMat.put(new Color(142, 32, 32), Material.RED_CONCRETE);
        colorToMat.put(new Color(69, 7, 9), Material.RED_NETHER_BRICKS);
        colorToMat.put(new Color(186, 99, 29), Material.RED_SANDSTONE);
        colorToMat.put(new Color(143, 61, 46), Material.RED_TERRACOTTA);
        colorToMat.put(new Color(160, 39, 34), Material.RED_WOOL);
        colorToMat.put(new Color(216, 203, 155), Material.SANDSTONE);
        colorToMat.put(new Color(172, 199, 190), Material.SEA_LANTERN);
        colorToMat.put(new Color(240, 146, 70), Material.SHROOMLIGHT);
        colorToMat.put(new Color(111, 192, 91), Material.SLIME_BLOCK);
        colorToMat.put(new Color(72, 72, 78), Material.SMOOTH_BASALT);
        colorToMat.put(new Color(158, 158, 158), Material.SMOOTH_STONE);
        colorToMat.put(new Color(81, 62, 50), Material.SOUL_SAND);
        colorToMat.put(new Color(75, 57, 46), Material.SOUL_SOIL);
        colorToMat.put(new Color(195, 192, 74), Material.SPONGE);
        colorToMat.put(new Color(114, 84, 48), Material.SPRUCE_PLANKS);
        colorToMat.put(new Color(122, 121, 122), Material.STONE_BRICKS);
        colorToMat.put(new Color(152, 94, 67), Material.TERRACOTTA);
        colorToMat.put(new Color(49, 87, 206), Material.TUBE_CORAL_BLOCK);
        colorToMat.put(new Color(108, 109, 102), Material.TUFF);
        colorToMat.put(new Color(43, 114, 101), Material.WARPED_NYLIUM);
        colorToMat.put(new Color(43, 104, 99), Material.WARPED_PLANKS);
        colorToMat.put(new Color(22, 119, 121), Material.WARPED_WART_BLOCK);
        colorToMat.put(new Color(108, 153, 110), Material.WEATHERED_COPPER);
        colorToMat.put(new Color(109, 145, 107), Material.WEATHERED_CUT_COPPER);
        colorToMat.put(new Color(171, 181, 70), Material.WET_SPONGE);
        colorToMat.put(new Color(207, 213, 214), Material.WHITE_CONCRETE);
        colorToMat.put(new Color(209, 178, 161), Material.WHITE_TERRACOTTA);
        colorToMat.put(new Color(233, 236, 236), Material.WHITE_WOOL);
        colorToMat.put(new Color(240, 175, 21), Material.YELLOW_CONCRETE);
        colorToMat.put(new Color(186, 133, 35), Material.YELLOW_TERRACOTTA);
        colorToMat.put(new Color(248, 197, 39), Material.YELLOW_WOOL);
    }
}
