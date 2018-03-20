package com.tastycake.hiddenpowers.events;

import com.tastycake.hiddenpowers.init.ModTools;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventVoidMultitoolBlock {
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getItemStack().getItem() == ModTools.VOID_MULTITOOL) {
            BlockPos pos = event.getPos();
            event.getWorld().setBlockToAir(pos);
        }
    }
}