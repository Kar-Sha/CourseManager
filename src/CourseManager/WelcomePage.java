package CourseManager;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class WelcomePage implements ActionListener{

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	JButton viewGradeButton = new JButton("View Grades");
	JButton viewCoursesButton = new JButton("View Courses History");
	JButton signOutButton = new JButton("Sign Out");
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	WelcomePage(String userID){
		
		welcomeLabel.setBounds(150,20,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+ userID);
		
		viewGradeButton.setBounds(25,80,120,20);
		viewGradeButton.setFocusable(false);
		viewGradeButton.addActionListener(this);

		viewCoursesButton.setBounds(25,110,175,20);
		viewCoursesButton.setFocusable(false);
		viewCoursesButton.addActionListener(this);

		signOutButton.setBounds(300,100,100,20);
		signOutButton.setFocusable(false);
		signOutButton.addActionListener(this);

		frame.add(welcomeLabel);
		frame.add(viewGradeButton);
		frame.add(viewCoursesButton);
		frame.add(signOutButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==signOutButton) {
            frame.dispose();
			LoginPage login = new LoginPage(logininfo);
		}
		else{
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	
}

