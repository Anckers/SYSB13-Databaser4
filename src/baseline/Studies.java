package baseline;

public class Studies {
	
	private String studentSSN;
	private String courseID;

public Studies(){
		
	}
	public Studies(String studentSSN,String courseID){
		this.studentSSN = studentSSN;
		this.courseID = courseID;
	}
	
		public String getStudentSSN() {
			return studentSSN;
		}
		public void setStudentSSN(String studentSSN) {
			this.studentSSN = studentSSN;
		}
		public String getCourseID() {
			return courseID;
		}
		public void setCourseID(String courseID) {
			this.courseID = courseID;
		}
}

