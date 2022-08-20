package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс для создания пользователя банка
 * @author Vetoshkin Oleg
 * @version 1.0
 */
public class User {
    /**
     * Класс содержит следующие поля:
     * passport - номер паспорта;
     * username - ФИО.
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     *
     * @return возвращает значение паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     *
     * @param passport
     * позволяет установить значение паспорта для пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     *
     * @return возвращает ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * Метод присваивает пользователю ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}