package CourseManager;

public class Main {
	
	public static final int SIDE_SIZE = 420;
	
    public static void main(String[] args) {
        Authenticate auth = new Authenticate();
        LoginPage login = new LoginPage(auth.getLogin(), 0, 0);
    }
}
