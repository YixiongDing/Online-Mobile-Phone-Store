package DataMapper;
import domain.MobilePhone;
import domain.Model;
import domain.DomainObject;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;

import java.sql.*;

public class MobilePhoneMapper extends DataMapper{

	private final static String findMobilePhoneStatement =
			"SELECT * " +
					"  FROM mobilephone " +
					"  WHERE id = ? ";

	private static final String findAvaliableMobilePhoneStatement =
			"SELECT * " +
					" FROM mobilephone " +
					" WHERE qty > 0 ";

	private static final String findAllMobilePhoneStatement =
			"SELECT * " + 
					" FROM mobilephone ";
	
	private static final String updateMobilePhoneStatement =
			"UPDATE mobilephone "+
					" SET modelname = ?, storagesize=?, color=?, brand = ?, price = ?, qty = ? " +
					" WHERE mobilephoneid  = ? ";
	
	private static final String insertMobilePhoneStatement = 
			"INSERT INTO mobilephone " +
					" (mobilephoneid, modelname, storagesize,color, brand, price, qty) "+
					" VALUES (?, ?, ?, ?, ?,?,?); ";
	
	private static final String deleteMobilePhoneStatement = 
				"DELETE " +
					" FROM mobilephone " +
					" WHERE mobilephoneid  = ? ";
	

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
				int mobilePhoneId = rs.getInt(1);
				m.setMobilePhoneId(mobilePhoneId);
				m.setModelName(rs.getString(2));
				m.setStorageSize(rs.getString(3));
				m.setColor(rs.getString(4));
				m.setBrand(rs.getString(5));
				m.setPrice(rs.getFloat(6));
				m.setQty(rs.getInt(7));
				identityMap.put(m.getMobilePhoneId(),m);
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
				m.setMobilePhoneId(mobilePhoneId);
				m.setModelName(rs.getString(2));
				m.setStorageSize(rs.getString(3));
				m.setColor(rs.getString(4));
				m.setBrand(rs.getString(5));
				m.setPrice(rs.getFloat(6));
				m.setQty(rs.getInt(7));
				identityMap.put(m.getMobilePhoneId(),m);
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
				System.out.println(rs.getInt(1));
				int id =  rs.getInt(1);
				
				Model model = new Model();
				model.setModelName(rs.getString(2));
				model.setStorageSize(rs.getString(3));
				model.setColor(rs.getString(4));
				
				String brandArg = rs.getString(3);
				int priceArg = rs.getInt(4);
				int qtyArg = rs.getInt(5);
				result.add( new MobilePhone(id, brandArg, model,priceArg,qtyArg));
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
						
			findStatement.setString(1, mobile.getModelName());
			findStatement.setString(2, mobile.getStorageSize());
			findStatement.setString(3, mobile.getColor());
			
			
			findStatement.setString(4, mobile.getBrand());
			findStatement.setFloat(5, mobile.getPrice());
			findStatement.setInt(6, mobile.getQty());
			findStatement.setInt(7, mobile.getMobilePhoneId());

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
			
			findStatement.setString(1, mobile.getModelName());
			findStatement.setString(2, mobile.getStorageSize());
			findStatement.setString(3, mobile.getColor());
			
			
			findStatement.setString(4, mobile.getBrand());
			findStatement.setFloat(5, mobile.getPrice());
			findStatement.setInt(6, mobile.getQty());
			findStatement.setInt(7, mobile.getMobilePhoneId());

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

}