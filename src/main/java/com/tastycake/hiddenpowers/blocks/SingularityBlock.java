package com.tastycake.hiddenpowers.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SingularityBlock extends BlockUnbreakable {
    public SingularityBlock() {
        super("singularity_block", Material.GLASS, CreativeTabs.REDSTONE, SoundType.GLASS);
        setLightLevel(18.0F);
    }
}
