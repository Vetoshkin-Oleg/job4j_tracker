package ru.job4j.factory;

import java.util.Scanner;

public class Canvas {
    private ShapeOperator shapeOperator;

    public Canvas(ShapeOperator shapeOperator) {
        System.out.println("444");
        this.shapeOperator = shapeOperator;
        System.out.println("555");
    }

    public void demonstrate() {
        System.out.println("777");
        this.shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator;
        System.out.print("Какую фигуру вы хотите построить: ");
        String ans = input.nextLine();
        if ("прямоугольник".equals(ans)) {
            operator = new RectangleOperator();
        } else {
            System.out.println("111");
            operator = new TriangleOperator();
            System.out.println("222");
        }
        System.out.println("333");
        Canvas canvas = new Canvas(operator);
        System.out.println("666");
        canvas.demonstrate();
    }
}