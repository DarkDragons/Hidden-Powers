package com.warpedreality.lostpowers.utils.handlers;

import com.warpedreality.lostpowers.events.EventVoidMultitool;
import com.warpedreality.lostpowers.events.EventVoidMultitoolBlock;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EventVoidMultitool());
        MinecraftForge.EVENT_BUS.register(new EventVoidMultitoolBlock());
    }
}
