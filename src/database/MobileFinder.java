package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobileFinder {
	
	private final static String findStatementString =
	         "SELECT * " +
	         "  from mobilephones " +
	         "  WHERE id = ?";
	 private static final String findAvaliableMobilesStatement =
	         "SELECT * from mobilephones WHERE qty > 0";
	 
	 
	public MobileGateway find(int id) {
        MobileGateway result = Registry.getMobile(id);
	      if (result  != null) 
	    	  return result;
	      PreparedStatement findStatement = null;
	      ResultSet rs = null;
	      try {
	         findStatement = DBConnection.prepare(findStatementString);
	         findStatement.setInt(1, id);
	         rs = findStatement.executeQuery();
	         rs.next();
	         result = MobileGateway.load(rs);
	          
	      } catch (SQLException e) {
	      }
	      return result;
	   }


    public List<MobileGateway> findAvailableMobiles() {
	      List<MobileGateway> result = new ArrayList<>();
	      try {

		        PreparedStatement stmt = DBConnection.prepare(findAvaliableMobilesStatement);
	
	        	 ResultSet rs = stmt.executeQuery();
		         while (rs.next()) {
		        	 System.out.println(rs.getInt(1));
			         int id =  rs.getInt(1);
			         String modelArg = rs.getString(2);
			         String brandArg = rs.getString(3);
			         int priceArg = rs.getInt(4);
			         int qtyArg = rs.getInt(5);
			         result.add( new MobileGateway(id, modelArg, brandArg, priceArg,qtyArg));
		         }
		         
//	         while (rs.next()) {
//	            result.add(MobileGateway.load(rs));
//	         }
	      } catch (SQLException e) {
	      
	      }
	      return result;
	   }

}
