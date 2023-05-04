package CourseManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
public class CourseMap extends JFrame implements ActionListener{
    String[] column = {"Course ID", "Course Name"};
    Object data[][];
    Object data2[][];
    public JFrame f;
    public JComboBox<String> dropdown;
    public String userID;
    public JTable table;
    CourseMap(String userID){
        f = new JFrame();
        this.userID=userID;

        String[] years = {"Freshman", "Sophomore", "Junior", "Senior", "Insert Grade"};
        dropdown = new JComboBox<String>(years);
        dropdown.setBounds(150, 500, 300, 50);
        f.add(dropdown);
        dropdown.addActionListener(this);

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

        //f.add(yearLabel);
        //f.add(yearTwoLabel);
        //f.add(yearThreeLabel);
        //f.add(yearFourLabel);
        f.setTitle("Course Map" + userID);
        f.setSize(600,600);
        f.setLocation(100, 100);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
            PreparedStatement pst = con.prepareStatement("Select year_id FROM student WHERE student_id =\"" + userID + "\"");
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                rs.getString(1);
                System.out.println(rs.getString(1));
            }

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        f.setLayout(new BorderLayout());      
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() instanceof JComboBox) {
            JComboBox dropdown = (JComboBox) e.getSource();
            String select = (String) dropdown.getSelectedItem();
            switch(select)
            {
                case("Freshman"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT course.course_id,name FROM course, major_course WHERE major_course.year_id=1 AND course.course_id=major_course.course_id AND (major_course.major_id=1 or major_course.major_id=4) ORDER BY rand() LIMIT 8;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
    
    
                        table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        f.getContentPane().add(p);
                        f.validate();
                        //f.add(jsp);
                        
            
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Sophomore"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT course.course_id,name FROM course, major_course WHERE major_course.year_id=2 AND course.course_id=major_course.course_id AND (major_course.major_id=1 or major_course.major_id=4) ORDER BY rand() LIMIT 8",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
    
    
                        table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        f.getContentPane().add(p);
                        f.validate();
                        //f.add(jsp);
                        
            
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Junior"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT course.course_id,name FROM course, major_course WHERE major_course.year_id=3 AND course.course_id=major_course.course_id AND (major_course.major_id=1 or major_course.major_id=4) ORDER BY rand() LIMIT 8",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
    
    
                        table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        f.getContentPane().add(p);
                        f.validate();
                        //f.add(jsp);
                        
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Senior"):
                {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change
                        PreparedStatement pst = con.prepareStatement("SELECT course.course_id,name FROM course, major_course WHERE major_course.year_id=4 AND course.course_id=major_course.course_id AND (major_course.major_id=1 or major_course.major_id=4) ORDER BY rand() LIMIT 8",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
    
    
                        table = new JTable(data, column);
                        JScrollPane jsp = new JScrollPane(table);
                        jsp.setViewportView(table);
                        jsp.setBounds(50,50,100,100);
                        p.add(jsp,BorderLayout.NORTH);
                        p.setLocation(50,150);
                        p.setSize(300, 300);
                        f.getContentPane().add(p);
                        f.validate();
                        //f.add(jsp);
                        
            
                    }
                    catch (SQLException sqlException){
                        sqlException.printStackTrace();
                    }
                    break;
                }
                case("Insert Grade"):
                {
                    new EditCourse(userID);
                    f.dispose();
                }
            }
        }
    }
}

