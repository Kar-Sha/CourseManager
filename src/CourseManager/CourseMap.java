package CourseManager;

import javax.swing.*;

import java.sql.*;
import java.awt.*;
public class CourseMap extends JFrame{
    String[] column = {"Course ID", "Course Name"};
    Object data[][];
    Object data2[][];
    JFrame f;
    CourseMap(String userID){
        f = new JFrame();
        JLabel yearLabel = new JLabel("Year 1");
        JLabel yearTwoLabel = new JLabel("Year 2");
        JLabel yearThreeLabel = new JLabel("Year 3");
        JLabel yearFourLabel = new JLabel("Year 4");

        yearLabel.setBounds(50,100,200,35);
		yearLabel.setFont(new Font(null,Font.PLAIN,25));

        yearTwoLabel.setBounds(50,200,200,35);
		yearTwoLabel.setFont(new Font(null,Font.PLAIN,25));

        yearThreeLabel.setBounds(50,300,200,35);
		yearThreeLabel.setFont(new Font(null,Font.PLAIN,25));

        yearFourLabel.setBounds(50,400,200,35);
		yearFourLabel.setFont(new Font(null,Font.PLAIN,25));

        f.add(yearLabel);
        f.add(yearTwoLabel);
        f.add(yearThreeLabel);
        f.add(yearFourLabel);
        f.setTitle("Course Map" + userID);
        f.setSize(600,600);
        f.setLocation(100, 100);
        f.setLayout(new BorderLayout());

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
            PreparedStatement pst = con.prepareStatement("SELECT course.course_id,name FROM course, student_course WHERE student_course.course_id = course.course_id AND student_id =\"" + userID + "\"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();
            System.out.println("rows:" + rows);
            int columns = rs.getMetaData().getColumnCount();
            System.out.println("col:" + columns);
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
            jsp.setBounds(100,100,50,50);
            p.add(jsp,BorderLayout.CENTER);
            p.setLocation(50,50);
            p.setSize(200, 200);
            f.getContentPane().add(p);
            f.validate();
            //f.add(jsp);


            //HERE GOES NOTHING

            //Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
            PreparedStatement pst2 = con.prepareStatement("SELECT major_course.course_id,name FROM course, student_course, major_course WHERE year_id<2 AND major_course.course_id = student_course.course_id AND course.course_id = student_course.course_id AND student_id =\"" + userID + "\"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = pst2.executeQuery();
            rs2.last();
            int rows2 = rs2.getRow();
            rs2.beforeFirst();
            System.out.println("rows:" + rows2);
            int columns2 = rs2.getMetaData().getColumnCount();
            System.out.println("col:" + columns2);
            data2 = new Object[rows2][column.length];
            for(int i=0;i<rows2;i++)
            {
                rs2.next();
                for(int j=0;j<column.length;j++)
                {
                    data2[i][j] = rs2.getString(j+1);
                }
            }
            JPanel p2 = new JPanel();
            p2.setLayout(new BorderLayout());
            JTable table2 = new JTable(data2, column);
            JScrollPane jsp2 = new JScrollPane(table2);
            jsp2.setViewportView(table2);
            jsp2.setBounds(10,10,50,50);
            p2.add(jsp2,BorderLayout.WEST);
            p2.setLocation(50,450);
            p2.setSize(200, 200);
            f.add(p2);
            f.getContentPane().add(p2);
            f.validate();
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
       
       
    }
}

