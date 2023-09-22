package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name)
                && Objects.equals(created.getDayOfMonth(), item.created.getDayOfMonth())
                && Objects.equals(created.getMonth(), item.created.getMonth())
                && Objects.equals(created.getDayOfWeek(), item.created.getDayOfWeek())
                && Objects.equals(created.getYear(), item.created.getYear())
                && Objects.equals(created.getHour(), item.created.getHour())
                && Objects.equals(created.getMinute(), item.created.getMinute());
                /*&& Objects.equals(created.getSecond(), item.created.getSecond());*/
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        result = 31 * result + created.getDayOfMonth();
        result = 31 * result + created.getMonth().hashCode();
        result = 31 * result + created.getDayOfWeek().hashCode();
        result = 31 * result + created.getYear();
        result = 31 * result + created.getHour();
        result = 31 * result + created.getMinute();
        /*result = 31 * result + created.getSecond();*/
        return result;
    }
}