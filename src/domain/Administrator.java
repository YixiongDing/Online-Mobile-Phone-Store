package domain;

public class Administrator extends User {

	public Administrator(int userId, String name, String userType, String email, String address, String password) {
		super(userId, name, "Admin", email, address, password);
	}

	 public Administrator() {
	    	super();
	    	
	    	
	    }
	
	@Override
	public String getId() {
		return ""+this.getUserId();
	}
	
	public int getAdminId() {
		return getUserId();
	}
	public void setAdminId(int userId) {
		setUserId(userId);
	}
	public String getAdminName() {
		return getName();
	}
	public void setAdminName(String name) {
		setName(name);
	}

	public String getAdminEmail() {
		return getEmail();
	}
	public void setAdminEmail(String email) {
		setEmail(email);
	}
	public String getAdminAddress() {
		return getAddress();
	}
	public void setAdminAddress(String address) {
		setAddress(address);
	}
	public String getAdminPassword() {
		return getPassword(); 
	}
	
	public void setAdminPassword(String password) {
		setPassword(password);
	}
}
