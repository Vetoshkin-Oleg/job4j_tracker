package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 462);
        Book learningJava = new Book("Learning Java", 565);
        Book learningJS = new Book("Learning JavaScript", 350);
        Book learningSQL = new Book("Learning SQL", 337);

        Book[] library = new Book[4];
        library[0] = cleanCode;
        library[1] = learningJava;
        library[2] = learningJS;
        library[3] = learningSQL;

        for (int index = 0; index < library.length; index++) {
            Book book = library[index];
            System.out.println(book.getName() + " - " + book.getAmountOfPages());
        }

        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;

        for (int index = 0; index < library.length; index++) {
            Book book = library[index];
            System.out.println(book.getName() + " - " + book.getAmountOfPages());
        }

        for (Book x : library) {
            if ("Clean code".equals(x.getName())) {
                System.out.println(x.getName());
            }
        }
    }
}