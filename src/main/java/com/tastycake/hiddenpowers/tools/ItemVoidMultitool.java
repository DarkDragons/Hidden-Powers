package com.tastycake.hiddenpowers.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

import static com.tastycake.hiddenpowers.Config.yourName;

public class ItemVoidMultitool extends ToolBase {

    Integer[] dims = DimensionManager.getIDs();
    String[] dimS;

    public ItemVoidMultitool() {
        super("void_multitool", -1, 0);
        EntityPlayer player = Minecraft.getMinecraft().player;
        onEntitySwing(player, new ItemStack(this));
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("You are " + yourName);

        for (int i = 0; i < dims.length; i++)
        {
            dimS[i] = dims[i].toString();
            tooltip.add(dimS[i]);
        }
    }
}
