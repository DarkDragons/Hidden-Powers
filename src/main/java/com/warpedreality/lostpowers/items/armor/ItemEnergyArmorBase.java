package com.warpedreality.lostpowers.items.armor;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.ModConf;
import com.warpedreality.lostpowers.utils.IHasModel;
import com.warpedreality.lostpowers.utils.RegistryHelper;
import com.warpedreality.lostpowers.utils.capabilities.CapabilityProviderEnergy;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.List;

public class ItemEnergyArmorBase extends ItemArmor implements IHasModel {
    int maxEnergyCapacity;
    int maxEnergyIn;
    int maxEnergyOut;
    EnergyStorage storage;

    public ItemEnergyArmorBase(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot, int maxEnergyCapacity, int maxEnergyIn) {
        super(material, renderIndex, equipmentSlot);
        setUnlocalizedName(name);
        setRegistryName(name);

        this.setMaxDamage(-1);

        RegistryHelper.registerArmor(this);

        this.maxEnergyCapacity = maxEnergyCapacity;
        this.maxEnergyIn = maxEnergyIn;
        this.maxEnergyOut = 0;
        this.storage = new EnergyStorage(this.maxEnergyCapacity, this.maxEnergyIn, maxEnergyOut);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound tag) {
        return new CapabilityProviderEnergy(stack, maxEnergyCapacity);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if (ModConf.general.poweredByFE) {
            IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
            return 1D - ((double) energy.getEnergyStored() / (double) energy.getMaxEnergyStored());
        } else {
            //return (double)stack.getItemDamage() / (double)stack.getMaxDamage();
            return super.getDurabilityForDisplay(stack);
        }
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        if (ModConf.general.poweredByFE) {
            IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
            return MathHelper.hsvToRGB(Math.max(0.0F, (float) energy.getEnergyStored() / (float) energy.getMaxEnergyStored()) / 3.0F, 1.0F, 1.0F);
        } else {
            //return MathHelper.hsvToRGB(Math.max(0.0F, (float) (1.0F - getDurabilityForDisplay(stack))) / 3.0F, 1.0F, 1.0F);
            return super.getRGBDurabilityForDisplay(stack);
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        if (ModConf.general.poweredByFE) {
            IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
            return energy.getEnergyStored() != energy.getMaxEnergyStored();
        } else {
            return super.showDurabilityBar(stack);
        }
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> list, ITooltipFlag b) {
        //Add tool information to the tooltip
        super.addInformation(stack, player, list, b);
        if (ModConf.general.poweredByFE) {
            IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
            list.add(energy.getEnergyStored() + "/" + energy.getMaxEnergyStored() + " FE");
            list.add("FE (Forge Energy) is the same as RF (Redstone Flux)");
        } else {
            list.add("Infinite Durability. Set poweredByFE to True in the config to use energy.");
        }
    }
}
