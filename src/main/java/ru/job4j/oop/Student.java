package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(3);
        jukebox.music(2);
        jukebox.music(1);
    }

    public void song() {
        System.out.println("I believe I can fly");
    }
}