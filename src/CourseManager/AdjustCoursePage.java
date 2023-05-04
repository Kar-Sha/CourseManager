package CourseManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class AdjustCoursePage extends JFrame implements ActionListener {
    public JFrame frame;
    private String user_id;
    public JList<String> courseList;
    public JComboBox<String> dropdown;
    public WelcomePage welcomePage;
    private JTextField classTextField = new JTextField();

    AdjustCoursePage(String user_id) {
        this.user_id = user_id;
        this.welcomePage = new WelcomePage(user_id);
        frame = new JFrame("Add/Drop Course Page");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);

        //Textfield for courses
        classTextField.setBounds(50, 400, 300, 50); // Set the bounds of the text field
        frame.add(classTextField); // Add the text field to the frame

        JLabel enterCoursesLabel = new JLabel("Enter Courses:");
        enterCoursesLabel.setBounds(50, 370, 300, 30);
        panel.add(enterCoursesLabel);

        // Create a dropdown menu
        String[] options = {"Add/Drop Courses","Student Profile", "Schedule", "Course History", "CourseMap"};
        dropdown = new JComboBox<String>(options);
        dropdown.setBounds(50, 0, 300, 50);
        frame.add(dropdown);

        // Label for the course list
        JLabel courseListLabel = new JLabel("Available Courses:");
        courseListLabel.setBounds(50, 40, 300, 30);
        panel.add(courseListLabel);

        // List for the courses
        courseList = new JList<>();
        JScrollPane courseListScrollPane = new JScrollPane(courseList);
        courseListScrollPane.setBounds(50, 70, 300, 300);
        panel.add(courseListScrollPane);

        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(this);
        addCourseButton.setBounds(50, 475, 150, 30);
        panel.add(addCourseButton);

        JButton dropCourseButton = new JButton("Drop Course");
        dropCourseButton.addActionListener(this);
        dropCourseButton.setBounds(200, 475, 150, 30);
        panel.add(dropCourseButton);

        panel.setLayout(null);
        dropdown.addActionListener(this);

        // Get the course options based on the user's year and major
        List<String> courseOptions = getCourseOptionsBasedOnYearAndMajor(getUserYear(), getUserMajor());

        // Populate the course list with available courses
        DefaultListModel<String> courseListModel = new DefaultListModel<>();
        for (String courseOption : courseOptions) {
            courseListModel.addElement(courseOption);
        }
        courseList.setModel(courseListModel);
        frame.add(panel);
        frame.setVisible(true);

        // Add action listener to the course list
        courseList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Handle selection of a course
                    String selectedCourse = courseList.getSelectedValue();
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox dropdown = (JComboBox) e.getSource();
            String selectedOption = (String) dropdown.getSelectedItem();
            assert selectedOption != null;
            if (selectedOption.equals("CourseMap")) {
                new CourseMap(user_id);
                return;
            }
            if (selectedOption.equals("Schedule")) {
                JFrame welcomePageFrame = new WelcomePage(user_id).frame;
                frame.dispose();
                welcomePageFrame.setVisible(true);
            }

            if (selectedOption.equals("Student Profile")) {
                JFrame StudentProfileFrame = new StudentProfile(user_id).frame;
                frame.dispose();
                StudentProfileFrame.setVisible(true);
            }
            if (selectedOption.equals("Course History")) {
                JFrame courseHistoryFrame = new CourseHistory(user_id).frame;
                frame.dispose();
                courseHistoryFrame.setVisible(true);

            }

        }
    }

    private String getUserYear() {
        String year = "";
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612");
            PreparedStatement pest = conn.prepareStatement("Select year_id FROM student WHERE student_id =\"" + user_id + "\"");
            ResultSet rs = pest.executeQuery();

            // Get the year value from the result set
            if (rs.next()) {
                year = rs.getString("year_id");
            }

            // Close the database connection

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return year;
    }

    private String getUserMajor() {
        String major = "";
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612");
            PreparedStatement pst = conn.prepareStatement("Select major_id FROM student,major WHERE name=major AND student_id =\"" + user_id + "\"");
            ResultSet rs = pst.executeQuery();

            // Get the major value from the result set
            if (rs.next()) {
                major = rs.getString("major_id");
            }

            // Close the database connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return major;
    }

    private List<String> getCourseOptionsBasedOnYearAndMajor(String year_id, String major_id) {
        List<String> courses = new ArrayList<>();
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612");
            PreparedStatement pst = conn.prepareStatement("SELECT course.course_id, name FROM major_course, course WHERE course.course_id = major_course.course_id AND year_id=\"" + year_id + "\"AND major_id=\"" + major_id + "\"");

            // Get the courses for the given year_id and major_id
            ResultSet rs = pst.executeQuery();

            // Add the courses to the list
            while (rs.next()) {
                String[] major_course = rs.getString("name").split(",");
                courses.addAll(Arrays.asList(major_course));
            }
            // Close the database connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Sort the courses alphabetically
        Collections.sort(courses);

        // Remove duplicates
        List<String> uniqueCourses = new ArrayList<>(new HashSet<>(courses));

        // Return the unique courses
        return uniqueCourses;
    }


}