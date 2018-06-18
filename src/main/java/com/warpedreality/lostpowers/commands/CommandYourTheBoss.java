package com.warpedreality.lostpowers.commands;

import com.warpedreality.lostpowers.init.ModTools;
import com.warpedreality.lostpowers.utils.Utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraftforge.fml.server.FMLServerHandler;

import java.util.UUID;

public class CommandYourTheBoss extends CommandBase {
    @Override
    public String getName() {
        return "yourTheBoss";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        // Setting up variables
        EntityPlayer player = getPlayer(server, sender, sender.getName());
        String playerID = player.getUniqueID().toString();



        //FMLServerHandler.instance().getServer().getPlayerList().getPlayerByUUID();

        if (playerID == "bac46109-67fa-4540-abd9-ba1f89bdc301") {
            player.inventory.addItemStackToInventory(new ItemStack(ModTools.VOID_MULTITOOL));
            Utils.log().info("Given " + playerID + "Soul Stealer");
        }
}
}
