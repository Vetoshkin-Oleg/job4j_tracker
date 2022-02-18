package ru.job4j.inheritance;

public class Builder extends Engineer {
    private boolean fearOfHeights = false;

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Builder(String name, String surname, String education, String birthday, boolean fearOfHeights) {
        super(name, surname, education, birthday);
        this.fearOfHeights = fearOfHeights;
    }

    public boolean isFearOfHeights() {
        return fearOfHeights;
    }
}
