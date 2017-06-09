package ALMSDao;

public class Request {
	int id;
	String farmerName;
	String laborName;
	public Request() {
	}
	public Request(int id, String farmerName, String laborName) {
		super();
		this.id = id;
		this.farmerName = farmerName;
		this.laborName = laborName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getLaborName() {
		return laborName;
	}
	public void setLaborName(String laborName) {
		this.laborName = laborName;
	}
	
	
	
	
	


}
