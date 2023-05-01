package CourseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentProfile extends JFrame implements ActionListener {
    public JFrame frame;
    public JComboBox<String> dropdown;

    StudentProfile(){
        frame = new JFrame("Student Profile");

        // Set the size of the frame
        frame.setSize(400, 600);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a dropdown menu
        String[] options = {"Student Profile","Schedule","Course History","CourseMap","Add/Drop Courses"};
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
                courseMapFrame.setSize(400, 600);
                courseMapFrame.setVisible(true);
            }
            if (selectedOption.equals("Schedule")) {
                JFrame scheduleFrame = new WelcomePage().frame;
                scheduleFrame.setVisible(true);
                frame.dispose(); // dispose of the current frame
            }
            if (selectedOption.equals("Add/Drop Courses")) {
                JFrame AdjustCoursePageFrame = new AdjustCoursePage().frame;
                AdjustCoursePageFrame.setVisible(true);
                frame.dispose(); // dispose of the current frame
            }
            if (selectedOption.equals("Course History")) {
                JFrame CourseHistoryFrame = new CourseHistory().frame;
                CourseHistoryFrame.setVisible(true);
                frame.dispose(); // dispose of the current frame
            }
        }
    }
}
