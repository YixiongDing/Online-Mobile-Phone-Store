package domain;

import java.util.ArrayList;
import java.util.List;

import dataMapper.MobilePhoneMapper;

public class MobilePhone extends DomainObject{

	private int mobilePhjoneId;

    private String brand;

    private String model;
   
    private float price;
    
    private int qty;
    
    private String description;

    public MobilePhone(int mobilePhjoneId, String brand, String model, float price, int qty, String description) {
        this.mobilePhjoneId = mobilePhjoneId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.qty = qty;
        this.description = description;
    }
    
	@Override
	public String getId() {
		return String.valueOf(this.mobilePhjoneId);
	}

    public MobilePhone() {
	}

	public int getMobileId() {
        return mobilePhjoneId;
    }

    public void setId(int mobilePhjoneId) {
        this.mobilePhjoneId = mobilePhjoneId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;		
    }

    public void setModel(String model) {
        this.model = model;
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
}
