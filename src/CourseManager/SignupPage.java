package CourseManager;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignupPage implements ActionListener{
	//setting up the form
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Sign Up");
	JButton signupButton = new JButton("Sign Up");
	JButton backButton = new JButton("Back");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> signup = new HashMap<String,String>();
	
	SignupPage(HashMap<String,String> signupInfo){
		
		signup = signupInfo;
		
		label.setBounds(160,20,200,35);
		label.setFont(new Font(null,Font.PLAIN,25));

		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		signupButton.setBounds(125,200,100,25);
		signupButton.setFocusable(false);
		signupButton.addActionListener(this);
		
		backButton.setBounds(225,200,100,25);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		
		frame.add(label);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(signupButton);
		frame.add(backButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==backButton) {
            frame.dispose();
			LoginPage login = new LoginPage(signup);
		}
		
		if(e.getSource()==signupButton) {

			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
		
			// Missing username
            if(userID.isBlank()) {
            	messageLabel.setForeground(Color.red);
				messageLabel.setText("input a username");
            }
            
            // Missing Password ( should do password verification )
            else if(password.isBlank()) {
            	messageLabel.setForeground(Color.red);
			    messageLabel.setText("input a password");
            }
            
            // All good
            else {  	
            	signup.put(userID, password);
            	
			    frame.dispose();
		        LoginPage login = new LoginPage(signup);
            }
            //
        }
           
	}	
}