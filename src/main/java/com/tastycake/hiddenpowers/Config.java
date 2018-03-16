package com.tastycake.hiddenpowers;

import com.tastycake.hiddenpowers.utils.Utils;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import static com.tastycake.hiddenpowers.proxy.CommonProxy.config;

public class Config {
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_TOOL = "tool";

    // This values below you can access elsewhere in your mod:
    public static String yourRealName = "Steve";
    public static boolean enableSoulStealerProp = true;
    public static boolean enableVoidDaggerProp = true;
    public static boolean enableVoidMultitoolProp = true;

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initToolConfig(cfg);
        } catch (Exception e1) {
            Utils.log().error("Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    public static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration   |   Everything Requires Restart");

        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }

    public static void initToolConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_TOOL, "Tool Configuration");

        /*
        enableSoulStealerProp = cfg.getBoolean("enableSoulStealer", CATEGORY_TOOL, enableSoulStealerProp, "Set to true if you want the Soul Stealer enabled");
        enableVoidDaggerProp = cfg.getBoolean("enableVoidDagger", CATEGORY_TOOL, enableVoidDaggerProp, "Set to true if you want the Void Dagger enabled");
        enableVoidMultitoolProp = cfg.getBoolean("enableVoidMultitool", CATEGORY_TOOL, enableVoidMultitoolProp, "Set to true if you want the Void Multitool enabled");

        enabled.put("soul_stealer", enableSoulStealerProp);
        enabled.put("void_dagger", enableVoidDaggerProp);
        enabled.put("void_multitool", enableVoidMultitoolProp);
        */
    }

    public static void PreInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "hidden-powers.cfg"));
        Config.readConfig();
    }

    public static void Init(FMLInitializationEvent event) {

    }

    public static void PostInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }
}