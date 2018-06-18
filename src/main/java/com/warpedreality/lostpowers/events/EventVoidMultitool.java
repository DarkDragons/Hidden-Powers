package com.warpedreality.lostpowers.events;

import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.init.ModTools;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventVoidMultitool {

    @SubscribeEvent
    public void onAttackAnimal(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            Random r = new Random();

            if (player.getHeldItemMainhand().getItem() == ModTools.VOID_MULTITOOL) {
                BlockPos pos = event.getEntity().getPosition();
                EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL));
                player.getEntityWorld().spawnEntity(item);
                event.getEntity().setDead();

                /*
                if (r.nextInt(4) == 1) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_VOID));
                    player.getEntityWorld().spawnEntity(item);
                }*/
            }
        }
    }
}
