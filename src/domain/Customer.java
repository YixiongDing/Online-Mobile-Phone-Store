package domain;


public class Customer extends User {
   

    public Customer(int userId, String name, String email, String address, String password) {
    	super(userId, name, email, address,"CUSTOMER", password);

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
	
	public String getCustomerAddress() {
		return getAddress();
	}
	
	public void setCustomerAddress(String address) {
		setAddress(address);
	}
	
	public String getCustomerPassword() {
		return getPassword(); 
	}
	
	public void setCustomerPassword(String password) {
		setPassword(password);
	}
	
	public String getCustomerUserType() {
		return getUserType();
	}
	
	public void setCustomerUserType(String usertype) {
		setUserType(usertype);
	}

	
}