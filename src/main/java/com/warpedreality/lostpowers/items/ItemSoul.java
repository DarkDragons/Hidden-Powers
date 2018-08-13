package com.warpedreality.lostpowers.items;

import com.warpedreality.lostpowers.ModConf;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSoul extends ItemBase {

    public ItemSoul(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (player.getHealth() < player.getMaxHealth() || player.getFoodStats().getFoodLevel() < 20) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(ModConf.soul.soulHealHealth);
            }

            if (player.getFoodStats().getFoodLevel() < 20) {
                player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() + ModConf.soul.soulHealHunger);
            }

            player.getHeldItem(hand).shrink(1);
        }

        return super.onItemRightClick(world, player, hand);
    }
}
