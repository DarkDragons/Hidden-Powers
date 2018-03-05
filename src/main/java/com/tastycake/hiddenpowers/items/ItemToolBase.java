package com.tastycake.hiddenpowers.items;

import com.google.common.collect.Sets;
import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModItems;
import com.tastycake.hiddenpowers.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemToolBase extends ItemTool implements IHasModel {

    public ItemToolBase(String name, CreativeTabs tab, int durablility, int damage) {
        super(EnumHelper.addToolMaterial(name + "_material", 0, durablility, 0, damage, 0), Sets.newHashSet(new Block[] {}));

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
