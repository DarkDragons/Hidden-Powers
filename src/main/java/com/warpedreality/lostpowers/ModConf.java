package com.warpedreality.lostpowers;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Config(modid = ModRef.MODID)
@Config.LangKey("lostPowers.config.title")
public class ModConf {

    @Config.LangKey("lostPowers.config.general")
    public static General general = new General();
    @Config.LangKey("lostPowers.config.enderStaff")
    public static EnderStaff enderStaff = new EnderStaff();
    @Config.LangKey("lostPowers.config.enderArmor")
    public static EnderArmor enderArmor = new EnderArmor();
    @Config.LangKey("lostPowers.config.soul")
    public static Soul soul = new Soul();


    public static class General {
        @Config.Comment("Is The Ender Tier Powered By FE/RF or not? (Requires a mod for power generation)")
        public boolean poweredByFE = false;
        @Config.Comment("The Max Energy Capacity for the Ender Tier Items (Requires poweredByFE to be True)")
        public int enderEnergyMax = Integer.MAX_VALUE;
        @Config.Comment("The Max Energy Input for the Ender Tier Items (Requires poweredByFE to be True)")
        public int enderEnergyIn = Integer.MAX_VALUE / 10;
    }

    public static class EnderStaff {
        @Config.Comment("The Energy Per Use on an Entity for the Ender Staff (Ineffective unless poweredByFE is True)")
        public int enderStaffEnergyPerUseEntity = Integer.MAX_VALUE / 1000;
        @Config.Comment("The Energy Per Use on an Boss Entity (Dragon, Wither) for the Ender Staff (Ineffective unless poweredByFE is True)")
        public int enderStaffEnergyPerUseEntityBoss = enderStaffEnergyPerUseEntity * 2;
        @Config.Comment("The Energy Per Use on an Block for the Ender Staff (Ineffective unless poweredByFE is True)")
        public int enderStaffEnergyPerUseBlock = Integer.MAX_VALUE / 1400;
        @Config.Comment("The Energy Per Use on an Boss Block (Bedrock and eventually modded blocks) for the Ender Staff (Ineffective unless poweredByFE is True)")
        public int enderStaffEnergyPerUseBlockBoss = Integer.MAX_VALUE / 1150;
        @Config.Comment("The Energy Per Use on an Entity for the Ender Bow (Ineffective unless poweredByFE is True)")
        public int enderStaffEnergyPerUseEntityRange = Integer.MAX_VALUE / 625;
        @Config.Comment("The amount of damage the Void Fragments do when shot from the Ender Staff")
        public int enderStaffVoidFragmentDamage = 100;
    }

    public static class EnderArmor {
        @Config.Comment("The Energy Used Per Hit on a Player wearing a full set of Ender Armor (Ineffective unless poweredByFE is True)")
        public int baseEnergyPerHit = 858994;
        @Config.Comment("The Energy Used Per Tick on a Player wearing the Ender Chestplate (Ineffective unless poweredByFE is True)")
        public int passiveEnergyUsageHelm = 1000;
        @Config.Comment("The Energy Used Per Tick on a Player wearing the Ender Chestplate (Ineffective unless poweredByFE is True)")
        public int passiveEnergyUsageChestplate = 1000;
        @Config.Comment("The Energy Used Per Tick on a Player wearing the Ender Chestplate (Ineffective unless poweredByFE is True)")
        public int passiveEnergyUsageLeggings = 1000;
        @Config.Comment("The Energy Used Per Tick on a Player wearing the Ender Chestplate (Ineffective unless poweredByFE is True)")
        public int passiveEnergyUsageBoots = 1000;
        @Config.Comment("The Energy Per Attack Multiplier (baseEnergyPerHit*attackEnergyDrainMultiplier)")
        public int attackEnergyDrainMultiplier = 1;
    }

    public static class Soul {
        @Config.Comment("The amount of health the Soul heals")
        public int soulHealHealth = 2;
        @Config.Comment("The amount of hunger the Soul heals")
        public int soulHealHunger = 2;
        @Config.Comment("The amount of bonus health the Soul Capsule gives")
        public int soulCapuleBonus = 4;
    }

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
    private  final String CATEGORY_GENERAL = "general";
    private  final String CATEGORY_ENDER_STAFF = "enderStaff";
    private  final String CATEGORY_ENDER_BOW = "enderBow";

    // This values below you can access elsewhere in your mod:
    public  boolean poweredByFE = false;

    // Ender Global
    public  int enderEnergyMax = Integer.MAX_VALUE;
    public  int enderEnergyIn = Integer.MAX_VALUE / 10;

    // Ender Staff
    public  int enderStaffEnergyPerUseEntity = Integer.MAX_VALUE / 1000;
    public  int enderStaffEnergyPerUseEntityBoss = enderStaffEnergyPerUseEntity * 2;
    public  int enderStaffEnergyPerUseBlock = Integer.MAX_VALUE / 1400;
    public  int enderStaffEnergyPerUseBlockBoss = Integer.MAX_VALUE / 1150;

    // Ender Bow
    public  int enderStaffEnergyPerUseEntityRange = 30000;
    public  int enderBowEnergyPerUseBoss = 75000;


    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public  void readConfig() {
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

    private  void initGeneralConfig(Configuration cfg) {
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

    public  void PreInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "lost-powers.cfg"));
        ModConf.readConfig();
    }

    public  void Init(FMLInitializationEvent event) {

    }

    public  void PostInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }
*/