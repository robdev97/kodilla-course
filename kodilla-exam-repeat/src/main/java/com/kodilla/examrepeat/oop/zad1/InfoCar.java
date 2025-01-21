package com.kodilla.examrepeat.oop.zad1;

public class InfoCar {

    public static void main(String[] args) {

        Car car1 = new Car("Honda", "Civic", 2015);
        Car car2 = new Car("Honda", "Civic", 2015);
        Car car3 = new Car("Honda", "Civic", 2015);

        car1.printDetails();
        car2.printDetails();
        car3.printDetails();
    }
}
