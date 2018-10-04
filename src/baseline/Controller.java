package baseline;

import java.util.*;
import java.sql.SQLException;
import table.Student;
import table.Course; 

public class Controller {
	
	private static DAL dal;
	
	public Controller() {
		dal = new DAL();
	}
		// ADD
		public static void addStudentDal(String studentSSN, String studentName, String studentAdress) throws SQLException {
			AddStudent student= new AddStudent();
			student.setStudentName(studentName);
			student.setStudentSSN(studentSSN);
			student.setStudentAdress(studentAdress);
			dal.addStudent(student);
			
	}
		// Isn't courseCredit needed for assignment 1?
		public static void addCourseDal(String courseID, String courseName) throws SQLException {
			AddCourse course = new AddCourse();
			course.setCourseID(courseID);
			course.setCourseName(courseName);
			//course.setCourseCredit(courseCredit);
			dal.addCourse(course);
		}
		public static void registerOldStudentDal (String studentSSN, String courseID, String grade) throws SQLException {
			HasStudied oldstudent = new HasStudied();
			oldstudent.setStudentSSN(studentSSN);
			oldstudent.setCourseID(courseID);
			oldstudent.setGrade(grade);
			dal.RegisterOldStudent(oldstudent);
		}
		public static void registerNewStudent (String studentSSN, String courseID) throws SQLException {
			Studies newstudent = new Studies();
			newstudent.setStudentSSN(studentSSN);
			newstudent.setCourseID(courseID);
			dal.RegisterNewStudent(newstudent);
		}
		// FIND
		public static AddStudent findStudentDal(String studentSSN) throws SQLException {
			return dal.findStudent(studentSSN);
			
		}
		public static AddCourse findCourseDal(String courseID) throws SQLException {
			return dal.findCourse(courseID);
		}
		public static HasStudied findResultFromCourse(String studentSSN, String courseID) throws SQLException {
			return dal.findResultFromCourse(studentSSN, courseID);
		}
		public static ArrayList<HasStudied> getAllStudentsResultsFromCourse(String courseID) throws SQLException {
			return dal.getAllStudentsResultsFromCourse(courseID);
		}	
}
	


