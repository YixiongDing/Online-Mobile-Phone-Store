package domain;


import dataMapper.AdministratorMapper;
import dataMapper.CustomerMapper;


public class User extends DomainObject {
	
	private String name;
	private String userType;
	private int userId;
	private String email;
	private String address;
	private String password;

	
	public User(int userId, String name,String email,String address,String userType) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.email=email;
        this.address = address;

    }
	
	
	public User() {
		
		
	}
	
	
	public int getUserId() {
		return userId;
	}
    
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
    
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserType() {
		return userType;
	}
    
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public void setPassword(String password) {
		this.password = password;
		
	}
	
	public String getPassword() {
		return password;
		
	}
	
	public static User getUser(String username) {
		
		Administrator admin = AdministratorMapper.getAdminByName(username);
		Customer customer = CustomerMapper.getCustomerByName(username);
		
		
		if( admin != null) {
			
			return admin;
		}else if(customer != null) {
			
			return customer;
		}
		
		return null;
		
		
	}

	
}
