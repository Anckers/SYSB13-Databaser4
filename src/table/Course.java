package table;

public class Course {
	private String code;
	private String name;
	private double credit;
	
	public Course() {
		
	}
	
	public Course(String code, String name, double credit){
		this.code=code;
		this.name=name;
		this.credit=credit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}
	
}
