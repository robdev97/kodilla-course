package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTestSuite {

    @Test
    void testLogAndGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;

        //When
        logger.log("First log message");
        String result = logger.getLastLog();

        //Then
        assertEquals("First log message", result);
    }

    @Test
    void testGetHistoryLog() {
        //Given
        Logger logger = Logger.INSTANCE;

        //When
        logger.log("First History log");
        logger.log("Second History log");
        List<String> history = logger.getLogHistory();

        //Then
        assertEquals(2, history.size());
        assertTrue(history.get(0).contains("First History log"));
        assertTrue(history.get(1).contains("Second History log"));
    }
}
