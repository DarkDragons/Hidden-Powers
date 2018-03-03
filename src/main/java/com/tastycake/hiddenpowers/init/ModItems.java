package com.tastycake.hiddenpowers.init;

import com.tastycake.hiddenpowers.items.ItemBase;
import com.tastycake.hiddenpowers.items.ItemHeart;
import com.tastycake.hiddenpowers.items.ItemSoulStealer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item OBSIDIAN_INGOT_0 = new ItemBase("obsidian_ingot_0", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_1 = new ItemBase("obsidian_ingot_1", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_2 = new ItemBase("obsidian_ingot_2", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_3 = new ItemBase("obsidian_ingot_3", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_4 = new ItemBase("obsidian_ingot_4", CreativeTabs.REDSTONE);

    public static final Item PRIMORDIAL_FLAME = new ItemBase("primordial_flame", CreativeTabs.REDSTONE);
    public static final Item SOUL_STEALER = new ItemSoulStealer();
    public static final Item HEART = new ItemHeart();
}
