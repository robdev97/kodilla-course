package com.kodilla.examrepeat.oop.zad3;

public class Car extends Vehicle {

    private String fuelType;

    public Car(String make, String model, int year, String fuelType) {
        super(make, model, year);
        this.fuelType = fuelType;

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel type is: " + fuelType);
    }
}
