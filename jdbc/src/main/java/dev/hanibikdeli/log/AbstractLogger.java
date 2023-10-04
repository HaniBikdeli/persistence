package dev.hanibikdeli.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractLogger {
    protected static final Logger logger = LogManager.getLogger(AbstractLogger.class.getName());
}
