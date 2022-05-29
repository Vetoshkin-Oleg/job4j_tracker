package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        String temp = this.getName();
        System.out.println((temp.equals("A380") ? "Количество двигателей равно: 4" : "Количество двигателей равно: " + COUNT_ENGINE));
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}