package com.tastycake.hiddenpowers.tools.obsidian;

import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModTools;
import com.tastycake.hiddenpowers.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

public class ToolPickaxeBase extends ItemPickaxe implements IHasModel {

    public ToolPickaxeBase(String name, CreativeTabs tab, int lvl, int durablility, int speed, int damage, int enchantability) {
        super(EnumHelper.addToolMaterial(name + "_material", lvl, durablility, speed, damage, enchantability));

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);

        ModTools.TOOLS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
