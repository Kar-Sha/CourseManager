package CourseManager;

public class Main {
    public static void main(String[] args) {
        Authenticate auth = new Authenticate();
        LoginPage login = new LoginPage(auth.getLogin());
    }
}
