package com.kodilla.patterns.challenges;

public class OrderProcessor {

    private final InformationService informationService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
