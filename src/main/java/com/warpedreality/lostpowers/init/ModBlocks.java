package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block OBSIDIAN_BLOCK_1 = new BlockBase("obsidian_block_1", Material.GLASS, Main.tabLostPowers, SoundType.STONE,55, 6250, "pickaxe", 4);
    public static final Block OBSIDIAN_BLOCK_2 = new BlockBase("obsidian_block_2", Material.GLASS, Main.tabLostPowers, SoundType.STONE,60, 6500, "pickaxe", 5);
}