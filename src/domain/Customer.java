package domain;


public class Customer extends User {
   

    public Customer(int userId, String name, String email, String address, String password) {
    	super(userId, name, "Customer", email, address, password);

    }
    
    
    public Customer() {
    	super();	
    	
    }
	
	@Override
	public String getId() {
		return ""+this.getUserId();
	}
	
	public int getCustomerId() {
		return getUserId();
	}
	
	public void setCustomerId(int userId) {
		setUserId(userId);
	}
	
	public String getCustomerName() {
		return getName();
	}
	
	public void setCustomerName(String name) {
		setName(name);
	}

	public String getCustomerEmail() {
		return getEmail();
	}
	
	public void setCustomerEmail(String email) {
		setEmail(email);
	}
	
	public String getCustomerPostAddress() {
		return getAddress();
	}
	
	public void setCustomerPostAddress(String address) {
		setAddress(address);
	}
	
	public String getCustomerPassword() {
		return getPassword(); 
	}
	
	public void setCustomerPassword(String password) {
		setPassword(password);
	}
	
	
}