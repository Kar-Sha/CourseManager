package CourseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class WelcomePage extends JFrame implements ActionListener {
	private String userID;

	public WelcomePage(String userID, int xCoord, int yCoord) {

		this.userID = userID;

		setTitle("Welcome Back " + userID);
		setBounds(xCoord, yCoord, 400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(null);
		add(panel);

		String[] options = {"Schedule", "Student Profile", "Course History", "CourseMap"};
		JComboBox<String> dropdown = new JComboBox<>(options);
		panel.add(dropdown);
		dropdown.setBounds(50, 0, 300, 50);
		dropdown.addActionListener(this);

		JButton addCourseButton = new JButton("Add Course");
		addCourseButton.addActionListener(this);
		panel.add(addCourseButton);
		addCourseButton.setBounds(50, 500, 150, 30);

		JButton dropCourseButton = new JButton("Drop Course");
		addCourseButton.addActionListener(this);
		panel.add(dropCourseButton);
		dropCourseButton.setBounds(200, 500, 150, 30);

		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(this);
		panel.add(logoutButton);
		logoutButton.setBounds(50, 540, 300, 30);

		JLabel scheduleLabel = new JLabel("Class Schedule:");
		scheduleLabel.setBounds(30, 45, 300, 30);
		scheduleLabel.setFont(new Font(null, Font.BOLD, 25));
		scheduleLabel.setForeground(Color.BLUE);
		panel.add(scheduleLabel);

		String[] classTimes = {"9:00 AM - 10:30 AM", "10:45 AM - 12:15 PM", "1:00 PM - 2:30 PM", "2:45 PM - 4:15 PM", "4:30 PM - 6:00 PM"};
		String[] classNames = {"Math 101", "English 101", "History 101", "Biology 101", "Computer Science 101"};

		for (int i = 0; i < classTimes.length; i++) {
			JPanel classPanel = new JPanel();
			classPanel.setLayout(null);
			Border border = BorderFactory.createLineBorder(Color.black);
			classPanel.setBorder(border);
			classPanel.setBounds(30, 90 + (i * 80), 340, 70);
			panel.add(classPanel);

			JLabel classTimeLabel = new JLabel(classTimes[i]);
			classTimeLabel.setBounds(10, 10, 150, 30);
			classPanel.add(classTimeLabel);

			JLabel classNameLabel = new JLabel(classNames[i]);
			classNameLabel.setBounds(10, 40, 150, 30);
			classPanel.add(classNameLabel);
		}

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JComboBox) {
			JComboBox dropdown = (JComboBox) e.getSource();
			String selectedOption = (String) dropdown.getSelectedItem();
			if (selectedOption.equals("CourseMap")) {
				JFrame courseMapFrame = new JFrame("Course Map");
				courseMapFrame.setSize(500, 500);
				courseMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				courseMapFrame.setVisible(true);
			}
			if (selectedOption.equals("Student Profile")) {
				JFrame courseMapFrame = new JFrame("Student Profile");
				courseMapFrame.setSize(500, 500);
				courseMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				courseMapFrame.setVisible(true);
			}
			if (selectedOption.equals("Course History")) {
				JFrame courseMapFrame = new JFrame("Course History");
				courseMapFrame.setSize(500, 500);
				courseMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				courseMapFrame.setVisible(true);
			}

		} if (e.getSource() instanceof JComboBox) {
			// code for handling the JComboBox selection
		} else if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.getText().equals("Log Out")) {
				dispose();
				new LoginPage(new HashMap<>(), this.getX(), this.getY());
			} else if (button.getText().equals("Add Course") || button.getText().equals("Drop Course")) {
				dispose(); // dispose the WelcomePage
				new CoursePage(); // create and show the CoursePage
			}
		}
	}
}
