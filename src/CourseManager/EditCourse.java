package CourseManager;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class EditCourse implements ActionListener{
	private JFrame frame = new JFrame("Edit Course");
	private JLabel label = new JLabel("Edit Course");
	private JButton submitButton = new JButton("Submit");
	private JButton backButton = new JButton("Back");
	private JTextField classField = new JTextField();
	private JLabel classLabel = new JLabel("Class Name:");
	private JTextField gradeField = new JTextField();
	private JLabel gradeLabel = new JLabel("Grade:");
	private JLabel messageLabel = new JLabel();
	public String userID;

	EditCourse(String userID){

		this.userID = userID;

		this.label.setBounds(150,35,200,35);
		this.label.setFont(new Font(null,Font.BOLD,25));
		label.setForeground(Color.BLUE);

		this.classLabel.setBounds(50,100,150,25);
		this.gradeLabel.setBounds(50,150,150,25);

		this.messageLabel.setBounds(125,250,250,35);
		this.messageLabel.setFont(new Font(null,Font.ITALIC,25));

		this.classField.setBounds(140,100,200,25);
		this.gradeField.setBounds(140,150,200,25);

		this.submitButton.setBounds(225,200,100,25);
		this.submitButton.setFocusable(false);
		this.submitButton.addActionListener(this);

		this.backButton.setBounds(125,200,100,25);
		this.backButton.setFocusable(false);
		this.backButton.addActionListener(this);

		this.frame.add(label);
		this.frame.add(classLabel);
		this.frame.add(messageLabel);
		this.frame.add(classField);
		this.frame.add(gradeField);
		this.frame.add(gradeLabel);
		this.frame.add(submitButton);
		this.frame.add(backButton);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(450,400);
		this.frame.setLayout(null);
		this.frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//redirects to signup page
		if(e.getSource()==backButton) {
			frame.dispose();
			new CourseMap(userID);
		}
		//login validation, checks if user is within the database
		if(e.getSource()==submitButton) {

			String className = classField.getText();
			String grade = gradeField.getText();

			try {

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manager", "root", "MySQLr00tpass"); //change

				PreparedStatement pst = con.prepareStatement("SELECT course_id FROM course WHERE name=?");
				pst.setString(1, className);

				ResultSet rs = pst.executeQuery();

				if(rs.next()){
					String courseID = rs.getString(1);
					PreparedStatement pest = con.prepareStatement("SELECT student_id FROM student_course WHERE course_id=?");
					pest.setString(1, courseID);
					ResultSet rsfind = pest.executeQuery();
					if(rsfind.next())
					{
						if(rsfind.getString(1).equals(userID))
						{
							Statement pst3 = con.createStatement();
							String sql2 = "UPDATE student_course SET status='Complete',grade=\"" + grade + "\" WHERE course_id=\"" + courseID + "\"";
							int rs3 = pst3.executeUpdate(sql2);
							if(rs3 == 1)
							{
								JOptionPane.showMessageDialog(backButton, "Course Recorded");
								frame.dispose();
								con.close();
								new EditCourse(userID);
							}
						}
					}
					else{
						String status = "Complete";
						Statement pst2 = con.createStatement();
						String sql = "INSERT INTO student_course(student_id, course_id,status,grade)" +
								"VALUES('" + userID + "','" + courseID + "','" + status + "','"  +  grade +"')";
						int rs2 = pst2.executeUpdate(sql);
						if(rs2 == 1)
						{
							JOptionPane.showMessageDialog(backButton, "Course Recorded");
							frame.dispose();
							con.close();
							new EditCourse(userID);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(backButton, "Course Not Available");
				}
			}
			catch (SQLException sqlException){
				sqlException.printStackTrace();
			}

		}
	}

}
