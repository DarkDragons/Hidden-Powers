package com.tastycake.hiddenpowers.commands;

import com.tastycake.hiddenpowers.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

public class CommandDimensionTP extends CommandBase {
    @Override
    public String getName()
    {
        return "tpdim";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        // Getting available dimensions
        Integer[] dimID = DimensionManager.getIDs();
        String[] dimName = null;

        for (int i = 0; i < dimID.length; i++) {
            dimName[i] = DimensionManager.getProviderType(dimID[i]).getName();
        }

        return "/tpdim <player> <dimension> -- Teleports the given player to the given dimensions. Available dimensions are >\n" + dimName.toString() + "\n" + dimID.toString();
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

        Integer dimChoice = parseInt(args[0]);
        World world = player.getEntityWorld();

        Utils.log().info(world);

        // Command Possibilities
        if (dimChoice == world.provider.getDimension())
        {
            notifyCommandListener(sender, this, "command.tpdim.ownDim");
        }
        else if (!DimensionManager.isDimensionRegistered(dimChoice))
        {
            notifyCommandListener(sender, this, "command.tpdim.noDim");
        }
        else
        {
            player.changeDimension(dimChoice);
        }
    }
}
