package com.kodilla.testing.shape;

public class Square implements Shape {

    private double sideLenght;

    public Square(double sideLenght) {
        this.sideLenght = sideLenght;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return sideLenght * sideLenght;
    }
}
