package CourseManager;

public class Student 
{
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String major;
	private String studentID;
	//private CourseMap map;
	
	public Student (
			String firstName,
			String lastName,
			String email,
			String password,
			String major)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.major = major;
		generateID();
	}
	
	public void calculateGPA()
	{
		
	}
	
	public void generateID()
	{
		
	}
	
	public void register(Course course)
	{
		
	}
}
