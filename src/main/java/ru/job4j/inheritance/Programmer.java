package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String programmingLanguage = "Java";

    public Programmer(String name, String surname, String education, String birthday, String programmingLanguage) {
        super(name, surname, education, birthday);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}
