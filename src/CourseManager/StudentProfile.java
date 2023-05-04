package CourseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentProfile extends JFrame implements ActionListener {
    public JFrame frame;
    private String user_id;

    public JComboBox<String> dropdown;

    StudentProfile(String user_id) {
        this.user_id = user_id;
        frame = new JFrame("Student Profile");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass");

            PreparedStatement pst = conn.prepareStatement("SELECT * FROM student WHERE student_id=?");
            pst.setString(1, user_id);

            ResultSet rs = pst.executeQuery();


            if (rs.next()) {
                String userId = rs.getString("student_id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("first_name") + " " + rs.getString("last_name");
                String major = rs.getString("major");
                String year = rs.getString("year_id");

                // Create new JLabels for each field
                JLabel userIDValueLabel = new JLabel(userId);
                userIDValueLabel.setFont(new Font("Arial", Font.PLAIN, 18));

                JLabel passwordValueLabel = new JLabel(password);
                passwordValueLabel.setFont(new Font("Arial", Font.PLAIN, 18));

                JLabel emailValueLabel = new JLabel(email);
                emailValueLabel.setFont(new Font("Arial", Font.PLAIN, 18));

                JLabel nameValueLabel = new JLabel(name);
                nameValueLabel.setFont(new Font("Arial", Font.PLAIN, 18));

                JLabel majorValueLabel = new JLabel(major);
                majorValueLabel.setFont(new Font("Arial", Font.PLAIN, 18));

                JLabel yearValueLabel = new JLabel(year);
                yearValueLabel.setFont(new Font("Arial", Font.PLAIN, 18));



                JLabel userIDLabel = new JLabel("User ID:");
                userIDLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel userPasswordLabel = new JLabel("Password:");
                userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel userEmailLabel = new JLabel("Email:");
                userEmailLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel userNameLabel = new JLabel("Name:");
                userNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel userMajorLabel = new JLabel("Major:");
                userMajorLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel userYearLabel = new JLabel("Year:");
                userYearLabel.setFont(new Font("Arial", Font.BOLD, 18));

                // Set the bounds of the labels
                int labelHeight = 30;
                int labelWidth = 200;
                int labelX = 150;
                int labelY = 50;
                int labelGap = 85;

                userIDValueLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
                userIDLabel.setBounds(45, labelY, 120, labelHeight);
                userIDValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));

                passwordValueLabel.setBounds(labelX, labelY + labelGap, labelWidth, labelHeight);
                userPasswordLabel.setBounds(45, labelY + labelGap, 120, labelHeight);
                passwordValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));

                emailValueLabel.setBounds(labelX, labelY + labelGap * 2, labelWidth, labelHeight);
                userEmailLabel.setBounds(45, labelY + labelGap * 2, 120, labelHeight);
                emailValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));

                nameValueLabel.setBounds(labelX, labelY + labelGap * 3, labelWidth, labelHeight);
                userNameLabel.setBounds(45, labelY + labelGap * 3, 120, labelHeight);
                nameValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));

                majorValueLabel.setBounds(labelX, labelY + labelGap * 4, labelWidth, labelHeight);
                userMajorLabel.setBounds(45, labelY + labelGap * 4, 120, labelHeight);
                majorValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));

                yearValueLabel.setBounds(labelX, labelY + labelGap * 5, labelWidth, labelHeight);
                userYearLabel.setBounds(45, labelY + labelGap * 5, 120, labelHeight);
                yearValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));


                frame.add(userIDLabel);
                frame.add(userIDValueLabel);

                frame.add(userPasswordLabel);
                frame.add(passwordValueLabel);

                frame.add(userEmailLabel);
                frame.add(emailValueLabel);

                frame.add(userNameLabel);
                frame.add(nameValueLabel);

                frame.add(userMajorLabel);
                frame.add(majorValueLabel);

                frame.add(userYearLabel);
                frame.add(yearValueLabel);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create a dropdown menu
        String[] options = {"Student Profile", "Schedule", "Course History", "CourseMap", "Add/Drop Courses"};
        dropdown = new JComboBox<String>(options);
        dropdown.setBounds(50, 0, 300, 50);
        frame.add(dropdown);

        // Make the frame visible
        frame.setLayout(null);
        frame.setVisible(true);

        dropdown.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox dropdown = (JComboBox) e.getSource();
            String selectedOption = (String) dropdown.getSelectedItem();

            if (selectedOption.equals("CourseMap")) {
                new CourseMap(user_id);
            }
            if (selectedOption.equals("Schedule")) {
                JFrame welcomePageFrame = new WelcomePage(user_id).frame;
                frame.dispose();
                welcomePageFrame.setVisible(true);
            }

            if (selectedOption.equals("Add/Drop Courses")) {
                JFrame adjustCoursePageFrame = new AdjustCoursePage(user_id).frame;
                adjustCoursePageFrame.setVisible(true);
                frame.dispose();
            }
            if (selectedOption.equals("Course History")) {
                JFrame courseHistoryFrame = new CourseHistory(user_id).frame;
                courseHistoryFrame.setVisible(true);
                frame.dispose();
            }

        }
    }


}