package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String orthodontist = "Я - ортодонт";

    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Dentist(String name, String surname, String education, String birthday, String orthodontist) {
        super(name, surname, education, birthday);
        this.orthodontist = orthodontist;
    }

    public String getOrthodontist() {
        return orthodontist;
    }
}
