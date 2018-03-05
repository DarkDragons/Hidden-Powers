package com.tastycake.hiddenpowers.utils.handlers;

import com.tastycake.hiddenpowers.events.EventSoulStealer;
import com.tastycake.hiddenpowers.events.EventVoidDagger;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EventSoulStealer());
        MinecraftForge.EVENT_BUS.register(new EventVoidDagger());
    }
}
