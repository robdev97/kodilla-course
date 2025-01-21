package com.kodilla.examrepeat.oop.zad2;

public class App {

    public static void main(String[] args) {


        Animal[] animals = {new Animal(), new Dog(), new Cat()};


        for(Animal animal : animals) {
            animal.makeSound();

        }
        for(Animal animal : animals) {
            animal.move();
        }

    }
}
