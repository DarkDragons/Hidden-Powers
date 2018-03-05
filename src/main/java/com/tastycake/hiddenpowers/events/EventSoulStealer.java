package com.tastycake.hiddenpowers.events;

import com.tastycake.hiddenpowers.init.ModItems;
import com.tastycake.hiddenpowers.utils.Utils;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventSoulStealer {

    @SubscribeEvent
    public void onDamageEvent(LivingHurtEvent event) {
        if(event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if(player.getHeldItemMainhand().getItem() == ModItems.SOUL_STEALER) {
                BlockPos pos = event.getEntity().getPosition();
                EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL));
                player.getEntityWorld().spawnEntity(item);
            }
        }
    }
}
