package com.tastycake.hiddenpowers.items;

import com.google.common.collect.Sets;
import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemSoulStealer extends ItemTool {

    private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] {});

    private static final String name = "soul_stealer";

    public ItemSoulStealer() {
        super(EnumHelper.addToolMaterial("soulstealermaterial", 0, 100, 0, 1, 0), EFFECTIVE_BLOCKS);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);

        ModItems.ITEMS.add(this);
    }

    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
