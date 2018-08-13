package com.warpedreality.lostpowers.utils.handlers;

import com.warpedreality.lostpowers.events.EventMobDrops;
import com.warpedreality.lostpowers.events.EventVoidMultitoolBlock;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EventVoidMultitoolBlock());
        MinecraftForge.EVENT_BUS.register(new EventMobDrops());
        //MinecraftForge.EVENT_BUS.register(new EventCustomReach());
    }
}
