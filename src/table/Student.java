package table;

public class Student {

	private String ssn;
	private String name;
	private String adress;
	
	public Student() {}


	public Student(String pnr, String name, String adress) {
		this.ssn = ssn;
		this.name = name;
		this.adress = adress;

	}

	public String getSsn() {
		return ssn;
	}

	public void setPnr(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAddress(String adress) {
		this.adress = adress;
	}

}
