package CourseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdjustCoursePage extends JFrame implements ActionListener {
    public JFrame frame;
    public JComboBox<String> dropdown;

    AdjustCoursePage(){
        frame = new JFrame("Add/Drop Courses");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        add(panel);

        // Create a dropdown menu
        String[] options = {"Add/Drop Courses","Student Profile", "Schedule", "Course History","CourseMap"};
        dropdown = new JComboBox<String>(options);
        dropdown.setBounds(50, 0, 300, 50);
        panel.add(dropdown);

        // Add addCourseButton
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(this);
        addCourseButton.setBounds(50, 500, 150, 30);
        panel.add(addCourseButton);

        // Add dropCourseButton
        JButton dropCourseButton = new JButton("Drop Course");
        dropCourseButton.addActionListener(this);
        dropCourseButton.setBounds(200, 500, 150, 30);
        panel.add(dropCourseButton);

        // Make the frame visible
        frame.add(panel);
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
                courseMapFrame.setSize(400, 600);
                courseMapFrame.setVisible(true);
            }
            if (selectedOption.equals("Schedule")) {
                JFrame scheduleFrame = new WelcomePage().frame;
                scheduleFrame.setVisible(true);
                frame.dispose(); // dispose of the current frame
            }
            if (selectedOption.equals("Course History")) {
                JFrame courseHistoryFrame = new CourseHistory().frame;
                courseHistoryFrame.setVisible(true);
                frame.dispose(); // dispose of the current frame
            }
            if (selectedOption.equals("Student Profile")) {
                JFrame StudentProfileFrame = new StudentProfile().frame;
                StudentProfileFrame.setVisible(true);
                frame.dispose(); // dispose of the current frame
            }
        }
    }
}
