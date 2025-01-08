
package com.kodilla.patterns.challenges;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(User user, Product product) {
        System.out.println("Processing order for: " + user.getName() + " - Product: " + product.getName());
        return true;
    }
}