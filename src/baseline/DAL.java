package baseline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import table.Course;
import table.Student;

//import databaseConnection.DBConnection;
//import modelTask1.Course;
//import modelTask1.Student;
//import modelTask1.Studied;

public class DAL {
	
	private ResultSet rs;
	private Connection connection = null;
	private PreparedStatement pStmt = null;
	
		// Startar connection, kˆr preparedStatement sedan h‰mtar ResultSet
		private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		connection = ConnectionFac.startConnection();
		pStmt = connection.prepareStatement(sqlString);
		ResultSet rs = pStmt.executeQuery();
		return rs;
	}

		// Startar connecntion, kˆr preparedStatement sedan uppdaterar databasen
		private void runExecuteUpdate(String sqlString) throws SQLException {
		connection = ConnectionFac.startConnection();
		pStmt = connection.prepareStatement(sqlString);
		pStmt.executeUpdate();
	}
	
	
			// ADD
			public void addStudent(AddStudent student) throws SQLException {
				ConnectionFac connect = new ConnectionFac();
				Connection connection = connect.startConnection();
				
				try{
					PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Student (studentSSN, studentName, studentAdress) VALUES (?,?,?)");
					pstmt.setString(1, student.getStudentSSN());
					pstmt.setString(2, student.getStudentName());
					pstmt.setString(3, student.getStudentAdress());
					pstmt.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				connection.close();
			}
			public void addCourse(AddCourse course) throws SQLException {
				
				ConnectionFac connect = new ConnectionFac();
				Connection connection = connect.startConnection();
			
				try{
					PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Course (courseID, courseName) VALUES (?,?)");
					pstmt.setString(1, course.getCourseID());
					pstmt.setString(2, course.getCourseName());
					
					pstmt.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				connection.close();
			}
			public void RegisterOldStudent(HasStudied studied) throws SQLException {
				ConnectionFac connect = new ConnectionFac();
				Connection connection = connect.startConnection();
				
				try{
					PreparedStatement pstmt = connection.prepareStatement("INSERT INTO HasStudied VALUES (?, ?, ?");
					pstmt.setString(1, studied.getStudentSSN());
					pstmt.setString(2, studied.getCourseID());
					pstmt.setString(3, studied.getGrade());
					pstmt.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();	
				}
				connection.close();
			}
			public void RegisterNewStudent(Studies studies) throws SQLException {
				
				ConnectionFac connect = new ConnectionFac();
				Connection connection = connect.startConnection();
				
				try{
					PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Studies VALUES (?, ?");
					pstmt.setString(1, studies.getStudentSSN());
					pstmt.setString(2, studies.getCourseID());
					pstmt.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				connection.close();
			}
			// FIND
			public AddStudent findStudent(String studentSSN) throws SQLException {
				AddStudent s;
				String sqlString = "SELECT * FROM Student WHERE studentSSN = '" + studentSSN + "'";
				ResultSet rs = runExecuteQuery(sqlString);
				if (rs.next()) {
					studentSSN = rs.getString(1);
					String studentName = rs.getString(2);
					String studentAddress = rs.getString(3);
					s = new AddStudent(studentSSN, studentName, studentAddress);
					connection.close();
					return s;
				}
				return null;
			}
			public AddCourse findCourse(String courseID) throws SQLException {
				String sqlString = "SELECT * from Course WHERE courseID = '" + courseID + "';";
				ResultSet rs = runExecuteQuery(sqlString);
				if (rs.next()) {
					courseID = rs.getString(1);
					String courseName = rs.getString(2);
					AddCourse c = new AddCourse(courseID, courseName);
					pStmt.close();
					connection.close();
					return c;
				}
				pStmt.close();
				connection.close();
				return null;

			}
			public Studies findCurrentStudent(String studentSSN, String courseID) throws SQLException {
				
				ConnectionFac connect = new ConnectionFac();
				Connection connection = connect.startConnection();
				rs = null;
				Studies cs = new Studies();
					
				try {
						PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Studies WHERE studentSSN=? AND courseID=?");
						pstmt.setString(1, cs.getStudentSSN());
						pstmt.setString(2, cs.getCourseID());
						rs = pstmt.executeQuery();
						if (rs.next()) {
							cs = new Studies(rs.getString("studentSSN"), rs.getString("courseID"));
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					return cs;
			}
			public HasStudied findResultFromCourse(String studentSSN, String courseID) throws SQLException {
				HasStudied hs = null;
				String sqlString = "SELECT * FROM Studied WHERE courseID = '" + courseID + "' and studentSSN = '" + studentSSN + "';";
				ResultSet rs = runExecuteQuery(sqlString);
				if (rs.next()) {
					studentSSN = rs.getString(1);
					courseID = rs.getString(2);
					String grade = rs.getString(3);
					hs = new HasStudied(studentSSN, courseID, grade);
				}
				connection.close();
				return hs;
			}
			//Find Lists

			public ArrayList<HasStudied> getAllStudentsResultsFromCourse(String courseID) throws SQLException {
				ArrayList<HasStudied> studentGrades = new ArrayList<HasStudied>();
				String sqlString = "SELECT * FROM Studied WHERE courseID = '" + courseID + "'";
				ResultSet rs = runExecuteQuery(sqlString);
				while (rs.next()) {
					String studentSSN = rs.getString(1);
					courseID = rs.getString(2);
					String grade = rs.getString(3);
					HasStudied s = new HasStudied(studentSSN, courseID, grade);
					studentGrades.add(s);
				}
				connection.close();
				return studentGrades;
			}
			// DELETE

				

}
