package com.kodilla.testing.collection;

import java.util.LinkedList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer>  numbersExterminator = new LinkedList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                numbersExterminator.add(number) ;
            }
        }
        return numbersExterminator;
    }

}
