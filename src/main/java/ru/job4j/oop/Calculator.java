package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double divide(int a) {
        return a / (double) x;
    }

    public double sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println(resultSum);
        int resultMinus = Calculator.minus(3);
        System.out.println(resultMinus);
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(5);
        System.out.println(rslMultiply);
        double rslDivide = calculator.divide(27);
        System.out.println(rslDivide);
        double rslSumAll = calculator.sumAllOperation(54);
        System.out.println(rslSumAll);
    }

}