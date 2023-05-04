package CourseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class WelcomePage extends JFrame implements ActionListener {
    public JFrame frame;
    private String user_id;

    public WelcomePage(String user_id) {
        this.user_id = user_id;

        setTitle("Welcome Page ");
        setBounds(0, 0, 400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        add(panel);

        String[] options = {"Schedule", "Student Profile", "Course History", "CourseMap", "Add/Drop Courses"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        panel.add(dropdown);
        dropdown.setBounds(50, 0, 300, 50);
        dropdown.addActionListener(this);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(this);
        panel.add(logoutButton);
        logoutButton.setBounds(50, 510, 300, 30);

        JLabel scheduleLabel = new JLabel("Class Schedule:");
        scheduleLabel.setBounds(30, 45, 300, 30);
        scheduleLabel.setFont(new Font(null, Font.BOLD, 25));
        scheduleLabel.setForeground(Color.BLUE);
        panel.add(scheduleLabel);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "Bellators@612");

            PreparedStatement pst = conn.prepareStatement("SELECT distinct course.course_id, name FROM course,student_course WHERE status='Incomplete' and course.course_id=student_course.course_id and student_id=?;");
            pst.setString(1, user_id);
            ResultSet rs = pst.executeQuery();

            int numClasses = 0;

            while(rs.next()) {
                numClasses++;

                JPanel classPanel = new JPanel();
                classPanel.setLayout(null);
                Border border = BorderFactory.createLineBorder(Color.black);
                classPanel.setBorder(border);
                classPanel.setBounds(30, 80 + ((numClasses-1) * 80), 340, 40);
                panel.add(classPanel);

                JLabel classNameLabel = new JLabel(rs.getString("name"));
                classNameLabel.setBounds(10, 10, 150, 30);
                classPanel.add(classNameLabel);

                JLabel classIdLabel = new JLabel(rs.getString("course_id"));
                classIdLabel.setBounds(300, 10, 150, 30);
                classPanel.add(classIdLabel);
            }

            if (numClasses == 0) {
                JLabel noClassesLabel = new JLabel("You have no classes scheduled.");
                noClassesLabel.setBounds(30, 90, 300, 30);
                panel.add(noClassesLabel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox dropdown = (JComboBox) e.getSource();
            String selectedOption = (String) dropdown.getSelectedItem();
            if (selectedOption.equals("CourseMap")) {
                new CourseMap(user_id);
            }
            if (selectedOption.equals("Student Profile")) {
                JFrame studentProfileFrame = new StudentProfile(user_id).frame;
                studentProfileFrame.setVisible(true);
                dispose();
            }
            if (selectedOption.equals("Course History")) {
                JFrame courseHistoryFrame = new CourseHistory(user_id).frame;
                courseHistoryFrame.setVisible(true);
                dispose();
            }
            if (selectedOption.equals("Add/Drop Courses")) {
                JFrame AdjustCoursePageFrame = new AdjustCoursePage(user_id).frame;
                AdjustCoursePageFrame.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Log Out")) {
                dispose();
                new LoginPage(new HashMap<>(), this.getX(), this.getY());
            }
        }
    }

}
