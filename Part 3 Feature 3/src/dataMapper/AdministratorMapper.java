package dataMapper;
import domain.*;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorMapper extends DataMapper {

	private static final String updateAdministratorStatement =
			"UPDATE users SET "
					+ "name=?, email=?, address=?, password=? WHERE userid=? AND userType=ADMIN";

	private static final String insertAdministratorStatement = 
			"INSERT INTO users "
					+ "(userid, name, email, address,userType,password)"
					+ " VALUES (?, ?, ?, ?, ADMIN,?)";

	private static final String deleteAdministratorStatement =  
			"DELETE " +
					" FROM users " +
					" WHERE id  = ? AND userType=ADMIN";
	private final static String findAdministratorByIdStatement =
			"SELECT * from users WHERE userid = ? AND userType = 'ADMIN'";

	private final static String findAdministratorByEmailStatement =
			"SELECT * from users WHERE email = ? AND userType = 'ADMIN'";

	private final static String findAdministratorByName =
			"SELECT * from users WHERE username = ? AND userType = 'ADMIN'";


	/**
	 * A method to insert administrator object into database
	 * @param DomainObject obj
	 * @return boolean
	 * @throws Exception e
	 */
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
			findStatement.setString(5, admin.getAdministratorUserType());
			findStatement.setString(6, admin.getAdministratorPassword());
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
	 * A method to delete administrator object into database
	 * @param DomainObject obj
	 * @return boolean
	 * @throws Exception e
	 */
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
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}

	/**
	 * A method to update administrator object into database
	 * @param DomainObject obj
	 * @return boolean
	 * @throws Exception e
	 */
	@Override
	public boolean update(DomainObject obj) {
		Administrator admin = (Administrator)obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(updateAdministratorStatement, dbConnection);
			findStatement.setInt(1, admin.getAdministratorId());
			findStatement.setString(2, admin.getAdministratorName());
			findStatement.setString(3, admin.getAdministratorEmail());
			findStatement.setString(4, admin.getAdministratorAddress());
			findStatement.setString(5, admin.getAdministratorPassword());
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
	 * A method to find administrator in database by admin id 
	 * @param Administrator admin
	 * @return List<Administrator> result
	 * @throws Exception e
	 */
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
				a.setAdministratorUserType(resultSet.getString(5));
				a.setAdministratorPassword(resultSet.getString(6));

				// put in to the identity map
				identityMap.put(a.getAdministratorId(), a);
				result.add(a);
			}
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * A method to find administrator in database by admin email 
	 * @param Administrator admin
	 * @return List<Administrator> result
	 * @throws Exception e
	 */
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
				a.setAdministratorUserType(resultSet.getString(5));
				a.setAdministratorPassword(resultSet.getString(6));
				identityMap.put(a.getAdministratorId(), a);
				result.add(a);
			}
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * A static method to find administrator in database by admin name 
	 * @param String username
	 * @return Administrator admin
	 * @throws Exception e
	 */
	public static Administrator getAdminByName(String username) {
		Administrator admin = null;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAdministratorByName, dbConnection);
			findStatement.setString(1, username);
			ResultSet result = findStatement.executeQuery();
			while(result.next()) {
				admin= new Administrator();
				admin.setUserId(result.getInt(1));
				admin.setName(result.getString(2));
				admin.setEmail(result.getString(3));
				admin.setAddress(result.getString(4));
				admin.setUserType(result.getString(5));
				admin.setPassword(result.getString(6));
			}
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	/**
	 * A static method to find administrator in database by admin id 
	 * @param int id
	 * @return Administrator admin
	 * @throws Exception e
	 */
	public static Administrator getAdminById(int id) {
		Administrator admin = null;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAdministratorByIdStatement, dbConnection);
			findStatement.setInt(1, id);
			ResultSet result = findStatement.executeQuery();
			while(result.next()) {
				admin= new Administrator();
				admin.setUserId(result.getInt(1));
				admin.setName(result.getString(2));
				admin.setEmail(result.getString(3));
				admin.setAddress(result.getString(4));
				admin.setUserType(result.getString(5)); 
				admin.setPassword(result.getString(6));
			}
			DBConnection.closePreparedStatement(findStatement);
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}