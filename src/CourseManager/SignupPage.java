package CourseManager;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;

import CourseManager.PasswordExceptions.*;


public class SignupPage implements ActionListener{
	//setting up the form
	private JFrame frame = new JFrame();
	private JLabel label = new JLabel("Sign Up");
	private JButton signupButton = new JButton("Sign Up");
	private JButton backButton = new JButton("Back");
	private JTextField studentIDField = new JTextField();
	private JTextField firstNameField = new JTextField();
	private JTextField lastNameField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField majorField = new JTextField();
	private JTextField yearField = new JTextField();
	private JPasswordField userPasswordField = new JPasswordField();
	private JLabel studentIDLabel = new JLabel("Student ID:");
	private JLabel firstNameLabel = new JLabel("First Name:");
	private JLabel lastNameLabel = new JLabel("Last Name:");
	private JLabel emailLabel = new JLabel("Email:");
	private JLabel majorLabel = new JLabel("Major:");
	private JLabel yearLabel = new JLabel("Year:");
	private JLabel userPasswordLabel = new JLabel("Password:");
	private JLabel messageLabel = new JLabel();
	private HashMap<String,String> signup = new HashMap<String,String>();
	
	SignupPage(HashMap<String,String> signupInfo, int xCoord, int yCoord){
		//setting up fonts and bounds for all components
		this.signup = signupInfo;
		
		this.label.setBounds(160,20,200,35);
		this.label.setFont(new Font(null,Font.PLAIN,25));
       
		this.studentIDLabel.setBounds(50,80,75,25);
		this.firstNameLabel.setBounds(50,110,75,25);
		this.lastNameLabel.setBounds(50,140,75,25);
		this.emailLabel.setBounds(50,170,75,25);
		this.majorLabel.setBounds(50,200,75,25);
		this.userPasswordLabel.setBounds(50,260,75,25);
		this.yearLabel.setBounds(50,230,75,25);
	
		this.messageLabel.setBounds(50,350,250,35);
		this.messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		this.studentIDField.setBounds(125,80,200,25);
		this.firstNameField.setBounds(125,110,200,25);
		this.lastNameField.setBounds(125,140,200,25);
		this.emailField.setBounds(125,170,200,25);
		this.majorField.setBounds(125,200,200,25);
		this.userPasswordField.setBounds(125,260,200,25);
		this.yearField.setBounds(125, 230, 200, 25);
	
		this.signupButton.setBounds(125,300,100,25);
		this.signupButton.setFocusable(false);
		this.signupButton.addActionListener(this);
	
		this.backButton.setBounds(225,300,100,25);
		this.backButton.setFocusable(false);
		this.backButton.addActionListener(this);

		//adds all components to frame
		this.frame.add(label);
		this.frame.add(studentIDLabel);
		this.frame.add(userPasswordLabel);
		this.frame.add(messageLabel);
		this.frame.add(studentIDField);
		this.frame.add(firstNameLabel);
		this.frame.add(firstNameField);
		this.frame.add(lastNameField);
		this.frame.add(emailField);
		this.frame.add(majorField);
		this.frame.add(yearField);
		this.frame.add(lastNameLabel);
		this.frame.add(emailLabel);
		this.frame.add(majorLabel);
		this.frame.add(yearLabel);
		this.frame.add(userPasswordField);
		this.frame.add(signupButton);
		this.frame.add(backButton);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setBounds(xCoord, yCoord, Main.SIDE_SIZE, Main.SIDE_SIZE);
		this.frame.setLayout(null);
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//back button redirects back to login page
		if(e.getSource()==backButton) 
		{
            frame.dispose();
			new LoginPage(signup, frame.getX(), frame.getY());
		}
		
		//signup adds student to database + redirected back to login
		if(e.getSource()==signupButton) 
		{
			
			String studentID = studentIDField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String email = emailField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			String major = majorField.getText();
			String year = yearField.getText(); //only put in 1 or 2 or 3 or 4
			
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change

				String query = "INSERT INTO student(student_id, first_name, last_name, email, password, major, year_id)" + 
				"VALUES('" + studentID + "','" + firstName + "','" + lastName + "','"  + email + "','" + password + "','" + major + "','" + year + "')";

				Statement st = con.createStatement();
				int rs = st.executeUpdate(query);
				if(rs == 1){
					con.close();
					frame.dispose();
					JOptionPane.showMessageDialog(signupButton, "Sign Up Successful");
					new LoginPage(signup, frame.getX(), frame.getY());
				}
				else{
					con.close();
					JOptionPane.showMessageDialog(signupButton, "Unable to Sign Up");
				}
			}
			catch (SQLException sqlException){
				sqlException.printStackTrace();
			}


			/* 
			try 
			{
				new PasswordValidation(userPasswordField.getPassword());
			} 
			catch (LowerCaseCharacterMissing e1) 
			{
				messageLabel.setForeground(Color.red);
			    messageLabel.setText("Password must have at least 1 lower-case character");
				return;
			}
			catch (UpperCaseCharacterMissing e1) 
			{
				messageLabel.setForeground(Color.red);
			    messageLabel.setText("Password must have at least 1 upper-case character");
				return;
			}
			catch (NumberCharacterMissing e1) 
			{
				messageLabel.setForeground(Color.red);
			    messageLabel.setText("Password must have at least 1 numerical character");
				return;
			}
			catch (SpecialCharacterMissing e1) 
			{
				messageLabel.setForeground(Color.red);
			    messageLabel.setText("Password must have at least 1 special character");
				return;
			}
			catch (Minimum8CharactersMissing e1) 
			{
				messageLabel.setForeground(Color.red);
			    messageLabel.setText("Password must be at least 8 characters");
				return;
			}
			catch (PasswordException e1) 
			{
				messageLabel.setForeground(Color.red);
			    messageLabel.setText("Something went wrong");
				return;
			}
			finally
			{
				if(studentID.isBlank()) 
				{
	            	messageLabel.setForeground(Color.red);
					messageLabel.setText("input a username");
					return;
	            }
			}
			*/
            // All good
        	//signup.put(studentID, password);
        	
		   // frame.dispose();
	       // new LoginPage(signup, frame.getX(), frame.getY());
            
            //
        }
           
	}	
}