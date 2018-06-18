package com.warpedreality.lostpowers.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPrimordialVoid extends ItemBase {

    public ItemPrimordialVoid() {
        super("primordial_void", CreativeTabs.REDSTONE);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.attackEntityFrom(DamageSource.GENERIC, 1);
        player.getHeldItem(hand).shrink(1);

        return super.onItemRightClick(world, player, hand);
    }
}
