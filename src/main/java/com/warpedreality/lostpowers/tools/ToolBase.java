package com.warpedreality.lostpowers.tools;

import com.google.common.collect.Sets;
import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.init.ModTools;
import com.warpedreality.lostpowers.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

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
