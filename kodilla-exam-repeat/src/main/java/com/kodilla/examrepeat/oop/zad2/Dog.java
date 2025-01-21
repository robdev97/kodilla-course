package com.kodilla.examrepeat.oop.zad2;

public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Dogs sounds is: WOOF!");
    }

    @Override
    public void move() {
        System.out.println("Dog runs");
    }
}
