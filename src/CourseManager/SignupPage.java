package CourseManager;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignupPage implements ActionListener{
	//setting up the form
	private JFrame frame = new JFrame();
	private JLabel label = new JLabel("Sign Up");
	private JButton signupButton = new JButton("Sign Up");
	private JButton backButton = new JButton("Back");
	private JTextField userIDField = new JTextField();
	private JPasswordField userPasswordField = new JPasswordField();
	private JLabel userIDLabel = new JLabel("userID:");
	private JLabel userPasswordLabel = new JLabel("password:");
	private JLabel messageLabel = new JLabel();
	private HashMap<String,String> signup = new HashMap<String,String>();
	
	SignupPage(HashMap<String,String> signupInfo, int xCoord, int yCoord){
		
		this.signup = signupInfo;
		
		this.label.setBounds(160,20,200,35);
		this.label.setFont(new Font(null,Font.PLAIN,25));
       
		this.userIDLabel.setBounds(50,100,75,25);
		this.userPasswordLabel.setBounds(50,150,75,25);
	
		this.messageLabel.setBounds(125,250,250,35);
		this.messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		this.userIDField.setBounds(125,100,200,25);
		this.userPasswordField.setBounds(125,150,200,25);
	
		this.signupButton.setBounds(125,200,100,25);
		this.signupButton.setFocusable(false);
		this.signupButton.addActionListener(this);
	
		this.backButton.setBounds(225,200,100,25);
		this.backButton.setFocusable(false);
		this.backButton.addActionListener(this);

		this.frame.add(label);
		this.frame.add(userIDLabel);
		this.frame.add(userPasswordLabel);
		this.frame.add(messageLabel);
		this.frame.add(userIDField);
		this.frame.add(userPasswordField);
		this.frame.add(signupButton);
		this.frame.add(backButton);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setBounds(xCoord, yCoord, Main.SIDE_SIZE, Main.SIDE_SIZE);
		this.frame.setLayout(null);
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==backButton) {
            frame.dispose();
			LoginPage login = new LoginPage(signup, frame.getX(), frame.getY());
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
		        LoginPage login = new LoginPage(signup, frame.getX(), frame.getY());
            }
            //
        }
           
	}	
}