package domain;


public class Customer extends  User {

	
   

    public Customer(int userId, String name, String email, String address) {
    	super(userId,name,"Customer",email,address);

    }
    
    
    public Customer() {
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