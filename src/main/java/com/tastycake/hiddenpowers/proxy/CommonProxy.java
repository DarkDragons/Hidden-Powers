package com.tastycake.hiddenpowers.proxy;

import com.tastycake.hiddenpowers.Config;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {
    // Config Instance
    public static Configuration config;

    public void registerItemRenderer(Item item, int meta, String id) {

    }
}
