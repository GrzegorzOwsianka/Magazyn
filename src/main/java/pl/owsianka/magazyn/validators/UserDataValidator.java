package pl.owsianka.magazyn.validators;

import pl.owsianka.magazyn.exceptions.ValidationException;

public class UserDataValidator {
    public static void validateLogin(String login) {
        if (login.length() < 5) {
            throw new ValidationException();
        }
    }

    public static void validatePassword(String password) {
        if (password.length() < 5) {
            throw new ValidationException();
        }
    }

    public static void validatePasswordMatch(String password1, String password2) {
        if (!password1.equals(password2)) {
            throw new ValidationException();
        }
    }
}
