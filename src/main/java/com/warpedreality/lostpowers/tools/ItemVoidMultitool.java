package com.warpedreality.lostpowers.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemVoidMultitool extends ToolBase {
    public ItemVoidMultitool() {
        super("void_multitool", -1, 0);
        EntityPlayer player = Minecraft.getMinecraft().player;
        onEntitySwing(player, new ItemStack(this));
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        //tooltip.add("You are " + yourName);
    }
}
