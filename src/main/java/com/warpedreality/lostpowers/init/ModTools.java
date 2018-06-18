package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.tools.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.ArrayList;
import java.util.List;

public class ModTools {
    public static final List<Item> TOOLS = new ArrayList<Item>();

    // Obsidian
        // Pickaxes
        public static final ItemTool OBSIDIAN_PICKAXE_0 = new ToolPickaxeBase("obsidian_pickaxe_0", CreativeTabs.REDSTONE, 4, 1800, 14, 6f, 23);
        public static final ItemTool OBSIDIAN_PICKAXE_1 = new ToolPickaxeBase("obsidian_pickaxe_1", CreativeTabs.REDSTONE, 5, 2000, 16, 7f, 24);
        public static final ItemTool OBSIDIAN_PICKAXE_2 = new ToolPickaxeBase("obsidian_pickaxe_2", CreativeTabs.REDSTONE, 6, 2200, 18, 8f, 25);
        public static final ItemTool OBSIDIAN_PICKAXE_3 = new ToolPickaxeBase("obsidian_pickaxe_3", CreativeTabs.REDSTONE, 7, 2400, 20, 9f, 26);
        public static final ItemTool OBSIDIAN_PICKAXE_4 = new ToolPickaxeBase("obsidian_pickaxe_4", CreativeTabs.REDSTONE, 8, 2600, 22, 10f, 27);

        // Axes
        /*
        public static final ItemTool OBSIDIAN_AXE_0 = new ToolAxeBase("obsidian_axe_0", CreativeTabs.REDSTONE, 4, 1800, 14, 10f, 23);
        public static final ItemTool OBSIDIAN_AXE_1 = new ToolAxeBase("obsidian_axe_1", CreativeTabs.REDSTONE, 5, 2000, 16, 11f, 24);
        public static final ItemTool OBSIDIAN_AXE_2 = new ToolAxeBase("obsidian_axe_2", CreativeTabs.REDSTONE, 6, 2200, 18, 12f, 25);
        public static final ItemTool OBSIDIAN_AXE_3 = new ToolAxeBase("obsidian_axe_3", CreativeTabs.REDSTONE, 7, 2400, 20, 13f, 26);
        public static final ItemTool OBSIDIAN_AXE_4 = new ToolAxeBase("obsidian_axe_4", CreativeTabs.REDSTONE, 8, 2600, 22, 14f, 27);
        */

        // Shovels
        public static final ItemTool OBSIDIAN_SHOVEL_0 = new ToolShovelBase("obsidian_shovel_0", CreativeTabs.REDSTONE, 4, 1800, 14, 6.5f, 23);
        public static final ItemTool OBSIDIAN_SHOVEL_1 = new ToolShovelBase("obsidian_shovel_1", CreativeTabs.REDSTONE, 5, 2000, 16, 7.5f, 24);
        public static final ItemTool OBSIDIAN_SHOVEL_2 = new ToolShovelBase("obsidian_shovel_2", CreativeTabs.REDSTONE, 6, 2200, 18, 8.5f, 25);
        public static final ItemTool OBSIDIAN_SHOVEL_3 = new ToolShovelBase("obsidian_shovel_3", CreativeTabs.REDSTONE, 7, 2400, 20, 9.5f, 26);
        public static final ItemTool OBSIDIAN_SHOVEL_4 = new ToolShovelBase("obsidian_shovel_4", CreativeTabs.REDSTONE, 8, 2600, 22, 10.5f, 27);

    // Primordial
        // Pickaxes

        // Axes

        // Shovels

        // Special
        public static final ItemTool VOID_MULTITOOL = new ItemVoidMultitool();
}