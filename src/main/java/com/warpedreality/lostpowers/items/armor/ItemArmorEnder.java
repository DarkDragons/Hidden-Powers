package com.warpedreality.lostpowers.items.armor;

import com.warpedreality.lostpowers.ModConf;
import com.warpedreality.lostpowers.ModRef;
import com.warpedreality.lostpowers.init.ModEffects;
import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.utils.EnergyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Collection;

public class ItemArmorEnder extends ItemEnergyArmorBase {

    public ItemArmorEnder(String name, int renderIndex, EntityEquipmentSlot equipmentSlot, int maxEnergyCapacity, int maxEnergyIn) {
        super("ender_" + name, EnumHelper.addArmorMaterial("armor_material_ender", ModRef.MODID + ":ender", -1, new int[] {7, 12, 14, 5}, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F), renderIndex, equipmentSlot, maxEnergyCapacity, maxEnergyIn);
        // For Material, the array with the armor points is ordered boots, leggings, chestplate, helmet
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        boolean isCreativeMode = player.capabilities.isCreativeMode;

        if (stack.getItem() == ModItems.ENDER_HELM) {
            if (!isCreativeMode && ModConf.general.poweredByFE) {
                if (EnergyHelper.getEnergy(stack) - ModConf.enderArmor.passiveEnergyUsageHelm >= 0) {
                    //EnergyHelper.useEnergy(ModConf.enderArmor.passiveEnergyUsageHelm, stack);
                    // True
                } else {
                    // False
                }
            } else {
                // True
            }
        } else if (stack.getItem() == ModItems.ENDER_CHESTPLATE) {
            PotionEffect flight = new PotionEffect(ModEffects.POTION_FLIGHT, 80);
            if (!isCreativeMode && ModConf.general.poweredByFE) {
                if (EnergyHelper.getEnergy(stack) - ModConf.enderArmor.passiveEnergyUsageChestplate >= 0) {
                    EnergyHelper.useEnergy(ModConf.enderArmor.passiveEnergyUsageChestplate, stack);
                    player.addPotionEffect(flight);
                }
            } else {
                player.addPotionEffect(flight);
            }
        } else if (stack.getItem() == ModItems.ENDER_LEGGINGS) {
            PotionEffect flight = new PotionEffect(ModEffects.POTION_FLIGHT, 80);
            if (!isCreativeMode && ModConf.general.poweredByFE) {
                if (EnergyHelper.getEnergy(stack) - ModConf.enderArmor.passiveEnergyUsageLeggings >= 0) {
                    EnergyHelper.useEnergy(ModConf.enderArmor.passiveEnergyUsageLeggings, stack);
                    player.addPotionEffect(flight);
                }
            } else {
                player.addPotionEffect(flight);
            }
        } else if (stack.getItem() == ModItems.ENDER_BOOTS) {
            PotionEffect speed = new PotionEffect(Potion.getPotionFromResourceLocation("speed"), 80, 5);
            if (!isCreativeMode && ModConf.general.poweredByFE) {
                if (EnergyHelper.getEnergy(stack) - ModConf.enderArmor.passiveEnergyUsageBoots >= 0) {
                    EnergyHelper.useEnergy(ModConf.enderArmor.passiveEnergyUsageBoots, stack);
                    player.addPotionEffect(speed);
                }
            } else {
                player.addPotionEffect(speed);
            }
        }
    }

    public boolean clearNegativeEffects(Entity entity) {
        if (entity.ticksExisted % 20 == 0) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;

                Collection<PotionEffect> potions = player.getActivePotionEffects();

                if (player.isBurning()) {
                    player.extinguish();
                }
                for (PotionEffect potion : potions) {
                    if (potion.getPotion().isBadEffect()) {
                        player.removePotionEffect(potion.getPotion());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
