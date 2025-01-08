package com.kodilla.patterns.challenges;

public class InMemoryOrderRepository implements OrderRepository {

    @Override
    public void createOrder(User user, Product product) {
        System.out.println("Saving order for: " + user.getName()
                + " - Product: " + product.getName());
    }
}

