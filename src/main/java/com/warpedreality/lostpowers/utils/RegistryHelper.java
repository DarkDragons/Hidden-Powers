package com.warpedreality.lostpowers.utils;

import com.warpedreality.lostpowers.init.ModBlocks;
import com.warpedreality.lostpowers.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class RegistryHelper {
    public static void registerItem(Item item) {
        Utils.log().debug("Registering Item " + item.getUnlocalizedName());
        ModItems.ITEMS.add(item);
        Utils.log().warn("Registered Item " + item.getUnlocalizedName());
    }

    public static void registerTool(Item tool) {
        Utils.log().debug("Registering Tool " + tool.getUnlocalizedName());
        ModItems.TOOLS.add(tool);
        Utils.log().warn("Registered Tool " + tool.getUnlocalizedName());
    }

    public static void registerBlock(Block block) {
        Utils.log().debug("Registering Block " + block.getUnlocalizedName());
        ModBlocks.BLOCKS.add(block);
        ModItems.ITEMS.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        Utils.log().warn("Registered Block " + block.getUnlocalizedName());
    }
}
