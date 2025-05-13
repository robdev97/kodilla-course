package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns.builder.pizza.Pizza;

import java.math.BigDecimal;

public class MushroomsDecorator extends AbstractPizzaOrderDecorator {
    public MushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " + mushrooms";
    }
}
