package ALMSDao;

public class Labor {

	int id;
	String name;
	String password;
	String gender;
	String dob;
	String location;
	double wages;
	
	
	public Labor() {
		// TODO Auto-generated constructor stub
	}


	public Labor(int id, String name, String password, String gender,
			String dob, String location, double wages) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.location = location;
		this.wages = wages;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public double getWages() {
		return wages;
	}


	public void setWages(double wages) {
		this.wages = wages;
	}
	
		
	
}
