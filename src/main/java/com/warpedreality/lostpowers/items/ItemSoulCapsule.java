package com.warpedreality.lostpowers.items;

import com.warpedreality.lostpowers.Main;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemSoulCapsule extends ItemBase {

    public ItemSoulCapsule() {
        super("soul_capsule", Main.tabLostPowers);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);

        if (maxHealth.getAttributeValue() <= 238) {
            maxHealth.applyModifier(new AttributeModifier("addHeart", +2, 0).setSaved(true));
            player.getHeldItem(hand).shrink(1);
        }

        return super.onItemRightClick(world, player, hand);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Consuming this gives you an extra heart until you die");
        tooltip.add("A Maximum of 110 may be consumed per life");
    }
}