package com.tastycake.hiddenpowers.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
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
        return "/heal <player> -- Heals the sender of the command";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        // Setting up variables
        EntityPlayer player = null;

        if (args[0] == null) {
            player = getPlayer(server, sender, sender.getName());
        } else {
            player = getPlayer(server, sender, args[0]);
        }

        float current = player.getHealth();
        float max = player.getMaxHealth();
        float amount = max - current;

        // Healing the player
        player.heal(amount);
    }
}
