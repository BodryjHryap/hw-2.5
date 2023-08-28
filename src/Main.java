import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String userLogin = "12345";
        String userPassword = "1122334455";
        String confirmUserPassword = "1122334455";

        try {
            checkLoginAndPasswords(userLogin, userPassword, confirmUserPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка логина и пароля пользователя выполнена!");
        }

    }

    public static void checkLoginAndPasswords(String login, String password, String confirmPassword) {
        loginIsCorrect(login);
        passwordIsCorrect(password);
        passwordsIsEqual(password, confirmPassword);
    }

    private static void loginIsCorrect(String login) throws WrongLoginException {

        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Логин '" + login + "' должен содержать в себе только латинские буквы, цифры и знак подчеркивания, а так же состоять не более, чем из 20 символов.");
        }
    }

    public static void passwordIsCorrect(String password) throws WrongPasswordException {

        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания, а так же состоять не более, чем из 20 символов.");
        }
    }

    public static void passwordsIsEqual(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ваши пароли не совпадают");
        }
    }
}