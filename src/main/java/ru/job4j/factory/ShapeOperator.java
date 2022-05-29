package ru.job4j.factory;

public abstract class ShapeOperator {
    public abstract Shape createShape();
    public void showInfo() {
        Shape shape = createShape();
        System.out.println(shape.draw());
        System.out.println("Площадь фигуры равна: " + shape.square());
    }
}