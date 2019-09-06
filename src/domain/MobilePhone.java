package domain;
import database.MobileFinder;
import database.MobileGateway;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

	private String id;

    private String brand;

    private String model;
   
    private float price;
    
    private int qty;

    public MobilePhone(String id, String brand, String model, float price, int qty) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.setQty (qty);
    }

    public MobilePhone() {
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    public static List<MobilePhone> getAllAvailableMobiles() {
        MobileFinder finder = new MobileFinder();
        List<MobilePhone> result = new ArrayList<MobilePhone>();
        List<MobileGateway> mobilesRecords = finder.findAvailableMobiles();

        for (MobileGateway mr : mobilesRecords) {
            MobilePhone mobilephone = new MobilePhone(String.valueOf(mr.getId()), mr.getBrand(), mr.getModel(), mr.getPrice(), mr.getQty());
            result.add(mobilephone);
        }

        return result;

    }

}
