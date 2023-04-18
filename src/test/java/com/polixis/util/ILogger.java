package com.polixis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ILogger {
    private static final Logger LOGGER = LogManager.getLogger(ILogger.class);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private ILogger() {
    }

    public static String getGreenColor() {
        return ANSI_GREEN;
    }

    public static String getResetColor() {
        return ANSI_RESET;
    }

    public static void info(String message) {
        LOGGER.info(getGreenColor() + message + getResetColor());
    }

    public static void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }
}