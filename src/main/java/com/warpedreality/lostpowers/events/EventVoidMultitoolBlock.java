package com.warpedreality.lostpowers.events;

import com.warpedreality.lostpowers.ModConf;
import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.utils.Utils;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventVoidMultitoolBlock {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.ENDER_STAFF) {
            boolean isCreativeMode = event.getEntityPlayer().capabilities.isCreativeMode;
            if (!isCreativeMode && ModConf.poweredByFE) {
                    ItemStack stackStaff = event.getEntityPlayer().getHeldItemMainhand();
                    if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.BEDROCK) {
                        if (Utils.getEnergy(event.getItemStack()) - ModConf.enderStaffEnergyPerUseBlockBoss > 0) {
                            BlockPos pos = event.getPos();

                            EntityPlayer player = event.getEntityPlayer();

                            ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                            EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                            if (!event.getWorld().isRemote)
                                player.getEntityWorld().spawnEntity(item);

                            Utils.useEnergy(ModConf.enderStaffEnergyPerUseBlockBoss, stackStaff);
                            event.getWorld().setBlockToAir(pos);
                        }
                    } else if (Utils.getEnergy(event.getItemStack()) - ModConf.enderStaffEnergyPerUseBlock > 0) {
                        BlockPos pos = event.getPos();

                        EntityPlayer player = event.getEntityPlayer();

                        ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                        if (!event.getWorld().isRemote)
                            player.getEntityWorld().spawnEntity(item);

                        Utils.useEnergy(ModConf.enderStaffEnergyPerUseBlock, stackStaff);
                        event.getWorld().setBlockToAir(pos);
                    }
            } else if (!isCreativeMode) {
                BlockPos pos = event.getPos();

                EntityPlayer player = event.getEntityPlayer();

                ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                if (!event.getWorld().isRemote)
                    player.getEntityWorld().spawnEntity(item);

                event.getWorld().setBlockToAir(pos);
            } else {
                BlockPos pos = event.getPos();

                EntityPlayer player = event.getEntityPlayer();

                ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                if (!event.getWorld().isRemote)
                    player.getEntityWorld().spawnEntity(item);

                event.getWorld().setBlockToAir(pos);
            }
        }
    }
}
