package com.warpedreality.lostpowers.tools;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.init.ModTools;
import com.warpedreality.lostpowers.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ToolSwordBase extends ItemSword implements IHasModel {

    public ToolSwordBase(String name, CreativeTabs tab, int lvl, int durability, int speed, float damage, int enchantability) {
        super(EnumHelper.addToolMaterial(name + "_material", lvl, durability, speed, damage, enchantability));

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModTools.TOOLS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
