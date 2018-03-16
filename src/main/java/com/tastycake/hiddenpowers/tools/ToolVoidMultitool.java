package com.tastycake.hiddenpowers.tools;

import com.google.common.collect.Sets;
import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModItems;
import com.tastycake.hiddenpowers.init.ModTools;
import com.tastycake.hiddenpowers.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

public class ToolVoidMultitool extends ItemTool implements IHasModel {

    public ToolVoidMultitool() {
        super(EnumHelper.addToolMaterial("void_multitool_material", 0, -1, 0, 0, 0), Sets.newHashSet(new Block[] {}));

        setUnlocalizedName("void_multitool");
        setRegistryName("name");
        setCreativeTab(CreativeTabs.REDSTONE);

        ModTools.TOOLS.add(this);
        //register(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
