package dataMapper;
import domain.MobilePhone;
import domain.DomainObject;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;

import java.sql.*;

public class MobilePhoneMapper extends DataMapper{

	private final static String findMobilePhoneStatement =
			"SELECT * " +
					"  FROM mobilephones " +
					"  WHERE id = ? ";

	private static final String findAvaliableMobilePhoneStatement =
			"SELECT * " +
					" FROM mobilephones " +
					" WHERE qty > 0 ";

	private static final String findAllMobilePhoneStatement =
			"SELECT * " + 
					" FROM mobilephones ";
	
	private static final String updateMobilePhoneStatement =
			"UPDATE mobilephones "+
					" SET model = ?, brand = ?, price = ?, qty = ?, description = ? " +
					" WHERE id  = ? ";
	
	private static final String insertMobilePhoneStatement = 
			"INSERT INTO mobilephones " +
					" (id, model, brand, price, qty, description) "+
					" VALUES (?, ?, ?, ?, ?, ?); ";
	
	private static final String deleteMobilePhoneStatement = 
				"DELETE " +
					" FROM mobilephones " +
					" WHERE id  = ? ";
	

	public List<MobilePhone> findMobilePhone(MobilePhone mobile) {

		List<MobilePhone> result = new ArrayList<MobilePhone>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findMobilePhoneStatement, dbConnection);
			findStatement.setInt(1, mobile.getMobileId());
			ResultSet rs = findStatement.executeQuery();

			while(rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				int mobilePhoneId = rs.getInt(1);
				m.setId(mobilePhoneId);
				m.setModel(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getFloat(4));
				m.setQty(rs.getInt(5));
				m.setDescription(rs.getString(6));
				identityMap.put(m.getMobileId(),m);
				result.add(m);
			}

		} catch (SQLException e) {
		}
		return result;
	}

	public List<MobilePhone> findAllMobilePhone(){
		List<MobilePhone> result = new ArrayList<MobilePhone>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAllMobilePhoneStatement, dbConnection);
			ResultSet rs = findStatement.executeQuery();

			while(rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				int mobilePhoneId = rs.getInt(1);
				m.setId(mobilePhoneId);
				m.setModel(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getFloat(4));           
				m.setQty(rs.getInt(5));
				m.setDescription(rs.getString(6));
				identityMap.put(m.getMobileId(),m);
				result.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MobilePhone> findAvailableMobilePhone() {
		List<MobilePhone> result = new ArrayList<>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement stmt = DBConnection.prepare(findAvaliableMobilePhoneStatement, dbConnection);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int idArg = rs.getInt(1);
				String modelArg = rs.getString(2);
				String brandArg = rs.getString(3);
				int priceArg = rs.getInt(4);
				int qtyArg = rs.getInt(5);
				String descriptionArg = rs.getString(6);
				result.add( new MobilePhone(idArg, modelArg, brandArg, priceArg, qtyArg, descriptionArg));
			}

		} catch (SQLException e) {

		}
		return result;
	}

	@Override
	public boolean update(DomainObject obj) {
		MobilePhone mobile = (MobilePhone) obj;

		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(updateMobilePhoneStatement, dbConnection);
						
			findStatement.setString(1, mobile.getModel());
			findStatement.setString(2, mobile.getBrand());
			findStatement.setFloat(3, mobile.getPrice());
			findStatement.setInt(4, mobile.getQty());
			findStatement.setString(5, mobile.getDescription());
			findStatement.setInt(6, mobile.getMobileId());

			result = findStatement.executeUpdate();
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}
	
	@Override
	public boolean insert(DomainObject obj) {
		MobilePhone mobile = (MobilePhone) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertMobilePhoneStatement, dbConnection);
			
			findStatement.setInt(1, mobile.getMobileId());
			findStatement.setString(2, mobile.getModel());
			findStatement.setString(3, mobile.getBrand());
			findStatement.setFloat(4, mobile.getPrice());
			findStatement.setInt(5, mobile.getQty());
			findStatement.setString(6, mobile.getDescription());
			
			result = findStatement.executeUpdate();
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}

	@Override
	public boolean delete(DomainObject obj) {
		MobilePhone mobile = (MobilePhone) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(deleteMobilePhoneStatement, dbConnection);
	
			findStatement.setInt(1, mobile.getMobileId());
			result = findStatement.executeUpdate();
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}

}
