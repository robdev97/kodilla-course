package com.kodilla.patterns.food2door;

public class GlutenFreeShop implements Producer {

    @Override
    public boolean process (String product, int quantity) {

        System.out.println("GluterFreeShop is processing order for " + quantity
                + " of " + product);
        return product.toLowerCase().contains("gluten");

    }
}
