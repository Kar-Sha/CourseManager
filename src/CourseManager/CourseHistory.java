package CourseManager;

import javax.swing.*;
import java.sql.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.lang.Math.*;

public class CourseHistory extends JFrame implements ActionListener {
    public JFrame frame;
    public JComboBox<String> dropdown;
    public JComboBox<String> dropdownYear;
    public String userID;
    Object data[][];
    String[] column = {"Course ID", "Course Name", "Grade"};

    CourseHistory(String userID) {
        this.userID = userID;
        frame = new JFrame("Course History");

        JLabel courseListLabel = new JLabel("Course History:");
        courseListLabel.setForeground(Color.BLUE);
        courseListLabel.setFont(new Font(null, Font.BOLD, 20));
        courseListLabel.setBounds(115, 100, 300, 30);
        frame.add(courseListLabel);

        frame.setSize(400, 600);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a dropdown menu
        String[] options = {"Course History", "Student Profile", "Schedule", "CourseMap", "Add/Drop Courses"};
        dropdown = new JComboBox<String>(options);
        dropdown.setBounds(50, 0, 300, 50);
        frame.add(dropdown);

        String[] years = {"Freshman", "Sophomore", "Junior", "Senior"};
        dropdownYear = new JComboBox<String>(years);
        dropdownYear.setBounds(50, 500, 300, 50);
        frame.add(dropdownYear);

        // Make the frame visible
        frame.setLayout(null);
        frame.setVisible(true);

        dropdown.addActionListener(this);
        dropdownYear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox dropdown = (JComboBox) e.getSource();
            String selectedOption = (String) dropdown.getSelectedItem();
            dropdownYear = (JComboBox) e.getSource();
            String select = (String) dropdownYear.getSelectedItem();

            if (selectedOption.equals("CourseMap")) {
                new CourseMap(userID);
                return;
            }
            if (selectedOption.equals("Schedule")) {
                JFrame welcomePageFrame = new WelcomePage(userID).frame;
                frame.dispose();
                welcomePageFrame.setVisible(true);
            }
            if (selectedOption.equals("Add/Drop Courses")) {
                JFrame adjustCoursePageFrame = new AdjustCoursePage(userID).frame;
                adjustCoursePageFrame.setVisible(true);
                frame.dispose();
            }
            if (selectedOption.equals("Student Profile")) {
                JFrame studentProfileFrame = new StudentProfile(userID).frame;
                studentProfileFrame.setVisible(true);
                frame.dispose();
            }
            switch(select)
            {
                case("Freshman"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT major_course.course_id,name,grade FROM course, student_course, major_course WHERE year_id=1 AND major_course.course_id = student_course.course_id AND course.course_id = student_course.course_id AND status = 'Complete' AND student_id =\"" + userID + "\"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = pst.executeQuery();
                        rs.last();
                        int rows = rs.getRow();
                        rs.beforeFirst();
                        data = new Object[rows][column.length];
                        for(int i=0;i<rows;i++)
                        {
                            rs.next();
                            for(int j=0;j<column.length;j++)
                            {
                                data[i][j] = rs.getString(j+1);
                            }
                        }
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        JTable table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        frame.getContentPane().add(p);
                        frame.validate();
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Sophomore"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT major_course.course_id,name,grade FROM course, student_course, major_course WHERE year_id=2 AND major_course.course_id = student_course.course_id AND course.course_id = student_course.course_id AND status = 'Complete' AND student_id =\"" + userID + "\"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = pst.executeQuery();
                        rs.last();
                        int rows = rs.getRow();
                        rs.beforeFirst();
                        data = new Object[rows][column.length];
                        for(int i=0;i<rows;i++)
                        {
                            rs.next();
                            for(int j=0;j<column.length;j++)
                            {
                                data[i][j] = rs.getString(j+1);
                            }
                        }
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        JTable table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        frame.getContentPane().add(p);
                        frame.validate();
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Junior"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT major_course.course_id,name,grade FROM course, student_course, major_course WHERE year_id=3 AND major_course.course_id = student_course.course_id AND course.course_id = student_course.course_id AND status = 'Complete' AND student_id =\"" + userID + "\"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = pst.executeQuery();
                        rs.last();
                        int rows = rs.getRow();
                        rs.beforeFirst();
                        data = new Object[rows][column.length];
                        for(int i=0;i<rows;i++)
                        {
                            rs.next();
                            for(int j=0;j<column.length;j++)
                            {
                                data[i][j] = rs.getString(j+1);
                            }
                        }
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        JTable table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        frame.getContentPane().add(p);
                        frame.validate();
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Senior"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT major_course.course_id,name,grade FROM course, student_course, major_course WHERE year_id=4 AND major_course.course_id = student_course.course_id AND course.course_id = student_course.course_id AND status = 'Complete' AND student_id =\"" + userID + "\"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = pst.executeQuery();
                        rs.last();
                        int rows = rs.getRow();
                        rs.beforeFirst();
                        data = new Object[rows][column.length];
                        for(int i=0;i<rows;i++)
                        {
                            rs.next();
                            for(int j=0;j<column.length;j++)
                            {
                                data[i][j] = rs.getString(j+1);
                            }
                        }
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        JTable table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        frame.getContentPane().add(p);
                        frame.validate();
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
            }

        }
    }

}
