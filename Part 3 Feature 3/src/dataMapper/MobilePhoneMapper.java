package dataMapper;
import domain.*;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MobilePhoneMapper extends DataMapper{

	private final static String findMobilePhoneStatement =
			"SELECT * " +
					"  FROM mobilephone " +
					"  WHERE mobilephoneid = ? ";

	private static final String findAvaliableMobilePhoneStatement =
			"SELECT * " +
					" FROM mobilephone " +
					" WHERE qty > 0 ";

	private static final String findAllMobilePhoneStatement =
			"SELECT * " + 
					" FROM mobilephone ";

	private static final String updateMobilePhoneStatement =
			"UPDATE mobilephone "+
					" SET modelname = ?, storagesize=?, color=?, brand = ?, price = ?, qty = ?, description = ? " +
					" WHERE mobilephoneid  = ? ";

	private static final String insertMobilePhoneStatement = 
			"INSERT INTO mobilephone " +
					" (mobilephoneid, modelname, storagesize,color, brand, price, qty, description) "+
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";

	private static final String deleteMobilePhoneStatement = 
			"DELETE " +
					" FROM mobilephone " +
					" WHERE mobilephoneid  = ? ";
	
	/**
	 * A method to insert mobile phone object into database
	 * @param DomainObject obj
	 * @return boolean
	 * @throws Exception e
	 */
	@Override
	public boolean insert(DomainObject obj) {
		MobilePhone mobile = (MobilePhone) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertMobilePhoneStatement, dbConnection);
			findStatement.setInt(1, mobile.getMobilePhoneId());
			findStatement.setString(2, mobile.getModelName());
			findStatement.setString(3, mobile.getStorageSize());
			findStatement.setString(4, mobile.getColor());
			findStatement.setString(5, mobile.getBrand());
			findStatement.setFloat(6, mobile.getPrice());
			findStatement.setInt(7, mobile.getQty());
			findStatement.setString(8, mobile.getDescription());
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
	
	/**
	 * A method to update mobile phone object into database
	 * @param DomainObject obj
	 * @return boolean
	 * @throws Exception e
	 */
	@Override
	public boolean update(DomainObject obj) {
		MobilePhone mobile = (MobilePhone) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(updateMobilePhoneStatement, dbConnection);				
			findStatement.setString(1, mobile.getModelName());
			findStatement.setString(2, mobile.getStorageSize());
			findStatement.setString(3, mobile.getColor());
			findStatement.setString(4, mobile.getBrand());
			findStatement.setFloat(5, mobile.getPrice());
			findStatement.setInt(6, mobile.getQty());
			findStatement.setString(7, mobile.getDescription());
			findStatement.setInt(8, mobile.getMobilePhoneId());
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
	
	/**
	 * A method to delete mobile phone object from database
	 * @param DomainObject obj
	 * @return boolean
	 * @throws Exception e
	 */
	@Override
	public boolean delete(DomainObject obj) {
		MobilePhone mobile = (MobilePhone) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(deleteMobilePhoneStatement, dbConnection);
			findStatement.setInt(1, mobile.getMobilePhoneId());
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

	/**
	 * A method to find mobile phone in database by mobile phone id 
	 * @param MobilePhone mobile
	 * @return List<MobilePhone> result
	 * @throws SQLException e
	 */
	public List<MobilePhone> findMobilePhone(MobilePhone mobile) {
		List<MobilePhone> result = new ArrayList<MobilePhone>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findMobilePhoneStatement, dbConnection);
			findStatement.setInt(1, mobile.getMobilePhoneId());
			ResultSet rs = findStatement.executeQuery();
			while(rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				m.setMobilePhoneId(rs.getInt(1));
				m.setModelName(rs.getString(2));
				m.setStorageSize(rs.getString(3));
				m.setColor(rs.getString(4));
				m.setBrand(rs.getString(5));
				m.setPrice(rs.getFloat(6));
				m.setQty(rs.getInt(7));
				m.setDescription(rs.getString(8));
				identityMap.put(m.getMobilePhoneId(),m);
				result.add(m);
			}
			dbConnection.close();
		} catch (SQLException e) {
		}
		return result;
	}
	
	/**
	 * A method to find all mobile phones in database
	 * @return List<MobilePhone> result
	 * @throws Exception e
	 */
	public List<MobilePhone> findAllMobilePhone(){
		List<MobilePhone> result = new ArrayList<MobilePhone>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAllMobilePhoneStatement, dbConnection);
			ResultSet rs = findStatement.executeQuery();
			while(rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				m.setMobilePhoneId(rs.getInt(1));
				m.setModelName(rs.getString(2));
				m.setStorageSize(rs.getString(3));
				m.setColor(rs.getString(4));
				m.setBrand(rs.getString(5));
				m.setPrice(rs.getFloat(6));
				m.setQty(rs.getInt(7));
				m.setDescription(rs.getString(8));
				identityMap.put(m.getMobilePhoneId(),m);
				result.add(m);;
			}
			dbConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * A method to find all available (qty>0) mobile phones in database
	 * @return List<MobilePhone> result
	 * @throws SQLException e
	 */
	public List<MobilePhone> findAvailableMobilePhone() {
		List<MobilePhone> result = new ArrayList<>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAvaliableMobilePhoneStatement, dbConnection);
			ResultSet rs = findStatement.executeQuery();
			while (rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				m.setMobilePhoneId(rs.getInt(1));
				m.setModelName(rs.getString(2));
				m.setStorageSize(rs.getString(3));
				m.setColor(rs.getString(4));
				m.setBrand(rs.getString(5));
				m.setPrice(rs.getFloat(6));
				m.setQty(rs.getInt(7));
				m.setDescription(rs.getString(8));
				identityMap.put(m.getMobilePhoneId(),m);
				result.add(m);;
			}
			dbConnection.close();
		} catch (SQLException e) {

		}
		return result;
	}
}
