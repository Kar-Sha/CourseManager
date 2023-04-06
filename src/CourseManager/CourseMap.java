package CourseManager;

import java.util.ArrayList;

public class CourseMap 
{
	private ArrayList<Course> courses;
	private ArrayList<Course> history;
	
	public CourseMap()
	{
		this.courses = new ArrayList<>();
		this.history = new ArrayList<>();
	}
	
	/*
	 * Generates a formatted string of all currently active classes in courses  
	 */
	public String generateSchedule()
	{
		return "";
	}
	
	/*
	 * Generates a formatted string of all currently active class grades from courses
	 */
	public String showGrades()
	{
		return "";
	}
	
	/*
	 * Shows the grades of ALL courses (history + courses) in cronological order
	 * 	(oldest first, newest last) and shows grades for each (current classes have IN PROGRESS as grade)
	 */
	public String showCoursesTaken()
	{
		
		return "";
	}
	
	/*
	 * Enrolls student into course
	 * 
	 * @return true if sucessfully able to add course, false otherwise
	 */
	public boolean enroll(int courseID)
	{
		
		return false;
	}
	
	/*
	 * Drops student from currently active course, will not touch courses in history
	 * 
	 * @Return true if course is successfully dropped, false otherwise
	 */
	public boolean drop(int courseID)
	{
		
		return false;
	}
}
