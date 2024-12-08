package com.kodilla.stream;

import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain3 {

    public static void main(String[] args) {

        System.out.println("Using stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
