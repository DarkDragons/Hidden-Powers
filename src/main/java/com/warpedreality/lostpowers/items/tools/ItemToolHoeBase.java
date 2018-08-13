package com.warpedreality.lostpowers.items.tools;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.utils.IHasModel;
import com.warpedreality.lostpowers.utils.RegistryHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolHoeBase extends ItemHoe implements IHasModel {

    public ItemToolHoeBase(String name, CreativeTabs tab, int lvl, int durablility, int speed, float damage, int enchantability) {
        super(EnumHelper.addToolMaterial(name + "_material", lvl, durablility, speed, damage, enchantability));

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
