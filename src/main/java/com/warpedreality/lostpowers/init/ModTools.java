package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.tools.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import java.util.ArrayList;
import java.util.List;

public class ModTools {
    public static final List<Item> TOOLS = new ArrayList<Item>();

    // Obsidian
        // Pickaxes
        public static final ItemTool OBSIDIAN_PICKAXE_0 = new ToolPickaxeBase("obsidian_pickaxe_0", Main.tabLostPowers, 4, 2000, 14, 6f, 24);
        public static final ItemTool OBSIDIAN_PICKAXE_1 = new ToolPickaxeBase("obsidian_pickaxe_1", Main.tabLostPowers, 5, 2400, 16, 7f, 25);
        public static final ItemTool OBSIDIAN_PICKAXE_2 = new ToolPickaxeBase("obsidian_pickaxe_2", Main.tabLostPowers, 6, 2800, 18, 8f, 26);

        // Axes
        /*
        public static final ItemTool OBSIDIAN_AXE_0 = new ToolAxeBase("obsidian_axe_0", Main.tabLostPowers, 4, 1800, 14, 10f, 23);
        public static final ItemTool OBSIDIAN_AXE_1 = new ToolAxeBase("obsidian_axe_1", Main.tabLostPowers, 5, 2000, 16, 11f, 24);
        public static final ItemTool OBSIDIAN_AXE_2 = new ToolAxeBase("obsidian_axe_2", Main.tabLostPowers, 6, 2200, 18, 12f, 25);
        */

        // Shovels
        public static final ItemTool OBSIDIAN_SHOVEL_0 = new ToolShovelBase("obsidian_shovel_0", Main.tabLostPowers, 4, 2000, 14, 6.5f, 24);
        public static final ItemTool OBSIDIAN_SHOVEL_1 = new ToolShovelBase("obsidian_shovel_1", Main.tabLostPowers, 5, 2400, 16, 7.5f, 25);
        public static final ItemTool OBSIDIAN_SHOVEL_2 = new ToolShovelBase("obsidian_shovel_2", Main.tabLostPowers, 6, 2800, 18, 8.5f, 26);

        // Swords
        public static final ItemSword OBSIDIAN_SWORD_0 = new ToolSwordBase("obsidian_sword_0", Main.tabLostPowers, 4, 2000, 14, 11f, 24);
        public static final ItemSword OBSIDIAN_SWORD_1 = new ToolSwordBase("obsidian_sword_1", Main.tabLostPowers, 5, 2400, 16, 12f, 25);
        public static final ItemSword OBSIDIAN_SWORD_2 = new ToolSwordBase("obsidian_sword_2", Main.tabLostPowers, 6, 2800, 18, 13f, 26);

    // Primordial
        // Pickaxes

        // Axes

        // Shovels

        // Special
        public static final ItemTool VOID_MULTITOOL = new ItemVoidMultitool();
}