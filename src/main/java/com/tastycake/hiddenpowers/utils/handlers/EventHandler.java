package com.tastycake.hiddenpowers.utils.handlers;

import com.tastycake.hiddenpowers.events.EventSoulStealer;
import com.tastycake.hiddenpowers.events.EventVoidMultitool;
import com.tastycake.hiddenpowers.events.EventVoidMultitoolBlock;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EventSoulStealer());
        MinecraftForge.EVENT_BUS.register(new EventVoidMultitool());
        MinecraftForge.EVENT_BUS.register(new EventVoidMultitoolBlock());
    }
}
