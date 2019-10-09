package domain;

public class Administrator extends User {

	public Administrator(int userId, String name, String userType, String email, String address) {
		super(userId,name,email,address,"ADMIN");
	}

	 public Administrator() {
	    	super();
	    	
	    	
	    }
	
	@Override
	public String getId() {
		return ""+this.getUserId();
	}
	
	public int getAdministratorId() {
		return getUserId();
	}
	public void setAdministratorId(int userId) {
		setUserId(userId);
	}
	public String getAdministratorName() {
		return getName();
	}
	public void setAdministratorName(String name) {
		setName(name);
	}

	public String getAdministratorEmail() {
		return getEmail();
	}
	public void setAdministratorEmail(String email) {
		setEmail(email);
	}
	public String getAdministratorAddress() {
		return getAddress();
	}
	public void setAdministratorAddress(String address) {
		setAddress(address);
	}
}
