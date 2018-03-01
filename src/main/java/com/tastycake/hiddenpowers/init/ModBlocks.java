package com.tastycake.hiddenpowers.init;

import com.tastycake.hiddenpowers.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block OBSIDIAN_BLOCK_1 = new BlockBase("obsidian_block_1", Material.ROCK, CreativeTabs.REDSTONE);
    public static final Block OBSIDIAN_BLOCK_2 = new BlockBase("obsidian_block_2", Material.ROCK, CreativeTabs.REDSTONE);
    public static final Block OBSIDIAN_BLOCK_3 = new BlockBase("obsidian_block_3", Material.ROCK, CreativeTabs.REDSTONE);
    public static final Block OBSIDIAN_BLOCK_4 = new BlockBase("obsidian_block_4", Material.ROCK, CreativeTabs.REDSTONE);
}
