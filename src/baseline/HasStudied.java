package baseline;

public class HasStudied {
	
	private static String studentSSN;
	private static String courseID;
	private static String grade;
	
	
	public HasStudied(){
	}
	public HasStudied(String studentSSN, String courseID, String grade){
		this.studentSSN = studentSSN;
		this.courseID = courseID;
		this.grade = grade;
	}
	
	public static String getStudentSSN() {
		return studentSSN;
	}
	public void setStudentSSN(String studentSSN) {
		this.studentSSN = studentSSN;
	}
	public static String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public static String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}

