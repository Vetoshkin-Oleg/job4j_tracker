package ru.job4j.inheritance;

public class Engineer extends Profession {
    private Plan plan;

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Plan planning(Task task) {
        return new Plan();
    }
}
