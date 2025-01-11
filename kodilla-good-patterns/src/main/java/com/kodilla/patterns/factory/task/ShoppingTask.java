package com.kodilla.patterns.factory.task;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final int quantity;
    private boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, int quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Buying " + quantity + " of " + whatToBuy);
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}