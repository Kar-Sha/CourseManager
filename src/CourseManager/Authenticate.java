package CourseManager;

import java.util.HashMap;
import java.util.Map;

public class Authenticate 
{	
	private Map<String, Student> students;
	
	public Authenticate()
	{
		this.students = new HashMap<>();
	}
	/*
	 * Checks if entered email belongs to student, would then send a password change
	 * 	email to student via email to change the password
	 * 
	 *  how are we gonna implement this?
	 *  
	 *  @Param email: email of student account to be checked
	 *  
	 *  @Return boolean if the email belongs to a registered student or not
	 */
	public boolean forgotPassword(String email)
	{
		return false;
	}
	
	/*
	 * Initalizes a new student if a student with the same email doesn't exist
	 * 	otherwise returns false
	 * 
	 * TODO: Create a error class
	 * 
	 * @Params: self explanitory
	 * 
	 * @Return true if a student with the provided email doesn't exist and upon sucessful creation of
	 * 	new student; false otherwise
	 */
	public boolean signUp(
			String firstName,
			String lastName,
			String email,
			String password,
			String major)
	{
		return false;
	}
	
	/*
	 * Logs into existing student account, throws error if email or password to not match existing student
	 * or if email is not registered
	 * 
	 * @Params: also self explanatory
	 * 
	 * @Return true if successfully able to login (email and password are valid), false otherwise
	 */
	public boolean login(
			String email,
			String password)
	{
		return false;
	}
}
