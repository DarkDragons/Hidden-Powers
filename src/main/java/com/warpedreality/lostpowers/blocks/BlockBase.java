package com.warpedreality.lostpowers.blocks;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.utils.IHasModel;
import com.warpedreality.lostpowers.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IHasModel {

    // User Breakable
    public BlockBase(String name, Material material, CreativeTabs tab, SoundType sound, float hardness, float resistance, String tool, int lvl) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        setHarvestLevel(tool, lvl);
        setHardness(hardness);
        setResistance(resistance);

        setSoundType(sound);

        RegistryHelper.registerBlock(this);
    }

    // Unbreakable
    public BlockBase(String name, Material material, CreativeTabs tab, SoundType sound) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        setHardness(-1);
        setResistance(-1);
        setBlockUnbreakable();

        setSoundType(sound);

        RegistryHelper.registerBlock(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
