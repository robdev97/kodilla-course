package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int result1 = calculator.add(10, 5);
        System.out.println(result1);

        if(result1 == 15) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test FAILED");
        }

        int result2 = calculator.subtract(10, 5);
        System.out.println(result2);

        if(result2 == 5) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test FAILED");
        }
    }
}
