package com.kodilla.patterns.factory.task;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task createTask(String taskType) {
        return switch (taskType) {
            case SHOPPING -> new ShoppingTask("Shopping task", "Chocolate", 2);
            case PAINTING -> new PaintingTask("Painting task", "Blue", "Room");
            case DRIVING -> new DrivingTask("Driving task", "Katowice", "Car");
            default -> null;
        };
    }
}
