package com.tastycake.hiddenpowers.blocks;

import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModBlocks;
import com.tastycake.hiddenpowers.init.ModItems;
import com.tastycake.hiddenpowers.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material, CreativeTabs tab, SoundType sound, float hardness, float resistance, String tool, int lvl) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setHarvestLevel(tool, lvl);
        setSoundType(sound);
        setHardness(hardness);
        setResistance(resistance);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
