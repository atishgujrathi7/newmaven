package ALMSDao;

public class Farmer implements Comparable {
	
	int id;
	String name;
	String password;
	String location;
	double amount;
	
	public Farmer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Farmer(int id, String name, String password, String location,
			double amount) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.location = location;
		this.amount = amount;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		
		Farmer f = (Farmer)arg0;
		return this.id-f.id;
	}
	
	public boolean equals()
	{
		Farmer f = new Farmer();
		if(f.id == this.id)
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
