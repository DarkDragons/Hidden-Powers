package com.tastycake.hiddenpowers.init;

import com.tastycake.hiddenpowers.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static net.minecraftforge.fml.common.registry.GameRegistry.addSmelting;

public class ModSmelting {

    public static void register() {
        newSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.OBSIDIAN_INGOT_0), 1.25F);
        newSmelting(ModBlocks.OBSIDIAN_BLOCK_1, new ItemStack(ModItems.OBSIDIAN_INGOT_1), 1.50F);
        newSmelting(ModBlocks.OBSIDIAN_BLOCK_2, new ItemStack(ModItems.OBSIDIAN_INGOT_2), 1.75F);
        newSmelting(ModBlocks.OBSIDIAN_BLOCK_3, new ItemStack(ModItems.OBSIDIAN_INGOT_3), 2.00F);
        newSmelting(ModBlocks.OBSIDIAN_BLOCK_4, new ItemStack(ModItems.OBSIDIAN_INGOT_4), 2.25F);
    }

    public static void newSmelting(Block input, ItemStack output, float xp) {
        Utils.log().info("Registered Recipe > " + input.getUnlocalizedName() + " --> " + output.getUnlocalizedName());
        addSmelting(input, output, xp);
    }
    public static void newSmelting(Item input, ItemStack output, float xp) {
        Utils.log().info("Registered Recipe > " + input.getUnlocalizedName() + " --> " + output.getUnlocalizedName());
        addSmelting(input, output, xp);
    }
}
