package dev.pfaff.voidsmysteries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IHasLogger {
	default Logger getLogger() { return LogManager.getLogger(this.getClass()); }
}
