package CourseManager;

public class Course 
{
	private int courseID;
	private String title;
	private int creditHours;
	private String description;
	
	public Course(
			int courseID,
			String title,
			int creditHours,
			String description)
	{
		this.courseID = courseID;
		this.title = title;
		this.creditHours = creditHours;
		this.description = description;
		
		// CourseID should be a 5 or 6 digit random number and checked to ensure any newly created
		// courses do not match IDs with a existing course
	}
	
	public int getID()
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
