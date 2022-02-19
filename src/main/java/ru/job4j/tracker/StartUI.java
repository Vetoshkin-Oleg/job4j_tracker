package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime dateItem = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateItemFormat = dateItem.format(formatter);
        System.out.println(dateItemFormat);
    }
}
