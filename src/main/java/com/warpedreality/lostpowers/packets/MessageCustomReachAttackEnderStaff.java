package com.warpedreality.lostpowers.packets;

import com.warpedreality.lostpowers.init.ModItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

// Not Used
public class MessageCustomReachAttackEnderStaff implements IMessage {

    public static double reach = 6;

    private int entityId;

    public static class Handler implements IMessageHandler<MessageCustomReachAttackEnderStaff, IMessage> {
        @Override
        public IMessage onMessage(final MessageCustomReachAttackEnderStaff message, MessageContext ctx) {
            final EntityPlayerMP player = ctx.getServerHandler().player;
            player.getServer().addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    Entity theEntity = player.world.getEntityByID(message.entityId);
                    if (player.inventory.getCurrentItem() == null || player.inventory.getCurrentItem().isEmpty()) {
                        return;
                    }
                    if (player.inventory.getCurrentItem().getItem() == ModItems.ENDER_STAFF) {
                        double distanceSq = player.getDistanceSq(theEntity);
                        double reachSq = reach * reach;
                        if (reachSq >= distanceSq) {
                            player.attackTargetEntityWithCurrentItem(theEntity);
                        }
                    }
                    return;
                }
            });
            return null;
        }
    }

    public MessageCustomReachAttackEnderStaff(int entityId) {
        this.entityId = entityId;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        entityId = ByteBufUtils.readVarInt(buf, 4);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, entityId, 4);
    }
}