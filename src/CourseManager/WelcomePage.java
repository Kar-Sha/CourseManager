package CourseManager;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class WelcomePage implements ActionListener{

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	JLabel viewGradeButton = new JLabel("View Grades");
	JLabel viewCoursesButton = new JLabel("View Courses History");

	
	WelcomePage(String userID){
		
		welcomeLabel.setBounds(150,20,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+ userID);
		
		viewGradeButton.setBounds(25,80,100,25);
		viewGradeButton.setFocusable(false);
		
		viewCoursesButton.setBounds(25,100,200,25);
		viewCoursesButton.setFocusable(false);

		frame.add(welcomeLabel);
		frame.add(viewGradeButton);
		frame.add(viewCoursesButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

	
}

