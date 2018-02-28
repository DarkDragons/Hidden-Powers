package com.tastycake.obsidianstuff.utils;

import com.tastycake.obsidianstuff.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
    private static Logger logger;

    public static Logger log()
    {
        if (logger == null)
        {
            logger = LogManager.getFormatterLogger(Reference.MODID);
        }
        return logger;
    }
}
