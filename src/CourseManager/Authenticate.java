package CourseManager;

import java.util.HashMap;

public class Authenticate {
    HashMap<String, String> login = new HashMap<String, String>();

	Authenticate(){
		login.put("user", "password");
		login.put("student", "password");
	}

	protected HashMap getLogin(){
		return login;
	}

}
