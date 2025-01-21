package com.kodilla.examrepeat.oop.zad2;

public class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Cats sounds is: MIAU");
    }

    @Override
    public void move() {
        System.out.println("Cat jumps");
    }
}
