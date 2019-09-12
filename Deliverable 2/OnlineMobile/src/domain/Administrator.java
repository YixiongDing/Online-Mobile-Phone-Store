package domain;

public class Administrator extends User {

	public Administrator(int userId, String name, String userType, String email, String address) {
		super(userId,name,"Admin",email,address);
	}

	 public Administrator() {
	    	super();
	    	
	    	
	    }
	
	@Override
	public String getId() {
		return ""+this.getUserId();
	}
	
	public int getUserId() {
		return getUserId();
	}
	public void setCustomerId(int userId) {
		setUserId(userId);
	}
	public String getname() {
		return getName();
	}
	public void setname(String name) {
		setName(name);
	}

	public String getEmail() {
		return getEmail();
	}
	public void setEmail(String email) {
		setEmail(email);
	}
	public String getAddress() {
		return getAddress();
	}
	public void setAddress(String address) {
		setAddress(address);
	}
}
