package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Транспорт движется");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Возможно перевезти " + passengers + " пассажиров");
    }

    @Override
    public double refuel(double fuel) {
        double price = 1;
        return fuel * price;
    }
}
