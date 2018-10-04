package baseline;

public class AddStudent {

	private static String studentSSN;
	private static String studentName;
	private static String studentAdress;
	
	public AddStudent() {	
	}
	
	public AddStudent(String studentSSN, String studentName, String studentAdress) {
		this.studentSSN = studentSSN;
		this.studentName = studentName;
		this.studentAdress = studentAdress;
	}
	public static String getStudentSSN() {
		return studentSSN;
	}
	public void setStudentSSN(String studentSSN) {
		this.studentSSN = studentSSN;
	}
	public static String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public static String getStudentAdress() {
		return studentAdress;
	}
	public void setStudentAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}
	}