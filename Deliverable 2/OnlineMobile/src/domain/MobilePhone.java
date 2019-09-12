package domain;


public class MobilePhone extends DomainObject{

	private int mobilePhoneId;

    private String brand;
   
    private float price;
    
    private int qty;
    
    private Model model;

    public MobilePhone(int mobilePhoneId, String brand, Model model, float price, int qty) {
        this.mobilePhoneId = mobilePhoneId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.setQty (qty);
    }
    
	@Override
	public String getId() {
		return String.valueOf(this.mobilePhoneId);
	}

    public MobilePhone() {
    	this.model = new Model();
	}

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
        return model.getModelName();		
    }

    public void setModelName(String modelName) {
        model.setModelName(modelName);
    }
    
    public String getStorageSize() {
        return model.getStorageSize();		
    }

    public void setStorageSize(String storageSize) {
        model.setStorageSize(storageSize);
    }

    
	public String getColor() {
			
			return model.getColor();	
			
	}
		
	public void setColor(String color) {
			
			model.setColor(color);;
			
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
}
