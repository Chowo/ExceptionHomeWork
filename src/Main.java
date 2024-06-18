import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        checkUser("AA_9dfgsdadfasdfsdfs", "12345_6", "12345_6");

    }

    public static void checkUser(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Логин не соответствует требованиям.\n" +
                    "Проверьте чтобы длина не превышала 20 символов и использовались только цифры, латинский алфавит и знак нижнего подчеркивания");
        } catch (WrongPasswordException e) {
            System.out.println("Неверный пароль или пароль не удовлетворяет требованиям.\n" +
                    "Проверьте чтобы длина не превышала 20 символов и использовались только цифры, латинский алфавит и знак нижнего подчеркивания");
        }finally {
            System.out.println("Проверка завершена");
        }

    }

    public static void check (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String regex = "^[A-Za-z0-9_]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher loginMatcher = pattern.matcher(login);
        Matcher passwordMatcher = pattern.matcher(password);
        if (login.length() > 20 || !loginMatcher.matches()) {
            throw new WrongLoginException();
        }
        if (password.length() > 20 || !passwordMatcher.matches() || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }

    }

}


