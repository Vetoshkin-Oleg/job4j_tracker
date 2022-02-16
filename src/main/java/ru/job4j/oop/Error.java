package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printError();
        Error error = new Error(true, 7, "MESSAGE");
        error.printError();
        Error errorAnother = new Error(false, 0, "never");
        errorAnother.printError();
    }

    public void printError() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }
}
