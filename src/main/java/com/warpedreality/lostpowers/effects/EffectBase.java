package com.warpedreality.lostpowers.effects;

import com.warpedreality.lostpowers.ModRef;
import com.warpedreality.lostpowers.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class EffectBase extends Potion {
    public static ResourceLocation statusIcon;

    public EffectBase(String name, boolean isBadEffect) {
        super(isBadEffect, new Color(216, 241, 252).getRGB());
        setPotionName("effect." + name);
        setRegistryName(new ResourceLocation(ModRef.MODID + ":" + name));
        setIconIndex(0, 0);
        statusIcon = new ResourceLocation(ModRef.MODID, "textures/gui/container/effect_" + name + ".png");
        //ModEffects.POTIONS.add(this);
        Utils.log().warn("Registered Effect " + getName());
    }

    @Override
    public boolean hasStatusIcon() {
        Minecraft.getMinecraft().renderEngine.bindTexture(statusIcon);
        return true;
    }
}
