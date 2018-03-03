package com.tastycake.hiddenpowers.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockSpecial extends BlockBase {

    public BlockSpecial(String name, Material material, CreativeTabs tab, SoundType sound, float hardness, float resistance, String tool, int lvl, float lightLvl) {
        super(name, material, tab, sound, hardness, resistance, tool, lvl);

        setLightLevel(lightLvl);
    }
}
