package domain;

import dataMapper.OrderMapper;

import java.util.Date;

public class Order extends DomainObject {
	
	private int orderId;
	private Date createTime;
	private String status;
	private MobilePhone mobilePhone;
	private Customer customer; // foreign key mapping 

	public Order() {
		
	}
	
	public Order(MobilePhone mobilePhone, Customer customer, String status) {
		super();
		this.mobilePhone = mobilePhone;
		this.customer = customer;
		this.status = status;
	}
	
	
	@Override
	public String getId() {
		return ""+this.orderId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
		
	}
	
	public Date getCreateTime() {
		if (this.createTime == null)
			load();
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		
	}
	
	public String getStatus() {
		if (this.status == null)
			load();
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
		
	}
	
	public MobilePhone getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone(MobilePhone mobilePhone) {
		this.mobilePhone = mobilePhone;
		
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
		
	}
	
	/*
	 * Using lazy load to reduce the amount of data that read to the memory
	 */
	private void load() {
		OrderMapper  orderMapper = new OrderMapper();
		Order record = orderMapper.findOrderByOrderId(this).get(0);
		
		if (this.createTime == null) {
			this.createTime = record.getCreateTime();
		}
		if (this.status == null) {
			this.status = record.getStatus();
		}
	}
}
