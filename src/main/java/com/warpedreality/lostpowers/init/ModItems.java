package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.items.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Obsidan Ingots
    public static final Item OBSIDIAN_INGOT_0 = new ItemBase("obsidian_ingot_0", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_1 = new ItemBase("obsidian_ingot_1", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_2 = new ItemBase("obsidian_ingot_2", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_3 = new ItemBase("obsidian_ingot_3", CreativeTabs.REDSTONE);
    public static final Item OBSIDIAN_INGOT_4 = new ItemBase("obsidian_ingot_4", CreativeTabs.REDSTONE);

    // Primordial Elements
    public static final Item PRIMORDIAL_FLAME = new ItemBase("primordial_flame", CreativeTabs.REDSTONE);
    public static final Item PRIMORDIAL_ENERGY = new ItemBase("primordial_energy", CreativeTabs.REDSTONE);
    public static final Item PRIMORDIAL_WATER = new ItemBase("primordial_water", CreativeTabs.REDSTONE);
    public static final Item PRIMORDIAL_VOID = new ItemPrimordialVoid();
    public static final Item PRIMORDIAL_SOUL = new ItemPrimordialSoul();
    public static final Item SOUL_CAPSULE = new ItemSoulCapsule();
}
