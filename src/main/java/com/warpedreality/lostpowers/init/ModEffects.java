package com.warpedreality.lostpowers.init;

import com.warpedreality.lostpowers.effects.EffectFlight;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModEffects {
    public static final List<Potion> POTIONS = new ArrayList<Potion>();

    public static final Potion POTION_FLIGHT = new EffectFlight();

    public static final PotionType BOTTLE_FLIGHT = new PotionType("flight", new PotionEffect[] {new PotionEffect(POTION_FLIGHT, 4800)}).setRegistryName("flight_bottle");

    public static void registerPotions() {
        ForgeRegistries.POTIONS.register(POTION_FLIGHT);
        ForgeRegistries.POTION_TYPES.register(BOTTLE_FLIGHT);
        PotionHelper.addMix(PotionTypes.INVISIBILITY, Items.NETHER_STAR, BOTTLE_FLIGHT);
    }
}
