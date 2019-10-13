package domain;

import net.sf.json.JSONObject;

public class MobilePhoneDTO {

	private int mobilePhoneId;
	private String brand;
	private String modelName;
	private String storageSize;
	private String color;
	private float price;
	private int qty;
	private String description;

	public int getMobilePhoneId() {
		return mobilePhoneId;
	}

	public void setMobilePhoneId(int mobilePhoneId) {
		this.mobilePhoneId = mobilePhoneId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;		
	}

	public void setModelName(String modelName) {
		this.modelName= modelName;
	}

	public String getStorageSize() {
		return storageSize;		
	}

	public void setStorageSize(String storageSize) {
		this.storageSize=storageSize;
	}

	public String getColor() {
		return color;	
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDescription() {
		return description;		
	}

	public void setDescription(String description) {
		this.description = description;		
	}
	
	/**
	 * A method to transfrom to JSON string
	 * @return JSONObject
	 */
	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
		
	}
	
	/**
	 * A method to read in data transfer objject
	 * @param String s
	 * @return JSONObject
	 */
	public static MobilePhoneDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (MobilePhoneDTO) JSONObject.toBean(json, MobilePhoneDTO.class);
	}
}
