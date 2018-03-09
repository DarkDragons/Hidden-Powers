package com.tastycake.hiddenpowers.init;

import com.tastycake.hiddenpowers.tools.obsidian.ToolPickaxeBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.ArrayList;
import java.util.List;

public class ModTools {
    public static final List<ItemTool> TOOLS = new ArrayList<ItemTool>();

    //Obsidian Pickaxes
    public static final ItemTool OBSIDIAN_PICKAXE_0 = new ToolPickaxeBase("obsidian_pickaxe_0", CreativeTabs.REDSTONE, 4, 1800, 14, 6, 24);
    public static final ItemTool OBSIDIAN_PICKAXE_1 = new ToolPickaxeBase("obsidian_pickaxe_1", CreativeTabs.REDSTONE, 5, 2000, 16, 7, 25);
    public static final ItemTool OBSIDIAN_PICKAXE_2 = new ToolPickaxeBase("obsidian_pickaxe_2", CreativeTabs.REDSTONE, 6, 2200, 18, 8, 26);
    public static final ItemTool OBSIDIAN_PICKAXE_3 = new ToolPickaxeBase("obsidian_pickaxe_3", CreativeTabs.REDSTONE, 7, 2400, 20, 9, 27);
    public static final ItemTool OBSIDIAN_PICKAXE_4 = new ToolPickaxeBase("obsidian_pickaxe_4", CreativeTabs.REDSTONE, 8, 2600, 22, 10, 28);

}
