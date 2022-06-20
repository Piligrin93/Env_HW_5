package ru.skypro;

import java.util.Objects;

public class Validator {

    private static final String VALID_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private Validator() {
    }

    public static boolean check(String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20 символов");
        }
        if (!containsValidSymbols(login)) {
            throw new WrongLoginException("Логин содержит неверные символы");
        }
        if (isNotValidPassword(password) || isNotValidPassword(confirmPassword)) {
            throw new WrongPasswordException("Длина пароля должна быть меньше 20 символов");
        }
        if (!containsValidSymbols(password)) {
            throw new WrongPasswordException("Пароль содержит неверные символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }

    private static boolean isNotValidPassword(String password) {
        return Objects.isNull(password) || password.length() >= 20;
    }

    private static boolean containsValidSymbols(String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
                if (!VALID_SYMBOLS.contains(String.valueOf(symbols))) {
                    return false;
                }
            }
        return true;
    }
}
