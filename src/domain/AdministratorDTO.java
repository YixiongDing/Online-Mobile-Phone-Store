package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class AdministratorDTO implements Serializable {

	private int userId;
	private String name;
	private String email;
	private String address;
	private String password;
	private String usertype;






	public int getAdministratorId() {
		return userId;
	}
	public void setAdministratorId(int userId) {
		this.userId = userId;
	}
	public String getAdministratorName() {
		return name;
	}
	public void setAdministratorName(String name) {
		this.name = name;
	}

	public String getAdministratorEmail() {
		return email;
	}
	public void setAdministratorEmail(String email) {
		this.email=email;
	}
	public String getAdministratorAddress() {
		return address;
	}
	public void setAdministratorAddress(String address) {
		this.address = address;
	}

	public String getAdministratorPassword() {
		return password;
	}
	public void setAdministratorPassword(String password) {
		this.password = password;
	}
	public String getAdministratorUserType() {
		return usertype;
	}
	public void setAdministratorUserType(String usertype) {
		this.usertype = usertype;
	}


	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();

	}

	public static AdministratorDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (AdministratorDTO) JSONObject.toBean(json, AdministratorDTO.class);
	}
}