package CourseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseHistory extends JFrame implements ActionListener {
    public JFrame frame;
    public JComboBox<String> dropdown;

    CourseHistory() {
        frame = new JFrame("Course History");

        frame.setSize(400, 600);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a dropdown menu
        String[] options = {"Course History", "Student Profile", "Schedule", "CourseMap", "Add/Drop Courses"};
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
                JFrame courseMapFrame = new JFrame("Course Map");
                courseMapFrame.setSize(500, 500);
                courseMapFrame.setVisible(true);
                return;
            }
            if (selectedOption.equals("Schedule")) {
                JFrame welcomePageFrame = new WelcomePage().frame;
                frame.dispose();
                welcomePageFrame.setVisible(true);
            }
            if (selectedOption.equals("Add/Drop Courses")) {
                JFrame adjustCoursePageFrame = new AdjustCoursePage().frame;
                adjustCoursePageFrame.setVisible(true);
                frame.dispose();
            }
            if (selectedOption.equals("Student Profile")) {
                JFrame studentProfileFrame = new StudentProfile().frame;
                studentProfileFrame.setVisible(true);
                frame.dispose();
            }
        }
    }

}