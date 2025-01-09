package com.kodilla.patterns.food2door;

public class ExtraFoodShop implements Producer {

    @Override
    public boolean process (String product, int quantity) {

        System.out.println("ExtraFoodShop is processing order for " + quantity
        + " of " + product);
        return true;
    }
}
