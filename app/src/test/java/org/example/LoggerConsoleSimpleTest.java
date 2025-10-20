package org.example;

import org.example.core_data.LoggerConsoleSimple;
import org.example.core_data.Logger;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerConsoleSimpleTest {

    @Test
    void testLoggerStartupCreatesFile() {

        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        logger.loggerStartup();
        File file = new File("logfile.txt");
        assertTrue(file.exists());
    }

    @Test
    void testLoggerWriteGamesPlayedAppendsFile() {

        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        logger.loggerWriteGamesPlayed(3);
        File file = new File("logfile.txt");
        assertTrue(file.length() > 0);
    }

    @Test
    void testWriteGameWinStatusPlayerOne() {

        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        logger.writeGameWinStatus(1);
        File file = new File("logfile.txt");
        assertTrue(file.exists());
    }

    @Test
    void testWriteGameWinStatusPlayerTwo() {

        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        logger.writeGameWinStatus(2);
        File file = new File("logfile.txt");
        assertTrue(file.exists());
    }

    @Test
    void testImplementsLoggerInterface() {

        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        assertTrue(logger instanceof Logger);
    }
}
