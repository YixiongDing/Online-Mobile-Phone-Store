package database;

import java.sql.*;

public class MobileGateway {
	private int id;
	 private String model;
	 private String brand;
	 private float  price;
	 private int qty;
	 private static final String updateStatementString =
	         "UPDATE mobilephones " +
	         "  set model = ?, brand = ?, price = ?, qty = ? " +
	         "  where id = ?";
	
	 private static final String insertStatementString =
	         "INSERT INTO mobilephones VALUES (?, ?, ?, ?, ?)";
	 
	 
	 public MobileGateway(int id, String model, String brand, float price, int qty) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.qty = qty;
	}
	
	public MobileGateway() {
	}

	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
   public void update() {
      PreparedStatement updateStatement = null;
      try {
         updateStatement = DBConnection.prepare(updateStatementString);
         updateStatement.setString(1, model);
         updateStatement.setString(2, brand);
         updateStatement.setFloat(3, price);
         updateStatement.setInt(4, qty);
         updateStatement.setInt(5, id);

         updateStatement.execute();
      } catch (Exception e) {
    
      }
   }
		  
   public int insert() {
      PreparedStatement insertStatement = null;
      try {
         insertStatement = DBConnection.prepare(insertStatementString);
         insertStatement.setInt(1,id);
         insertStatement.setString(2, model);
         insertStatement.setString(3, brand);
         insertStatement.setFloat(4, price);
         insertStatement.setInt(5, qty);

         insertStatement.execute();
         Registry.addMobile(this);
      } catch (SQLException e) {
      }
      return getId();

   }

   public static MobileGateway load(ResultSet rs) throws SQLException {
       int id = rs.getInt(1);
       MobileGateway result = (MobileGateway) Registry.getMobile(id);
       if (result  != null) 
    	   return result;
       String modelArg = rs.getString(2);
       String brandArg = rs.getString(3);
       int priceArg = rs.getInt(4);
       int qtyArg = rs.getInt(5);
       result = new MobileGateway(id, modelArg, brandArg, priceArg,qtyArg);
       Registry.addMobile(result);
       return result;
 }
}


