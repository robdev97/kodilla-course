package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }
    @Test
    void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Basic pizza with cheese and tomato sauce", description);
    }
    @Test
    void testFullOptionPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new LettuceDecorator(pizzaOrder);
        pizzaOrder = new CornDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(29), calculatedCost);
    }
    @Test
    void testFullOptionPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new LettuceDecorator(pizzaOrder);
        pizzaOrder = new CornDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Basic pizza with cheese and tomato sauce + ham + mushrooms + lettuce + corn", description);
    }
}
