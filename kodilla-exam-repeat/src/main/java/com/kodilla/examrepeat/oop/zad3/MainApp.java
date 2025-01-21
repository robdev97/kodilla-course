package com.kodilla.examrepeat.oop.zad3;

public class MainApp {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Generic", "Model X", 2020);
        vehicle.displayInfo();

        System.out.println();

        Vehicle car = new Car("Toyota", "Avensis", 2024, "Gasooolina");
        car.displayInfo();

        System.out.println();

        Vehicle polymorphVehicle = new Car("Lamborghini", "Aventador", 2025, "Gasolina");
        polymorphVehicle.displayInfo();
    }
}
