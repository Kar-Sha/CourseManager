package CourseManager;

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
	
	/*
	 * TODO: generate ID in the following format: firstnameLastname[4randomdigits]
	 * 	and save it to studentID, this should run upon creation of student
	 */
	private void generateID()
	{
		char firstInitial = this.firstName.toUpperCase().charAt(0);
		char lastInitial = this.lastName.toUpperCase().charAt(0);
		int idNum = (int) Math.floor(Math.random() *(9999 - 1000 + 1) + 1000);
		return String.format("%c%c-%d", firstInitial, lastInitial, idNum);
	}
}
