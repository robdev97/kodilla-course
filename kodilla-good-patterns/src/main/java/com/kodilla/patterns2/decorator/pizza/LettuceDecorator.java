package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns.builder.pizza.Pizza;

import java.math.BigDecimal;

public class LettuceDecorator extends AbstractPizzaOrderDecorator {
    public LettuceDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("2"));
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " + lettuce";
    }
}
