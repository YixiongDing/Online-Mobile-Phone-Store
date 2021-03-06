package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class CustomerDTO implements Serializable{


	private int userId;
	private String name;
	private String email;
	private String address;
	private String password;
	private String usertype;



	public int getCustomerId() {
		return userId;
	}

	public void setCustomerId(int userId) {
		this.userId = userId;
	}
	public String getCustomerName() {
		return name;
	}
	public void setCustomerName(String name) {
		this.name = name;
	}

	public String getCustomerEmail() {
		return email;
	}
	public void setCustomerEmail(String email) {
		this.email=email;
	}
	public String getCustomerAddress() {
		return address;
	}
	public void setCustomerAddress(String address) {
		this.address=address;
	}
	public String getCustomerPassword() {
		return password;
	}
	public void setCustomerPassword(String password) {
		this.password = password;
	}
	public String getCustomerUserType() {
		return usertype;
	}
	public void setCustomerUserType(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();

	}

	public static CustomerDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (CustomerDTO) JSONObject.toBean(json, CustomerDTO.class);
	}

}