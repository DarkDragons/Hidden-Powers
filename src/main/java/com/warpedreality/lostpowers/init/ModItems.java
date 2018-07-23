package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.items.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Obsidian Ingots
    public static final Item OBSIDIAN_INGOT_0 = new ItemBase("obsidian_ingot_0", Main.tabLostPowers);
    public static final Item OBSIDIAN_INGOT_1 = new ItemBase("obsidian_ingot_1", Main.tabLostPowers);
    public static final Item OBSIDIAN_INGOT_2 = new ItemBase("obsidian_ingot_2", Main.tabLostPowers);

    // Primordial Elements
    public static final Item PRIMORDIAL_FLAME = new ItemBase("primordial_flame", Main.tabLostPowers);
    public static final Item PRIMORDIAL_ENERGY = new ItemBase("primordial_energy", Main.tabLostPowers);
    public static final Item PRIMORDIAL_WATER = new ItemBase("primordial_water", Main.tabLostPowers);
    public static final Item PRIMORDIAL_VOID = new ItemPrimordialVoid();
    public static final Item PRIMORDIAL_SOUL = new ItemPrimordialSoul();

    // Other
    public static final Item SOUL_CAPSULE = new ItemSoulCapsule();
}
