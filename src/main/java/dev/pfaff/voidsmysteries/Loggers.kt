package dev.pfaff.voidsmysteries

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Loggers {
    @JvmStatic
    private val namedLoggers: LinkedHashMap<String, Logger> = LinkedHashMap()

    @JvmStatic
    private val clazzedLoggers: LinkedHashMap<Class<*>, Logger> = LinkedHashMap()

    @JvmStatic
    operator fun get(name: String): Logger {
        if (!namedLoggers.contains(name)) namedLoggers[name] = LogManager.getLogger(name)

        return namedLoggers[name]!!
    }

    @JvmStatic
    operator fun get(clazz: Class<*>): Logger {
        if (!clazzedLoggers.contains(clazz)) clazzedLoggers[clazz] = LogManager.getLogger(clazz)

        return clazzedLoggers[clazz]!!
    }
}