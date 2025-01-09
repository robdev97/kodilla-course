package com.kodilla.patterns.food2door;

public class OrderProcessor {

    private final Producer producer;

    public OrderProcessor(Producer producer) {
        this.producer = producer;
    }

    void processOrder(String product, int quantity) {
        System.out.println("Processing order.....");
        boolean isSuccessful = producer.process(product, quantity);
        if (isSuccessful) {
            System.out.println("Order for " + quantity + " of " + product + " has been processed.");
        } else {
            System.out.println("Order for " + quantity + " of " + product + " failed.");
        }
    }
}
