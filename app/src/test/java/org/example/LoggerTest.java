package org.example;

import org.example.core_data.Logger;
import org.example.core_data.LoggerConsoleSimple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    @Test
    void testInterfaceExists() {
        assertDoesNotThrow(() -> {
            Class.forName("org.example.core_data.Logger");
        });
    }

    @Test
    void testHasLoggerStartupMethod() {
        assertDoesNotThrow(() -> Logger.class.getMethod("loggerStartup"));
    }

    @Test
    void testHasLoggerWriteDataMethod() {
        assertDoesNotThrow(() -> Logger.class.getMethod("loggerWriteData"));
    }

    @Test
    void testLoggerConsoleSimpleImplementsInterface() {
        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        assertTrue(logger instanceof Logger);
    }

    @Test
    void testLoggerConsoleSimpleOverridesMethods() {
        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        assertDoesNotThrow(() -> {
            logger.loggerStartup();
            logger.loggerWriteData();
        });
    }
}
