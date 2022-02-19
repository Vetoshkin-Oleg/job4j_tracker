package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иван");
        student.setSurname("Кузнецов");
        student.setPatronymic("Сергеевич");
        student.setGroup("КС-216");
        student.setReceiptDate(new Date());
    }
}
