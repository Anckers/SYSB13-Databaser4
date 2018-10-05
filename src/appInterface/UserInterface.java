package appInterface;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import SQLError.SQLErrorMapping;
import table.Course;
import baseline.AddCourse;
import baseline.AddStudent;
import baseline.Controller;
import baseline.HasStudied;



public class UserInterface{

	private JFrame frame;
	private JTextField txtRegisterStudentSsn;
	private JTextField txtRegisterStudentName;
	private JTextField txtRegisterStudentAdress;
	private JTextField txtAddCourseCode;
	private JTextField txtAddCourseName;
	private JTextField txtRegisterStudentToCourseSsn;
	private JTextField txtRegisterStudentToCourseSemester;
	private JTable tableCoursesHeader;
	private JTextField txtSearchCourseCode;
	private JTextField txtSearchStudentSsn;
	private JTable table;
	
	private JTable tableStudents;
	private JTable tableCourses;
	private JTable tableSearchCourseInformation;
	private JTable tableManageStudents;
	private JTable tableDelStudentFromCourse;
	private JTable tableShowFlow;
	private JTable tableTask2;
	
	private DefaultTableModel dataModelStudents;
	private DefaultTableModel dataModelCourses;
	private DefaultTableModel dataModelDelStudentFromCourse;
	private DefaultTableModel dataModelManageStudents;
	private DefaultTableModel dataModelCourseInformation;
	private DefaultTableModel dataModelShowFlow;
	private DefaultTableModel dataModelTask2;
	
	private JScrollPane scrollPaneManageStudents;
	private JScrollPane scrollPaneSearchCourseInformation;
	private JScrollPane scrollPaneStudents;
	private JScrollPane scrollPaneCourses;
	private JScrollPane scrollPaneDelStudentFromCourse;
	private JScrollPane scrollPanelShowFlow;
	private JScrollPane scrollPaneTask2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}
//ANAS
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tab, BorderLayout.CENTER);
		
		JTabbedPane masterTabPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("Assignment 1", null, masterTabPane_1, "Working Title");
		
		// Delete student
		dataModelStudents = new DefaultTableModel();

		String[] headersStu = { "Personnr", "Namn", "Adress" };
		dataModelStudents.setColumnIdentifiers(headersStu);

				// Delete Course
		dataModelCourses = new DefaultTableModel();

		String[] headersCourse = { "Course code", "Course name", "credit" };
		dataModelCourses.setColumnIdentifiers(headersCourse);
		
		dataModelManageStudents = new DefaultTableModel();
		tableManageStudents = new JTable(dataModelManageStudents);
		tableManageStudents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneManageStudents = new JScrollPane(tableManageStudents);
		
		JPanel register = new JPanel();
		masterTabPane_1.addTab("Register", null, register, null);
		
		JLabel lblRegisterStudent = new JLabel("Register student");
		lblRegisterStudent.setBounds(20, 11, 138, 29);
		lblRegisterStudent.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		
		JLabel lblRegisterStudentSsn = new JLabel("Social Security nr:");
		lblRegisterStudentSsn.setBounds(45, 45, 120, 14);
		
		JLabel lblRegisterStudentToCourseMessage = new JLabel("");
		lblRegisterStudentToCourseMessage.setBounds(40, 440, 329, 20);
		register.add(lblRegisterStudentToCourseMessage);
		
		txtRegisterStudentSsn = new JTextField();
		txtRegisterStudentSsn.setBounds(177, 45, 160, 20);
		txtRegisterStudentSsn.setColumns(10);
		
		JLabel lblRegisterStudentAxterixSsn = new JLabel("*");
		lblRegisterStudentAxterixSsn.setBounds(25, 47, 14, 14);
		lblRegisterStudentAxterixSsn.setForeground(Color.RED);
		
		JLabel lblRegisterStudentName = new JLabel("Name:");
		lblRegisterStudentName.setBounds(45, 70, 69, 14);
		
		txtRegisterStudentName = new JTextField();
		txtRegisterStudentName.setBounds(177, 70, 160, 20);
		txtRegisterStudentName.setColumns(10);
		
		JLabel lblRegisterStudentAsterixName = new JLabel("*");
		lblRegisterStudentAsterixName.setBounds(25, 72, 14, 14);
		lblRegisterStudentAsterixName.setForeground(Color.RED);
		
		JLabel lblRegisterStudentAdress = new JLabel("Adress:");
		lblRegisterStudentAdress.setBounds(45, 97, 46, 14);
		
		txtRegisterStudentAdress = new JTextField();
		txtRegisterStudentAdress.setBounds(177, 94, 160, 20);
		txtRegisterStudentAdress.setColumns(10);
		
		JLabel lblRegisterStudentAsterixAdress = new JLabel("*");
		lblRegisterStudentAsterixAdress.setBounds(25, 100, 14, 14);
		lblRegisterStudentAsterixAdress.setForeground(Color.RED);
		
		JLabel lblRegisterStudentMessage = new JLabel("");
		lblRegisterStudentMessage.setBounds(20, 171, 317, 20);
		
		JButton btnRegisterStudent = new JButton("Register student");
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentSSN = txtRegisterStudentSsn.getText();
				String studentName = txtRegisterStudentName.getText();
				String studentAdress = txtRegisterStudentAdress.getText();
				lblRegisterStudentMessage.setText(null);
				
				if(studentSSN.isEmpty() || studentName.isEmpty() || studentAdress.isEmpty()) {
					lblRegisterStudentMessage.setForeground(Color.RED);
					lblRegisterStudentMessage.setText("All fields are required");	
				} else {
					try {
						Controller.addStudentDal(studentSSN.toUpperCase(), studentName, studentAdress);
						lblRegisterStudentMessage.setForeground(Color.BLACK);
						lblRegisterStudentMessage.setText("Student " + studentName + " has been added");
						txtRegisterStudentAdress.setText(null);
						txtRegisterStudentName.setText(null);
						txtRegisterStudentSsn.setText(null);
						
					}
						//code to handle errors, causes error before btn is connected to a controller. There for catch and try is commanded out
					
					catch (SQLException sql) {
						lblRegisterStudentMessage.setForeground(Color.RED);
						lblRegisterStudentMessage.setText(SQLErrorMapping.getMessageForErrorCode(sql.getErrorCode(), "student"));
					}

				}
			}
		});
		btnRegisterStudent.setBounds(177, 127, 130, 30);
		
		JLabel lblAddCourse = new JLabel("Add course");
		lblAddCourse.setBounds(450, 11, 138, 29);
		lblAddCourse.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		
		JLabel lblAddCourseCode = new JLabel("Course Code:");
		lblAddCourseCode.setBounds(475, 45, 87, 14);
		
		txtAddCourseCode = new JTextField();
		txtAddCourseCode.setBounds(580, 41, 160, 20);
		txtAddCourseCode.setColumns(10);
		
		JLabel lblAddCourseAsterixCode = new JLabel("*");
		lblAddCourseAsterixCode.setBounds(455, 45, 14, 14);
		lblAddCourseAsterixCode.setForeground(Color.RED);
		
		JLabel lblAddCourseName = new JLabel("Course Name:");
		lblAddCourseName.setBounds(475, 70, 93, 14);
		
		txtAddCourseName = new JTextField();
		txtAddCourseName.setBounds(580, 66, 160, 20);
		txtAddCourseName.setColumns(10);
		
		JLabel lblAddCourseAsterixName = new JLabel("*");
		lblAddCourseAsterixName.setBounds(455, 70, 14, 14);
		lblAddCourseAsterixName.setForeground(Color.RED);
		
		JLabel lblAddCourseMessage = new JLabel("");
		lblAddCourseMessage.setBounds(450, 171, 290, 20);
		register.add(lblAddCourseMessage);
		
		JButton btnRegisterCourse = new JButton("Register Course");
		btnRegisterCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Isn't courseCredit needed for assignment 1?
				String courseCode = txtAddCourseCode.getText();
				String courseName = txtAddCourseName.getText();
				//String courseCredit = txtAddCourseCredit.getText();
				lblAddCourseMessage.setText(null);
				
				if(courseCode.isEmpty() || courseName.isEmpty()) {
					lblAddCourseMessage.setForeground(Color.RED);
					lblAddCourseMessage.setText("All fields are required");
				} else {
					try {
						Controller.addCourseDal(courseCode.toUpperCase(), courseName);
						lblAddCourseMessage.setForeground(Color.BLACK);
						lblAddCourseMessage.setText("Course " + courseName + " has been added");
						txtAddCourseCode.setText(null);
						txtAddCourseName.setText(null);
					} catch (SQLException sqlException){
						lblAddCourseMessage.setForeground(Color.RED);
						lblAddCourseMessage.setText(SQLErrorMapping.getMessageForErrorCode(sqlException.getErrorCode(), "add course"));
					} catch (NumberFormatException nrE) {
						lblAddCourseMessage.setForeground(Color.RED);
						lblAddCourseMessage.setText("Credit can only be entered in numbers and decimals '.'	");
					}
					
				}
				
			}
		});
		btnRegisterCourse.setBounds(580, 127, 130, 30);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 215, 1280, 10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(396, 0, 8, 215);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		register.setLayout(null);
		register.add(lblRegisterStudent);
		register.add(lblRegisterStudentAxterixSsn);
		register.add(txtRegisterStudentSsn);
		register.add(lblRegisterStudentSsn);
		register.add(lblRegisterStudentAsterixName);
		register.add(lblRegisterStudentName);
		register.add(txtRegisterStudentName);
		register.add(lblRegisterStudentAsterixAdress);
		register.add(lblRegisterStudentAdress);
		

		register.add(lblRegisterStudentMessage);
		register.add(btnRegisterStudent);
		register.add(txtRegisterStudentAdress);
		register.add(separator_1);
		register.add(lblAddCourse);
		register.add(lblAddCourseAsterixCode);
		register.add(lblAddCourseCode);
		register.add(txtAddCourseCode);
		register.add(lblAddCourseAsterixName);
		register.add(btnRegisterCourse);
		register.add(lblAddCourseName);
		register.add(txtAddCourseName);
		register.add(separator);
		
		JLabel lblRegisterStudentTo = new JLabel("Register student to course");
		lblRegisterStudentTo.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblRegisterStudentTo.setBounds(20, 238, 181, 29);
		register.add(lblRegisterStudentTo);
		
		JLabel lblRegisterStudentToCourseSsn = new JLabel("Social Security nr:");
		lblRegisterStudentToCourseSsn.setBounds(40, 272, 120, 14);
		register.add(lblRegisterStudentToCourseSsn);
		
		JLabel lblRegisterStudentToCourseAsterix = new JLabel("*");
		lblRegisterStudentToCourseAsterix.setForeground(Color.RED);
		lblRegisterStudentToCourseAsterix.setBounds(20, 275, 14, 14);
		register.add(lblRegisterStudentToCourseAsterix);
		
		JLabel lblRegisterStudentToCourseSemester = new JLabel("Course code:");
		lblRegisterStudentToCourseSemester.setBounds(40, 297, 120, 14);
		register.add(lblRegisterStudentToCourseSemester);
		
		JLabel lblRegisterStudentToCourseSemesterAsterix = new JLabel("*");
		lblRegisterStudentToCourseSemesterAsterix.setForeground(Color.RED);
		lblRegisterStudentToCourseSemesterAsterix.setBounds(20, 300, 14, 14);
		register.add(lblRegisterStudentToCourseSemesterAsterix);
		
		JLabel lblRegisterStudentToCourseState = new JLabel("State:");
		lblRegisterStudentToCourseState.setBounds(40, 324, 120, 14);
		register.add(lblRegisterStudentToCourseState);
		
		JLabel lblRegisterStudentToCourseStateAterix = new JLabel("*");
		lblRegisterStudentToCourseStateAterix.setForeground(Color.RED);
		lblRegisterStudentToCourseStateAterix.setBounds(20, 327, 14, 14);
		register.add(lblRegisterStudentToCourseStateAterix);
		
		JLabel lblRegisterStudentToCourseGrade = new JLabel("Grade:");
		lblRegisterStudentToCourseGrade.setBounds(40, 353, 120, 14);
		register.add(lblRegisterStudentToCourseGrade);
		
		txtRegisterStudentToCourseSsn = new JTextField();
		txtRegisterStudentToCourseSsn.setColumns(10);
		txtRegisterStudentToCourseSsn.setBounds(209, 268, 160, 20);
		register.add(txtRegisterStudentToCourseSsn);
		
		txtRegisterStudentToCourseSemester = new JTextField();
		txtRegisterStudentToCourseSemester.setColumns(10);
		txtRegisterStudentToCourseSemester.setBounds(209, 293, 160, 20);
		register.add(txtRegisterStudentToCourseSemester);
		
		String cbNewCourse = "Starting course";
		String cbCompletedCourse = "Finished course";
		JComboBox<String> comboBoxRegisterStudentToCourseState = new JComboBox<String>();
		comboBoxRegisterStudentToCourseState.addItem("");
		comboBoxRegisterStudentToCourseState.addItem(cbNewCourse);
		comboBoxRegisterStudentToCourseState.addItem(cbCompletedCourse);
		comboBoxRegisterStudentToCourseState.setBounds(209, 320, 160, 22);
		register.add(comboBoxRegisterStudentToCourseState);
		

		JComboBox<String> comboBoxRegisterStudentToCourseGrade = new JComboBox<String>();
		comboBoxRegisterStudentToCourseGrade.addItem("");
		comboBoxRegisterStudentToCourseGrade.addItem("F");
		comboBoxRegisterStudentToCourseGrade.addItem("E");
		comboBoxRegisterStudentToCourseGrade.addItem("D");
		comboBoxRegisterStudentToCourseGrade.addItem("C");
		comboBoxRegisterStudentToCourseGrade.addItem("B");
		comboBoxRegisterStudentToCourseGrade.addItem("A");
		comboBoxRegisterStudentToCourseGrade.setBounds(209, 353, 160, 22);
		register.add(comboBoxRegisterStudentToCourseGrade);
		
		/*
		JButton btnRegsterStudentToCourseGetCourses = new JButton("Get courses");
		btnRegsterStudentToCourseGetCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModelManageStudents.setRowCount(0);
				lblRegisterStudentToCourseMessage.setText("");
				lblRegisterStudentToCourseMessage.setForeground(Color.BLACK);
				//try {
					ArrayList<Course> courses = new ArrayList<Course>();
					//courses = controllerTask1.getAllCourses();
					for (Course tmp : courses) {
						dataModelManageStudents.addRow(new Object[] { tmp.getCode(), tmp.getName(), tmp.getCredit() });
					}
				/*} catch (SQLException sq) {
					lblRegisterStudentToCourseMessage.setForeground(Color.RED);
					lblRegisterStudentToCourseMessage.setText(sq.getMessage());
				}*/ /*
			}
		});
		btnRegsterStudentToCourseGetCourses.setBounds(396, 267, 105, 25);
		register.add(btnRegsterStudentToCourseGetCourses);
		*/
		
		JButton btnRegisterStudentToCourseRegister = new JButton("Register");
		btnRegisterStudentToCourseRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRegisterStudentToCourseMessage.setText("");
				String ssn = txtRegisterStudentToCourseSsn.getText();
				String courseCode = txtRegisterStudentToCourseSemester.getText();
				String cbState = (String) comboBoxRegisterStudentToCourseState.getSelectedItem();
				String cbGrade = (String) comboBoxRegisterStudentToCourseGrade.getSelectedItem();
				lblRegisterStudentToCourseMessage.setForeground(Color.BLACK);
				int selectedRow = tableManageStudents.getSelectedRow();
				System.out.println(cbState);

				if (ssn.isEmpty() || courseCode.isEmpty()) {
					lblRegisterStudentToCourseMessage.setForeground(Color.RED);
					lblRegisterStudentToCourseMessage.setText("you have to enter Social security number and course code");
				} else {
					try {
						if ((selectedRow >= 0) && cbState.equals(cbNewCourse)) {
							Controller.registerNewStudent(ssn, courseCode.toUpperCase());
							lblRegisterStudentToCourseMessage.setText("Student is now registered on the course");
						}
						if ((selectedRow >= 0) && cbState.equals(cbCompletedCourse)) {
							if (cbGrade.isEmpty()) {
								lblRegisterStudentToCourseMessage.setForeground(Color.RED);
								lblRegisterStudentToCourseMessage.setText("Grade must be selected");
							} else {
								Controller.registerOldStudentDal(ssn, courseCode, cbGrade);
								lblRegisterStudentToCourseMessage.setText("Final grade registered");
							}
						}
						if (cbState.equals("")) {
							lblRegisterStudentToCourseMessage.setForeground(Color.RED);
							lblRegisterStudentToCourseMessage.setText("Välj status");
						}
					} catch (SQLException sqlException) {
						lblRegisterStudentToCourseMessage.setForeground(Color.RED);
						lblRegisterStudentToCourseMessage.setText(
								SQLErrorMapping.getMessageForErrorCode(sqlException.getErrorCode(), "Student"));

					} catch (RuntimeException rtException) {
						lblRegisterStudentToCourseMessage.setForeground(Color.RED);
						lblRegisterStudentToCourseMessage.setText("Credit on student exceeds 45");
					} 
				}
			}

		});
		btnRegisterStudentToCourseRegister.setBounds(210, 388, 97, 25);
		register.add(btnRegisterStudentToCourseRegister);
		
		/*
		JScrollPane scrollPaneCourses = new JScrollPane();
		scrollPaneCourses.setBounds(519, 238, 502, 362);
		register.add(scrollPaneCourses);
		
		tableCoursesHeader = new JTable();
		tableCoursesHeader.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneCourses.setColumnHeaderView(tableCoursesHeader);
		*/

	
		
		JPanel search = new JPanel();
		masterTabPane_1.addTab("Search", null, search, null);
		search.setLayout(null);
		
		dataModelCourseInformation = new DefaultTableModel();

		
		JLabel lblSearchCourseCode = new JLabel("Course code:");
		lblSearchCourseCode.setBounds(20, 15, 76, 16);
		search.add(lblSearchCourseCode);
		
		JLabel lblSearchStudentSsn = new JLabel("Student ssn:");
		lblSearchStudentSsn.setBounds(20, 45, 72, 16);
		search.add(lblSearchStudentSsn);
		
		txtSearchCourseCode = new JTextField();
		txtSearchCourseCode.setBounds(120, 12, 183, 22);
		search.add(txtSearchCourseCode);
		txtSearchCourseCode.setColumns(10);
		
		txtSearchStudentSsn = new JTextField();
		txtSearchStudentSsn.setColumns(10);
		txtSearchStudentSsn.setBounds(120, 42, 183, 22);
		search.add(txtSearchStudentSsn);
		
		table = new JTable(dataModelCourseInformation);
		table.setModel(new DefaultTableModel());
		table.setBounds(364, 15, 833, 563);
		search.add(table);
		
		JLabel lblSearchMessage = new JLabel("");
		lblSearchMessage.setBounds(20, 194, 283, 20);
		search.add(lblSearchMessage);
		
		JButton btnSearchShowResultsForCourse = new JButton("Show results for course");
		btnSearchShowResultsForCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn = txtSearchStudentSsn.getText();
				String courseCode = txtSearchCourseCode.getText();
				dataModelCourseInformation.setRowCount(0);
				lblSearchMessage.setText(null);
				lblSearchMessage.setForeground(Color.BLACK);
				try {
					if (courseCode.isEmpty() || ssn.isEmpty()) {
						lblSearchMessage.setForeground(Color.RED);
						lblSearchMessage.setText("Course code must be entered to fetch information");
					} else {
						String [] headerCourses = {"SSN", "Name", "Course name", "Grade"};
						dataModelCourseInformation.setColumnIdentifiers(headerCourses);
						ArrayList<HasStudied> allResults = Controller.getAllStudentsResultsFromCourse(courseCode);
						if (allResults.isEmpty()) {
							lblSearchMessage.setText("No students have taken the course");
							lblSearchMessage.setForeground(Color.RED);
						} else {
							for (HasStudied s : allResults) {
								String studentName = Controller.findStudentDal(s.getStudentSSN()).getStudentName();
								String courseName = Controller.findCourseDal(s.getCourseID()).getCourseName();
								dataModelCourseInformation.addRow(new Object[] { s.getStudentSSN(), studentName, courseName, s.getGrade() });
								lblSearchMessage.setText("test");
							}
						}
					}
				}catch (SQLException sqlException) {
					lblSearchMessage.setForeground(Color.RED);
					lblSearchMessage.setText(SQLErrorMapping.getMessageForErrorCode(sqlException.getErrorCode(), ""));
				}

			}
		});
		btnSearchShowResultsForCourse.setBounds(120, 76, 183, 25);
		search.add(btnSearchShowResultsForCourse);
		
		JButton btnSearchStudentInformation = new JButton("Student information");
		btnSearchStudentInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentSsn = txtSearchStudentSsn.getText();
				dataModelCourseInformation.setRowCount(0);
				lblSearchMessage.setText(null);
				lblSearchMessage.setForeground(Color.BLACK);
				if (studentSsn.isEmpty()) {
					lblSearchMessage.setForeground(Color.RED);
					lblSearchMessage.setText("SSN must be entered to fetch information");
				} else {				
					try {
						String [] headerCourses = {"SSN", "Name", "adress"};
						dataModelCourseInformation.setColumnIdentifiers(headerCourses);
						AddStudent student = Controller.findStudentDal(studentSsn);
						dataModelCourseInformation.addRow(new Object[] { AddStudent.getStudentSSN(), AddStudent.getStudentName(), AddStudent.getStudentAdress() });
					} catch (SQLException sqlException) {
						lblSearchMessage.setForeground(Color.RED);
						lblSearchMessage.setText(SQLErrorMapping.getMessageForErrorCode(sqlException.getErrorCode(), ""));
						
					}
					
				}
			}
		});
		btnSearchStudentInformation.setBounds(120, 103, 183, 25);
		search.add(btnSearchStudentInformation);
		
		JButton btnSearchStudentInfoForCourse = new JButton("Student result for course");
		btnSearchStudentInfoForCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = txtSearchCourseCode.getText();
				String ssn = txtSearchStudentSsn.getText();
				dataModelCourseInformation.setRowCount(0);
				lblSearchMessage.setText(null);
				lblSearchMessage.setForeground(Color.BLACK);
				try {
					if (ssn.isEmpty()){
						lblSearchMessage.setForeground(Color.RED);
						lblSearchMessage.setText("SSN must be entered to fetch information");
					} else {
						String [] headerCourses = {"SSN", "Name", "Course name", "Grade"};
						dataModelCourseInformation.setColumnIdentifiers(headerCourses);
						HasStudied studentResults = Controller.findResultFromCourse(ssn, courseCode);
						if (studentResults == null) {
							lblSearchMessage.setText("The student does not have any final grade in a course");
						} else {
							
							String studentName = Controller.findStudentDal(ssn).getStudentName();
							String courseName = Controller.findCourseDal(courseCode).getCourseName();
							dataModelCourseInformation.addRow(new Object[] { HasStudied.getStudentSSN(), studentName, courseName, HasStudied.getGrade() });
							
						}
					}
				}catch (SQLException sqlException) {
					lblSearchMessage.setForeground(Color.RED);
					lblSearchMessage.setText(SQLErrorMapping.getMessageForErrorCode(sqlException.getErrorCode(), ""));
				}
				
			}
		});
		btnSearchStudentInfoForCourse.setBounds(120, 130, 183, 25);
		search.add(btnSearchStudentInfoForCourse);
		
		JButton btnSearchCourseInformation = new JButton("Course information");
		btnSearchCourseInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = txtSearchCourseCode.getText();
				dataModelCourseInformation.setRowCount(0);
				lblSearchMessage.setText(null);
				lblSearchMessage.setForeground(Color.BLACK);
				if (courseCode.isEmpty()) {
					lblSearchMessage.setForeground(Color.RED);
					lblSearchMessage.setText("Course code must be entered to fetch information");
				} else {				

					String [] headerCourses = {"Course Code", "Course name", };
					dataModelCourseInformation.setColumnIdentifiers(headerCourses);
					try {
						AddCourse course = Controller.findCourseDal(courseCode);
					} catch (SQLException sqlException) {
						lblSearchMessage.setForeground(Color.RED);
						lblSearchMessage.setText(SQLErrorMapping.getMessageForErrorCode(sqlException.getErrorCode(), ""));
					}
					
				}
			}
		});
		btnSearchCourseInformation.setBounds(120, 158, 183, 25);
		search.add(btnSearchCourseInformation);
	}
}
