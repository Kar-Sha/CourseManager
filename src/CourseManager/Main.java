package CourseManager;

public class Main {
	
	public static final int SIDE_SIZE = 420;
	
    public static void main(String[] args) {
        new LoginPage(null, SIDE_SIZE, SIDE_SIZE);
        DBConnection.loadConnection(); //DO NOT DELETE FOR NOW, THIS LINE IS USED TO TEST YOUR DATABASE CONNECTION
    }
}
