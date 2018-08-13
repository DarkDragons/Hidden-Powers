package com.warpedreality.lostpowers.events;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.packets.MessageCustomReachAttackEnderStaff;
import com.warpedreality.lostpowers.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// Not Used
public class EventCustomReach {

    @SubscribeEvent
    public void customReach(MouseEvent event) {
        if (event.getButton() == 0 && event.isButtonstate()) {
            Minecraft minecraft = Minecraft.getMinecraft();
            Item heldItem = minecraft.player.getHeldItemMainhand().getItem();
            if (heldItem == ModItems.ENDER_STAFF) {
                Entity hit = Utils.getMouseOverExtended(12).entityHit;
				if (hit != null && minecraft.objectMouseOver.entityHit == null) {
				    Main.network.sendToServer(new MessageCustomReachAttackEnderStaff(hit.getEntityId()));
				}
            }
        }
    }
}
