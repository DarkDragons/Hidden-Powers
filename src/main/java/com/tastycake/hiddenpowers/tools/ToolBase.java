package com.tastycake.hiddenpowers.tools;

import com.google.common.collect.Sets;
import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModTools;
import com.tastycake.hiddenpowers.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

public class ToolBase extends ItemTool implements IHasModel {

    public ToolBase(String name, int durablility, int damage) {
        super(EnumHelper.addToolMaterial(name + "_material", 0, durablility, 0, damage, 0), Sets.newHashSet(new Block[] {}));

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);

        //register(this);
        ModTools.TOOLS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
