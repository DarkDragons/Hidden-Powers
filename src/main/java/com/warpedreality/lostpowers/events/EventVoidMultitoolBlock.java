package com.warpedreality.lostpowers.events;

import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.init.ModTools;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class EventVoidMultitoolBlock {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getEntityPlayer().getHeldItemMainhand().getItem() == ModTools.VOID_MULTITOOL) {
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
