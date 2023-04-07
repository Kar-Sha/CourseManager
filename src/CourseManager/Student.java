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
	
	/*
	 * TODO: generate ID in the following format: firstnameLastname[4randomdigits]
	 * 	and save it to studentID, this should run upon creation of student
	 */
	private void generateID()
	{
		Random randInt = new Random();
		int intID = randInt.nextInt(0000, 10000);
		String stringID = String.format("%04d", intID);
		
		this.studentID = this.firstName.toLowerCase() + this.lastName.toLowerCase() + stringID;
	}
	
	
}
