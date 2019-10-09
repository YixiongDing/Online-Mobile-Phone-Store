package dataMapper;
import domain.Administrator;
import domain.DomainObject;
import domain.User;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorMapper extends DataMapper {
	
	private static final String updateAdministratorStatement =
			"UPDATE users SET "
					+ "name=?, email=?, address=? WHERE userid=? AND userType=ADMIN";
	
	private static final String insertAdministratorStatement = 
			"INSERT INTO users "
			+ "(userid, name, email, address,userType)"
			+ " VALUES (?, ?, ?, ?, ADMIN);";

	
	private static final String deleteAdministratorStatement = 	
			"DELETE " +
			" FROM mobilephone " +
			" WHERE id  = ? AND AND userType=ADMIN";
	private final static String findAdministratorByIdStatement =
			"SELECT * from users WHERE userid = ? AND userType=ADMIN";
	
	private final static String findAdministratorByEmailStatement =
			"SELECT * from users WHERE email = ? AND userType=ADMIN";
	
	private final static String findAdminByName =
			"SELECT * from users WHERE userid = ? userType=ADMIN";

	
	@Override
	public boolean insert(DomainObject obj) {
		Administrator admin = (Administrator) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertAdministratorStatement, dbConnection);
			findStatement.setInt(1, admin.getAdministratorId());
			findStatement.setString(2, admin.getAdministratorName());
			findStatement.setString(3, admin.getAdministratorEmail());
			findStatement.setString(4, admin.getAdministratorAddress());
			
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
		
		Administrator admin = (Administrator)obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(deleteAdministratorStatement, dbConnection);
			findStatement.setInt(1, admin.getAdministratorId());
			
			result = findStatement.executeUpdate();
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;

		
	}
	
	
	@Override
	public boolean update (DomainObject obj) {
		
		Administrator admin = (Administrator)obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(updateAdministratorStatement, dbConnection);
			findStatement.setInt(1, admin.getAdministratorId());
			findStatement.setString(2, admin.getAdministratorName());
			findStatement.setString(3, admin.getAdministratorEmail());
			findStatement.setString(4, admin.getAdministratorAddress());
			
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
	
	public List<Administrator> findAdminById(Administrator admin){
		List<Administrator> result = new ArrayList<Administrator>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAdministratorByIdStatement, dbConnection);
			findStatement.setInt(1, admin.getUserId());
			ResultSet resultSet = findStatement.executeQuery();
			
			while(resultSet.next()) {
				Administrator a = new Administrator();
				IdentityMap<Administrator> identityMap = IdentityMap.getInstance(a);
				a.setAdministratorId(resultSet.getInt(1));
				a.setAdministratorName(resultSet.getString(2));
				a.setAdministratorEmail(resultSet.getString(3));
				a.setAdministratorAddress(resultSet.getString(4));
				
				identityMap.put(a.getAdministratorId(), a);
				result.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Administrator> findAdminByEmail(Administrator customer){
		List<Administrator> result = new ArrayList<Administrator>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAdministratorByEmailStatement, dbConnection);
			findStatement.setString(1, customer.getEmail());
			ResultSet resultSet = findStatement.executeQuery();
			
			while(resultSet.next()) {
				Administrator a = new Administrator();
				IdentityMap<Administrator> identityMap = IdentityMap.getInstance(a);
				a.setAdministratorId(resultSet.getInt(1));
				a.setAdministratorName(resultSet.getString(2));
				a.setAdministratorEmail(resultSet.getString(3));
				a.setAdministratorAddress(resultSet.getString(4));
				
				identityMap.put(a.getAdministratorId(), a);
				result.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
public static Administrator getAdminByName(String username) {
		
		Administrator admin = null;
		
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAdminByName, dbConnection);
			findStatement.setString(1, username);
			ResultSet result = findStatement.executeQuery();
			
	
			 admin= new Administrator();
			admin.setUserId(result.getInt(1));
			admin.setName(result.getString(2));
			admin.setEmail(result.getString(3));
			admin.setAddress(result.getString(4));
			admin.setUserType(result.getString(5));  // need to update database for the consistence
			admin.setPassword(result.getString(6));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return admin;
	}


	
}


