# CourseManager
**Group 3: Griffin Davidson, Ricky Nguyen, and Karan Sharma**
<br />
Proposal Contributions:<br />
Written Entirely by Ricky Nguyen and Karan Sharma <br />
Presentation Contributions:<br />
Karan Sharma - Background, Technologies, and Database Slides<br />
Project Code + Report Contributions:<br />
Karan Sharma - Set up JDBC, created entire database, made all the SQL queries. I also created signup, login, coursemap, coursehistory, editcourse, and dbconnection pages. I also worked closely with Ricky with implementing and testing all features. For the report I did the surverying of previous/similiar works, operating environments, and steps to run the code.  <br />
<br />
## Problem
The problem we are trying to solve is the issue of tracking the courses you’ve taken and those that need to be taken by a student. Often, students have trouble figuring out the next courses they need to take for the next semester. Or sometimes students take the wrong courses that cause them to fall behind in attaining their degree. So the issue here to be resolved is to provide students with a more interactive and easier platform where students can utilize our app to devise their degree plans.
### Previous/Similar Works
MyPlanner and MySJSU
### Assumptions/Operating Environment/Intended Usage
The assumption is that the user is intending to enroll into college and complete their course plan. The operating environment will be accessible as a web application.

### Operating Environments and Supporting Technology
- JDBC
- MySQL Community Server 8.33

## High Level Solution and Functionality
After the user enters their school, the user will be prompted to sign in or register. When registering the user would provide the necessary information such as name, student ID, birthdate, home location, grade, major, and GPA. After that the app will then help devise a four year plan that ensures the student can graduate on time. As the user completes their courses, the app will recommend courses to be taken for their next semester depending on their intended units and if they want to take a winter, summer, or gap semester. This allows for our app to prevent the need to go to a counselor or a major advisor for suggestions of future courses which can take a long time to hear a response from. On another page of the app we can have a chart that keeps track of the units taken to units needed for graduation such as a pie chart so it’s visually appealing to the student and easy to comprehend.

### Operations
- View course history
- View grades
- Add grade
- View course map
- Register
- Login
- View and Edit class schedule
- Drop a class
- Enroll in a class
- View student profile

### Solutions
NEED

## Steps to Run Code
1. Download MySQL Community Server: https://dev.mysql.com/downloads/mysql/
2. Install and setup your MySQL Community Server. During the installation, make sure to also install MySQL Workbench after setting your root password. 
3. Import the CourseManagerSQL.sql file into the Workbench or run the file after simply copy and paste the contents into a query tab.
4. Download the Java Connector (JDBC): https://dev.mysql.com/downloads/connector/j/
5. For the JDBC, select "Platform Independent" option and download the .zip folder. Extract the jar file and import it into your java project.
6. DBConnection.java is a file used to test if the database is properly initialize. In this file the only area that should be changed is the "public static String pass" variable. Set this variable to the root password you set up when installing MySQL Community Server. 
7. Test the Connection with "DBConnection.loadConnection();", a popup window will be shown if the connection was successful. This pass needs to be changed in every Connection con we ran in the project. 

### Snapshots of Running Program

## References
[1] MyPlanner: https://one.sjsu.edu/task/all/myplanner
<br />
[2] MySJSU: https://one.sjsu.edu/
