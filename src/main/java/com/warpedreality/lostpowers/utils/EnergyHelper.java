package com.warpedreality.lostpowers.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class EnergyHelper {
    public static void useEnergy(int energyOut, ItemStack stack) {
        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
        if (energy.getEnergyStored() - energyOut > 0) {
            energy.extractEnergy(energyOut, false);
        }
    }

    public static int getEnergy(ItemStack stack) {
        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
        return energy.getEnergyStored();
    }
}
