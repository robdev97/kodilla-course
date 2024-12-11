package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTest {

    @Test
    void testProbablyWillThrowExceptionValidInputs() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When&Then
        assertDoesNotThrow(() -> {
            String result = secondChallenge.probablyWillThrowException(1.5, 2.0);
            assertEquals("Done!", result);
        });
    }

    @Test
    void testProbablyWillThrowExceptionTooLowInputsX() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When&Then
        Exception exception = assertThrows(Exception.class, () -> {
            secondChallenge.probablyWillThrowException(0.5, 2.0);
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testProbablyWillThrowExceptionTooHighInputsX() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When&Then
        Exception exception = assertThrows(Exception.class, () -> {
            secondChallenge.probablyWillThrowException(2.5, 2.0);
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testProbablyWillThrowExceptionInvalidY() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When&Then
        Exception exception = assertThrows(Exception.class, () -> {
            secondChallenge.probablyWillThrowException(1.5, 1.5);
        });
        assertEquals(null, exception.getMessage());
    }
}
