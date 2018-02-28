package com.tastycake.obsidianstuff;

import java.util.Arrays;
import java.util.List;

public class Reference {
    // Mod Info
    public static final String
            MODID = "tcos",
            NAME = "Obsidian Stuff",
            DESC = "Adds a whole line of obsidian-based tools and such.",
            CREDITS = "Thank you Loremaster for your amazing tutorials",
            VERSION = "1.0",
            ACCEPTED_VERSIONS = "1.12.2";
    public static final List<String> AUTHOR = Arrays.asList(new String[] { "TastyCake" });

    // Proxies
    public static final String CLIENT_PROXY_CLASS = "com.tastycake.obsidianstuff.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.tastycake.obsidianstuff.proxy.CommonProxy";
    //public static final String SERVER_PROXY_CLASS = "com.tastycake.obsidianstuff";
}
