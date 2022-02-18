package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialization = "Я - кардиохирург";

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon(String name, String surname, String education, String birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
