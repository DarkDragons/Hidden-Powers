package com.tastycake.hiddenpowers.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemHeart extends ItemBase {

    public ItemHeart() {
        super("heart", CreativeTabs.REDSTONE);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            player.heal(1);
            player.getHeldItem(hand).shrink(1);
        }

        return super.onItemRightClick(world, player, hand);

    }
}
