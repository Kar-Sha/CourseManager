package CourseManager;

import java.util.Random;

public class Course 
{
	private String courseID;
	private String title;
	private int creditHours;
	private String description;
	
	/*
	 * Public constructor for course with title, creditHours, and Description user-created
	 * 
	 * courseID is automatically and randomly generated, will eventually include checks that the random ID does not
	 * 	conflict with a prexisting ID
	 */
	public Course(
			String title,
			int creditHours,
			String description)
	{
		this.title = title;
		this.creditHours = creditHours;
		this.description = description;
		
		Random rand = new Random();
		int id = rand.nextInt(1,1000000);
		this.courseID = String.format("%06d", id);
	}
	
	public String getID()
	{
		return this.courseID;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public int getCreditHours()
	{
		return this.creditHours;
	}
	
	public String getDescription()
	{
		return this.description;
	}
}
