package com.kodilla.patterns.food2door;

public class Food2DoorApp {

    public static void main(String[] args) {
        Producer extraFoodShop = new ExtraFoodShop();
        Producer healthyShop = new HealthyShop();
        Producer glutenFreeShop = new GlutenFreeShop();

        OrderProcessor order1 = new OrderProcessor(extraFoodShop);
        order1.processOrder("Milk, Potatoes, Passatta, Pomodoro", 10);

        OrderProcessor order2 = new OrderProcessor(healthyShop);
        order2.processOrder("Anty-age skin protector", 15);

        OrderProcessor order3 = new OrderProcessor(glutenFreeShop);
        order3.processOrder("Gluten-free Pasta", 30);
    }
}
