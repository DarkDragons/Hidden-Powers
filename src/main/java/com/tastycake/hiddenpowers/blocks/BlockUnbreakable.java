package com.tastycake.hiddenpowers.blocks;

import com.tastycake.hiddenpowers.Main;
import com.tastycake.hiddenpowers.init.ModBlocks;
import com.tastycake.hiddenpowers.init.ModItems;
import com.tastycake.hiddenpowers.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockUnbreakable extends Block implements IHasModel {

    public BlockUnbreakable(String name, Material material, CreativeTabs tab, SoundType sound) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setSoundType(sound);

        setHardness(-1);
        setResistance(-1);
        setBlockUnbreakable();

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
