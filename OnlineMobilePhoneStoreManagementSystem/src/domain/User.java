package domain;


public class User extends DomainObject {
	
	private String name;
	private String userType;
	private int userId;
	private String email;
	private String address;
	
	
	public User(int userId, String name, String userType,String email,String address) {
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
	
}
