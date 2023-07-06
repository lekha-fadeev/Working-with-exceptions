import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        loginPasswordVerification("login","password","password");

        loginPasswordVerification("логин","password","password");

        loginPasswordVerification("login","пороль","password");

        loginPasswordVerification("login","password","passwor");
    }

    public static void loginPasswordVerification(String login, String password, String confirmPassword) {
        try {
         loginVerification (login);
         passwordVerification (password, confirmPassword);
        } catch ( WrongLoginException | WrongPasswordException e) {
         e.printStackTrace();
        } finally {
         System.out.println("Проверка проведена");
        }
    }


    private static void loginVerification (String login) throws WrongLoginException {
        Pattern p = Pattern.compile("^[a-z0-9_-]{1,28}$");
        if (!p.matcher(login).matches()){
            throw new WrongLoginException("Неверный логин: " + login);
        }
    }
    private static void passwordVerification (String password, String confirmPassword) throws WrongPasswordException {
        Pattern p = Pattern.compile("^[a-z0-9_-]{1,28}$");
        if (!p.matcher(password).matches()){
            throw new WrongPasswordException("Неверный пороль: " + password);
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}