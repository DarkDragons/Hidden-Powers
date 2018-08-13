package com.warpedreality.lostpowers;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Config(modid = ModRef.MODID)
@Config.LangKey("lostPowers.config.title")
public class ModConf {
    // This values below you can access elsewhere in your mod:
    @Config.Comment("Is The Ender Tier Powered By FE/RF or not? (Requires a mod for power generation)")
    //@Config.RequiresWorldRestart
    public static boolean poweredByFE = false;

    // Ender Global
    @Config.Comment("The Max Energy Capacity for the Ender Tier Items (Requires poweredByFE to be True)")
    public static int enderEnergyMax = Integer.MAX_VALUE;
    @Config.Comment("The Max Energy Input for the Ender Tier Items (Requires poweredByFE to be True)")
    public static int enderEnergyIn = Integer.MAX_VALUE / 10;

    // Ender Staff
    @Config.Comment("The Energy Per Use on an Entity for the Ender Staff (Requires poweredByFE to be True)")
    public static int enderStaffEnergyPerUseEntity = Integer.MAX_VALUE / 1000;
    @Config.Comment("The Energy Per Use on an Boss Entity (Dragon, Wither) for the Ender Staff (Requires poweredByFE to be True)")
    public static int enderStaffEnergyPerUseEntityBoss = enderStaffEnergyPerUseEntity * 2;
    @Config.Comment("The Energy Per Use on an Block for the Ender Staff (Requires poweredByFE to be True)")
    public static int enderStaffEnergyPerUseBlock = Integer.MAX_VALUE / 1400;
    @Config.Comment("The Energy Per Use on an Boss Block (Bedrock and eventually modded blocks) for the Ender Staff (Requires poweredByFE to be True)")
    public static int enderStaffEnergyPerUseBlockBoss = Integer.MAX_VALUE / 1150;

    // Ender Bow
    @Config.Comment("The Energy Per Use on an Entity for the Ender Bow (Requires poweredByFE to be True)")
    public static int enderStaffEnergyPerUseEntityRange = Integer.MAX_VALUE / 625;

    @Mod.EventBusSubscriber(modid = ModRef.MODID)
    private static class EventHandler {

        /**
         * Inject the new values and save to the config file when the config has been changed from the GUI.
         */
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(ModRef.MODID)) {
                ConfigManager.sync(ModRef.MODID, Config.Type.INSTANCE);
            }
        }
    }
}






/*
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_ENDER_STAFF = "enderStaff";
    private static final String CATEGORY_ENDER_BOW = "enderBow";

    // This values below you can access elsewhere in your mod:
    public static boolean poweredByFE = false;

    // Ender Global
    public static int enderEnergyMax = Integer.MAX_VALUE;
    public static int enderEnergyIn = Integer.MAX_VALUE / 10;

    // Ender Staff
    public static int enderStaffEnergyPerUseEntity = Integer.MAX_VALUE / 1000;
    public static int enderStaffEnergyPerUseEntityBoss = enderStaffEnergyPerUseEntity * 2;
    public static int enderStaffEnergyPerUseBlock = Integer.MAX_VALUE / 1400;
    public static int enderStaffEnergyPerUseBlockBoss = Integer.MAX_VALUE / 1150;

    // Ender Bow
    public static int enderStaffEnergyPerUseEntityRange = 30000;
    public static int enderBowEnergyPerUseBoss = 75000;


    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            //initDimensionConfig(cfg);
        } catch (Exception e1) {
            Utils.log().error("Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        // cfg.getFoo() will get the value in the config if it is already specified there
        // It will create the value if it is not there

        if (Main.isTELoaded || Main.isEIOLoaded) {
            poweredByFE = true;
        }

        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        poweredByFE = cfg.getBoolean("poweredByFE", CATEGORY_GENERAL, poweredByFE,"Set to true for Forge Energy Support, set to False for vanilla Item Damage");
        enderEnergyMax = cfg.getInt("enderEnergyMax", CATEGORY_GENERAL, enderEnergyMax, 1, Integer.MAX_VALUE, "The max energy capacity of the Ender Staff");
        enderEnergyIn = cfg.getInt("enderEnergyIn", CATEGORY_GENERAL, enderEnergyIn, 1, Integer.MAX_VALUE, "The max energy input of the Ender Staff");

        cfg.addCustomCategoryComment(CATEGORY_ENDER_STAFF, "Ender Staff Settings");
        enderStaffEnergyPerUseEntity = cfg.getInt("enderStaffEnergyPerUseEntity", CATEGORY_ENDER_STAFF, enderStaffEnergyPerUseEntity, 1, Integer.MAX_VALUE, "The energy per use for the Ender Staff");
        enderStaffEnergyPerUseEntityBoss = cfg.getInt("enderStaffEnergyPerUseEntityBoss", CATEGORY_ENDER_STAFF, enderStaffEnergyPerUseEntityBoss, 1, Integer.MAX_VALUE, "The energy per use on a boss for the Ender Staff");
        enderStaffEnergyPerUseBlock = cfg.getInt("enderStaffEnergyPerUseBlock", CATEGORY_ENDER_STAFF, enderStaffEnergyPerUseBlock, 1, Integer.MAX_VALUE, "The energy per use on a block for the Ender Staff");
        enderStaffEnergyPerUseBlockBoss = cfg.getInt("enderStaffEnergyPerUseBlockBoss", CATEGORY_ENDER_STAFF, enderStaffEnergyPerUseBlockBoss, 1, Integer.MAX_VALUE, "The energy per use on a block boss (Bedrock or other unbreakable blocks) for the Ender Staff");

        cfg.addCustomCategoryComment(CATEGORY_ENDER_BOW, "Ender Bow Settings");
        enderStaffEnergyPerUseEntityRange = cfg.getInt("enderStaffEnergyPerUseEntityRange", CATEGORY_ENDER_BOW, enderStaffEnergyPerUseEntityRange, 1, Integer.MAX_VALUE, "The energy per use for the Ender Bow");
        enderBowEnergyPerUseBoss = cfg.getInt("enderBowEnergyPerUseBoss", CATEGORY_ENDER_BOW, enderBowEnergyPerUseBoss, 1, Integer.MAX_VALUE, "The energy per use on a boss for the Ender Bow");
    }

    public static void PreInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "lost-powers.cfg"));
        ModConf.readConfig();
    }

    public static void Init(FMLInitializationEvent event) {

    }

    public static void PostInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }
*/