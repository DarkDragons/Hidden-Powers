package com.warpedreality.lostpowers.items.tools;

import com.google.common.collect.Sets;
import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.utils.IHasModel;
import com.warpedreality.lostpowers.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemToolBase extends ItemTool implements IHasModel {

    public ItemToolBase(String name, int durablility, int damage, CreativeTabs tab) {
        super(EnumHelper.addToolMaterial(name + "_material", 0, durablility, 0, damage, 0), Sets.newHashSet(new Block[] {}));

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        RegistryHelper.registerTool(this);
    }

    public ItemToolBase(String name, int durablility, int damage, Set effectiveOn, CreativeTabs tab) {
        super(EnumHelper.addToolMaterial(name + "_material", 0, durablility, 0, damage, 0), effectiveOn);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        RegistryHelper.registerTool(this);
    }

    public ItemToolBase(String name, ToolMaterial toolMaterial, CreativeTabs tab) {
        super(toolMaterial, Sets.newHashSet(new Block[] {}));

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        RegistryHelper.registerTool(this);
    }

    public ItemToolBase(String name, ToolMaterial toolMaterial, Set effectiveOn, CreativeTabs tab) {
        super(toolMaterial, effectiveOn);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        RegistryHelper.registerTool(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
