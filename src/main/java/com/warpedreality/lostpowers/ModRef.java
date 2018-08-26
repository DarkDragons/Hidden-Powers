package com.warpedreality.lostpowers;

import java.util.Arrays;
import java.util.List;

public class ModRef {
    // Mod Info
    public static final String
            MODID = "lostpowers",
            NAME = "Lost Powers",
            DESC = "Adds a mechanism to get Bedrock, More Health and More!",
            CREDITS = "Loremaster's amazing Minecraft Forge tutorials",
            VERSION = "3.0",
            ACCEPTED_VERSIONS = "1.12.2";
    public static final List<String> AUTHOR = Arrays.asList(new String[] { "WarpedReality" });

    // Proxies
    public static final String CLIENT_PROXY_CLASS = "com.warpedreality.lostpowers.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.warpedreality.lostpowers.proxy.CommonProxy";

    // Other

}
