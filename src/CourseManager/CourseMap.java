package CourseManager;

import javax.swing.*;
public class CourseMap {
    public JFrame frame;
    public JComboBox<String> dropdown;

    CourseMap(){
        frame = new JFrame("Course Map");

        // Set the size of the frame
        frame.setSize(400, 600);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a dropdown menu
        String[] options = {"CourseMap", "Schedule","Course History", "Student Profile","Add/Drop Courses"};
        dropdown = new JComboBox<String>(options);
        dropdown.setBounds(50, 0, 300, 50);
        frame.add(dropdown);

        // Make the frame visible
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

