package com.kodilla.spring.calculator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        //Then
        assertEquals(10, calculator.add(5,5), 0.01);
        assertEquals(0, calculator.sub(5, 5), 0.001);
        assertEquals(25, calculator.mul(5, 5), 0.01);
        assertEquals(1, calculator.div(5, 5), 0.01);
    }
}
