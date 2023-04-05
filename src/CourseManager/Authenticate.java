package CourseManager;

public class Authenticate 
{
	private String username; // perhaps this is the email?
	private String password;
	private String errorMessage;
	
	public Authenticate(
			String username,
			String password,
			String errorMessage)
	{
		this.username = username;
		this.password = password;
		this.errorMessage = errorMessage;
	}
	
	// maybe should instead return boolean
	public String checkValidUser(String username, String password)
	{
		return "";
	}
	
	// this is probably email
	public String forgotPassword(String email)
	{
		return "";
	}
	
	// should either be boolean or void also
	public String signUp()
	{
		return "";
	}
	
	// should either be boolean or void also
	public String login()
	{
		return "";
	}
}
