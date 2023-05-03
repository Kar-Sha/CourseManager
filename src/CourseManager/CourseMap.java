package CourseManager;

import javax.swing.*;
public class CourseMap {
    public JFrame frame;

    CourseMap(){
        frame = new JFrame("Course Map");

        frame.setSize(400, 600);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Make the frame visible
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

