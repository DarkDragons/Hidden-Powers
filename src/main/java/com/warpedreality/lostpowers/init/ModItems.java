package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.items.ItemBase;
import com.warpedreality.lostpowers.items.ItemPrimordialSoul;
import com.warpedreality.lostpowers.items.ItemSoulCapsule;
import com.warpedreality.lostpowers.items.ItemVoidFragment;
import com.warpedreality.lostpowers.items.tools.*;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final List<Item> TOOLS = new ArrayList<Item>();

    // Obsidian Ingots
    public static final Item OBSIDIAN_INGOT_0 = new ItemBase("obsidian_ingot_0", Main.tabLostPowers);
    public static final Item OBSIDIAN_INGOT_1 = new ItemBase("obsidian_ingot_1", Main.tabLostPowers);
    public static final Item OBSIDIAN_INGOT_2 = new ItemBase("obsidian_ingot_2", Main.tabLostPowers);

    // Primordial Elements
    public static final Item PRIMORDIAL_FLAME = new ItemBase("primordial_flame", Main.tabLostPowers);
    public static final Item PRIMORDIAL_ENERGY = new ItemBase("primordial_energy", Main.tabLostPowers);
    public static final Item PRIMORDIAL_WATER = new ItemBase("primordial_water", Main.tabLostPowers);
    public static final Item PRIMORDIAL_SOUL = new ItemPrimordialSoul("soul", Main.tabLostPowers);
    public static final Item PRIMORDIAL_VOID = new ItemBase("void_chunk", Main.tabLostPowers);
    public static final Item PRIMORDIAL_VOID_FRAGMENT = new ItemVoidFragment("void_fragment", Main.tabLostPowers);

    // Other
    public static final Item SOUL_CAPSULE = new ItemSoulCapsule();

    // Obsidian
    // Pickaxes
    public static final ItemPickaxe OBSIDIAN_PICKAXE_0 = new ItemToolPickaxeBase("obsidian_pickaxe_0", Main.tabLostPowers, 4, 2000, 14, 6.5f, 24);
    public static final ItemPickaxe OBSIDIAN_PICKAXE_1 = new ItemToolPickaxeBase("obsidian_pickaxe_1", Main.tabLostPowers, 5, 2400, 16, 7.5f, 25);
    public static final ItemPickaxe OBSIDIAN_PICKAXE_2 = new ItemToolPickaxeBase("obsidian_pickaxe_2", Main.tabLostPowers, 6, 2800, 18, 8.5f, 26);

    // Shovels
    public static final ItemSpade OBSIDIAN_SHOVEL_0 = new ItemToolShovelBase("obsidian_shovel_0", Main.tabLostPowers, 4, 2000, 14, 6f, 24);
    public static final ItemSpade OBSIDIAN_SHOVEL_1 = new ItemToolShovelBase("obsidian_shovel_1", Main.tabLostPowers, 5, 2400, 16, 7f, 25);
    public static final ItemSpade OBSIDIAN_SHOVEL_2 = new ItemToolShovelBase("obsidian_shovel_2", Main.tabLostPowers, 6, 2800, 18, 8f, 26);

    // Hoes
    public static final ItemHoe OBSIDIAN_HOE_0 = new ItemToolHoeBase("obsidian_hoe_0", Main.tabLostPowers, 4, 2000, 14, 6.5f, 24);
    public static final ItemHoe OBSIDIAN_HOE_1 = new ItemToolHoeBase("obsidian_hoe_1", Main.tabLostPowers, 5, 2400, 16, 7.5f, 25);
    public static final ItemHoe OBSIDIAN_HOE_2 = new ItemToolHoeBase("obsidian_hoe_2", Main.tabLostPowers, 6, 2800, 18, 8.5f, 26);

    // Axes
    public static final ItemToolAxeBase OBSIDIAN_AXE_0 = new ItemToolAxeBase("obsidian_axe_0", Main.tabLostPowers, 4, 1800, 14, 10f, 23);
    public static final ItemToolAxeBase OBSIDIAN_AXE_1 = new ItemToolAxeBase("obsidian_axe_1", Main.tabLostPowers, 5, 2000, 16, 11f, 24);
    public static final ItemToolAxeBase OBSIDIAN_AXE_2 = new ItemToolAxeBase("obsidian_axe_2", Main.tabLostPowers, 6, 2200, 18, 12f, 25);

    // Swords
    public static final ItemSword OBSIDIAN_SWORD_0 = new ItemToolSwordBase("obsidian_sword_0", Main.tabLostPowers, 4, 2000, 14, 11f, 24);
    public static final ItemSword OBSIDIAN_SWORD_1 = new ItemToolSwordBase("obsidian_sword_1", Main.tabLostPowers, 5, 2400, 16, 12f, 25);
    public static final ItemSword OBSIDIAN_SWORD_2 = new ItemToolSwordBase("obsidian_sword_2", Main.tabLostPowers, 6, 2800, 18, 13f, 26);

    // Special
    public static final Item ENDER_STAFF = new ItemEnderStaff();
}
