package ru.skypro;

public class Main {

    public static void main(String[] args) {
        boolean result = Validator.check("ABCD123wqedqwdqwdqwwqr", "ABCD123", "ABCD");
        if (result) {
            System.out.println("Логин и пароль корректны");
        } else {
            System.out.println("Логин и/или пароль некоректны");
        }
    }
}
