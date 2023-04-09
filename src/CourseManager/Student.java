package CourseManager;

import java.util.Random;

public class Student 
{
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String major;
	private String studentID;
	private CourseMap map;
	
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
		this.map = new CourseMap();
	}
	
	/*
	 * Calculates GPA for student
	 */
	public double calculateGPA()
	{
		
		return 0.0;
	}
	
	/*
	 * Registers student for course, added to their courses in their course map
	 */
	public boolean enroll(Course course)
	{
		return this.map.enroll(course.getID());
	}
	
	/*
	 * Drops student from course
	 */
	public boolean drop(Course course)
	{
		return this.map.drop(course.getID());
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getMajor()
	{
		return this.major;
	}
	
	public String getID()
	{
		return this.studentID;
	}
	
	public CourseMap getMap()
	{
		return this.map;
	}
  
	private void generateID()
  {
		char firstInitial = this.firstName.toUpperCase().charAt(0);
		char lastInitial = this.lastName.toUpperCase().charAt(0);
		String randomDigits = String.format("%04d", (int) (Math.random() * 10000));
		this.studentID = String.format("%s%s%s", firstInitial, lastInitial, randomDigits);
	}
}
