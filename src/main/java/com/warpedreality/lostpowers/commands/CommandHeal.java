package com.warpedreality.lostpowers.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandHeal extends CommandBase {
    @Override
    public String getName()
    {
        return "heal";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/heal <player> -- Heals <player> if specified. Otherwise heals the sender of the command";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        // Setting up variables
        EntityPlayer player = null;

        if (args[1] == null) {
            player = getPlayer(server, sender, sender.getName());
        } else {
            player = getPlayer(server, sender, args[1]);
        }

        IAttributeInstance maxhealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);;

        float current = player.getHealth();
        float max = ((float) maxhealth.getAttributeValue());
        float amount = max - current;

        // Healing the player
        player.heal(amount);
    }
}
