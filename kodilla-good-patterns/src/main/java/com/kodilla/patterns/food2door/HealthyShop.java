package com.kodilla.patterns.food2door;

public class HealthyShop implements Producer {

    @Override
    public boolean process(String product, int quantity) {

        System.out.println("HealthyShop is processing order for " + quantity
                + " of " + product);
        return quantity < 50;
    }
}

