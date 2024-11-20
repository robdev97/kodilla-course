package com.kodilla.testing.shape;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Here is space to test shapes")
public class ShapeCollectorTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("This is the beginnning of tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("This is the end of tests");
    }

    @Nested
    @DisplayName("Test showing adding and removing shapes")
    class AddAndRemoveTest {

        @Test
        @DisplayName("Should add a shape to collection")
        void testAddFigure() {

            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5.0);

            //When
            collector.addFigure(circle);

            //Then
            Assertions.assertEquals(1, collector.showFigure().size());
            Assertions.assertEquals("Circle with field: 78.53981633974483", collector.showFigure().get(0));
        }

        @Test
        @DisplayName("Test removing a figure")
        void testRemoveFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5.0);
            collector.addFigure(circle);
            //When
            collector.removeFigure(circle);
            //Then
            Assertions.assertEquals(0, collector.showFigure().size());
        }
    }
    @Nested
    @DisplayName("Test for getFigure method")
    class GetFigureTest {

        @Test
        @DisplayName("Getting a figure")
        void testGetFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5.0);
            collector.addFigure(circle);

            //When
            Shape result = collector.getFigure(0);

            //Then
            Assertions.assertEquals(circle.getShapeName(), result.getShapeName());
            Assertions.assertEquals(circle.getField(), result.getField());

        }

    }
}
