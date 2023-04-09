package CourseManager;


public class Course
{
    private int courseID;
    private String title;
    private int creditHours;
    private String status;
    private String semester;
    private String year;
    private char grade;


//courseID, courseName, credits, grade, semester, year, and status
    public Course(int courseID, String title, int creditHours,char grade, String semester, String year, String status)
    {
        this.courseID = courseID;
        this.title = title;
        this.creditHours = creditHours;
        this.status = status;
        this.grade = grade;
        this.year = year;
        this.semester = semester;


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

    public char getGrade(){
        return this.grade;
    }

    public String getSemester(){
        return this.semester;
    }

    public String getYear(){
        return this.year;
    }

    public String getStatus(){
        return this.status;
    }
}
