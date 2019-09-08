package domain;
import database.MobileFinder;
import database.MobileGateway;

import java.util.ArrayList;
import java.util.List;

import DataMapper.MobileMapper;

public class MobilePhone extends DomainObject{

	private int mobilePhjoneId;

    private String brand;

    private String model;
   
    private float price;
    
    private int qty;

    public MobilePhone(int mobilePhjoneId, String brand, String model, float price, int qty) {
        this.mobilePhjoneId = mobilePhjoneId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.setQty (qty);
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


//    public static List<MobilePhone> getAllAvailableMobiles() {
//        MobileFinder finder = new MobileFinder();
//        List<MobilePhone> result = new ArrayList<MobilePhone>();
//        List<MobileGateway> mobilesRecords = finder.findAvailableMobiles();
//
//        for (MobileGateway mr : mobilesRecords) {
//            MobilePhone mobilephone = new MobilePhone(mr.getId(), mr.getBrand(), mr.getModel(), mr.getPrice(), mr.getQty());
//            result.add(mobilephone);
//        }
//
//        return result;
//
//    }
    
    public static List<MobilePhone> getAllAvailableMobiles() {
        MobileMapper mapper = new MobileMapper();
        System.out.println("this is mapper");
        List<MobilePhone> result = new ArrayList<MobilePhone>();
        result = mapper.findAvailableMobiles();
        return result;

    }
    
    public static List<MobilePhone> getAllMobiles() {
        MobileMapper mapper = new MobileMapper();
        System.out.println("this is all");
        List<MobilePhone> result = new ArrayList<MobilePhone>();
        result = mapper.findAllMobilePhone();
        return result;

    }

}
