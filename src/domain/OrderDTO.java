package domain;

import java.util.Date;

import net.sf.json.JSONObject;

public class OrderDTO {
	
	private int orderId;
	private Date createTime;
	private String status;
	private MobilePhoneDTO mobilePhone;
	private CustomerDTO customer;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
		
	}
	public Date getCreateTime() {
		return createTime;

	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		
	}
	public String getStatus() {

		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		
	}
	public MobilePhoneDTO getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(MobilePhoneDTO mobilePhone) {
		this.mobilePhone = mobilePhone;
		
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
		
	}
	
	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
		
	}

	public static OrderDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (OrderDTO) JSONObject.toBean(json, OrderDTO.class);
	}
	

}
