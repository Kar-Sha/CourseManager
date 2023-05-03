package CourseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdjustCoursePage extends JFrame implements ActionListener {
    public JFrame frame;
    public JComboBox<String> dropdown;

    AdjustCoursePage() {
        frame = new JFrame("Add/Drop Course Page");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);

        // Create a dropdown menu
        String[] options = {"Add/Drop Courses", "Student Profile", "Schedule", "Course History", "CourseMap"};
        dropdown = new JComboBox<>(options);
        dropdown.setBounds(50, 0, 300, 50);
        panel.add(dropdown);

        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(this);
        addCourseButton.setBounds(50, 500, 150, 30);
        panel.add(addCourseButton);

        JButton dropCourseButton = new JButton("Drop Course");
        dropCourseButton.addActionListener(this);
        dropCourseButton.setBounds(200, 500, 150, 30);
        panel.add(dropCourseButton);

        panel.setLayout(null);
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);

        dropdown.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox dropdown = (JComboBox) e.getSource();
            String selectedOption = (String) dropdown.getSelectedItem();
            assert selectedOption != null;
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
            if (selectedOption.equals("Course History")) {
                JFrame courseHistoryFrame = new CourseHistory().frame;
                courseHistoryFrame.setVisible(true);
                frame.dispose();
            }
            if (selectedOption.equals("Student Profile")) {
                JFrame StudentProfileFrame = new StudentProfile().frame;
                StudentProfileFrame.setVisible(true);
                frame.dispose();
            }
        }
    }
}
