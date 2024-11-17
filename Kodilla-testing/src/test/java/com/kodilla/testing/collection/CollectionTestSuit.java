package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTestSuit {


    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");

    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }


    @DisplayName("Test when the list is empty")

    @Test

    public void testOddNumbersExterminator() {

        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> numbers = new LinkedList<>();

        //When

        List<Integer> result = exterminator.exterminate(numbers);


        //Then
        Assertions.assertTrue(result.isEmpty(), "The resultshould be an empty List");
    }

    @DisplayName ("Test when list contains odd and even numbers")

    @Test

    public void testOddNumbersExterminatorNormalList() {


        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);


        //When
        List<Integer> result = exterminator.exterminate(numbers);


        //Then
        List<Integer> expected = new LinkedList<>();
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(8);
        expected.add(10);

        Assertions.assertEquals(expected, result);

    }
}

