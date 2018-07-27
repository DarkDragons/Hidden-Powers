package com.warpedreality.lostpowers.events;

import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.init.ModTools;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventVoidMultitool {

    @SubscribeEvent
    public void onAttackAnimal(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();

            if (player.getHeldItemMainhand().getItem() == ModTools.VOID_MULTITOOL) {
                if (event.getEntity() instanceof EntityWither) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (event.getEntity() instanceof EntityDragon) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 4));
                    player.getEntityWorld().spawnEntity(item);
                    item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 16));
                    player.getEntityWorld().spawnEntity(item);
                } else if (event.getEntity() instanceof EntityEnderman) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (event.getEntity() instanceof EntityGuardian || event.getEntity() instanceof EntityElderGuardian) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_WATER, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityBlaze) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_FLAME, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityCreeper) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_ENERGY, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityLiving){
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (event.getEntity() instanceof EntityLivingBase){
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                }
                event.getEntityLiving().setHealth(0);
            }
        }
    }
}
