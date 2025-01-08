package com.kodilla.patterns.challenges;

public class ProductOrderApp {

    public static void main(String[] args) {
        User user = new User("Robert Litwiński", "roblit97@gmail.com");
        Product product = new Product("Projektor");
        OrderRequest orderRequest = new OrderRequest(user, product);

        InformationService informationService = new EmailInformationService();
        OrderService orderService = new ProductOrderService();
        OrderRepository orderRepository = new InMemoryOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(informationService, orderService, orderRepository);

        OrderDto orderDto = orderProcessor.process(orderRequest);

        System.out.println("Order status for " + orderDto.getUser().getName() + ": " + (orderDto.isOrdered() ? "SUCCESS" : "FAILED"));
    }
}

