package com.warpedreality.lostpowers.items;

import com.warpedreality.lostpowers.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPrimordialSoul extends ItemBase {

    public ItemPrimordialSoul() {
        super("primordial_soul", Main.tabLostPowers);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (player.getHealth() < player.getMaxHealth() || player.getFoodStats().getFoodLevel() < 20) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(2);
            }

            if (player.getFoodStats().getFoodLevel() < 20) {
                player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() + 1);
            }

            player.getHeldItem(hand).shrink(1);
        }

        return super.onItemRightClick(world, player, hand);

    }
}
