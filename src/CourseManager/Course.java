package CourseManager;

public class Course 
{
	private int addCode;
	private String title;
	private int creditHours;
	private String description;
	
	public Course(
			int addCode,
			String title,
			int creditHours,
			String description)
	{
		this.addCode = addCode;
		this.title = title;
		this.creditHours = creditHours;
		this.description = description;
	}
}
