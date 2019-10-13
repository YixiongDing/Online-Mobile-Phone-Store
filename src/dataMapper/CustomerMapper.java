package dataMapper;
import domain.Administrator;
import domain.Customer;
import domain.DomainObject;
import domain.User;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper extends DataMapper {

	private static final String updateCustomerStatement =
			"UPDATE users SET "
					+ "username=?, email=?, address=?, password=? WHERE userid=? AND usertype = 'CUSTOMER'";

	private static final String insertCustomerStatement = 
			"INSERT INTO users "
					+ "(userid, username, email, address, usertype, password)"
					+ " VALUES (?, ?, ?, ?, ?, ?);";

	private static final String deleteCustomereStatement =  
			"DELETE " +
					" FROM users " +
					" WHERE userid  = ? AND usertype = 'CUSTOMER'";
	private final static String findCustomerByIdStatement =
			"SELECT * from users WHERE userid = ? AND usertype ='CUSTOMER'";

	private final static String findCustomerByEmailStatement =
			"SELECT * from users WHERE email = ? AND usertype ='CUSTOMER'";

	private final static String findCustomerByName =
			"SELECT * from users WHERE username = ? AND usertype = 'CUSTOMER'";
	
	private static final String findAllUserStatement =
			"SELECT * " + 
					" FROM users ";

	@Override
	public boolean insert(DomainObject obj) {
		Customer customer = (Customer) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertCustomerStatement, dbConnection);
			findStatement.setInt(1, customer.getUserId());
			findStatement.setString(2, customer.getCustomerName());
			findStatement.setString(3, customer.getEmail());
			findStatement.setString(4, customer.getAddress());
			findStatement.setString(5, customer.getCustomerUserType());
			findStatement.setString(6, customer.getCustomerPassword());
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

		Customer customer = (Customer)obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(deleteCustomereStatement, dbConnection);
			findStatement.setInt(1, customer.getUserId());

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

		Customer customer = (Customer)obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(updateCustomerStatement, dbConnection);
			findStatement.setString(1, customer.getCustomerName());
			findStatement.setString(2, customer.getEmail());
			findStatement.setString(3, customer.getAddress());
			findStatement.setString(4, customer.getCustomerPassword());
			findStatement.setInt(5, customer.getUserId());
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

	public List<Customer> findCustomerById(Customer customer){
		List<Customer> result = new ArrayList<Customer>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findCustomerByIdStatement, dbConnection);
			findStatement.setInt(1, customer.getCustomerId());
			ResultSet resultSet = findStatement.executeQuery();

			while(resultSet.next()) {
				Customer c = new Customer();
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(c);
				c.setCustomerId(resultSet.getInt(1));
				c.setCustomerName(resultSet.getString(2));
				c.setEmail(resultSet.getString(3));
				c.setAddress(resultSet.getString(4));
				c.setCustomerUserType(resultSet.getString(5));
				c.setCustomerPassword(resultSet.getString(6));
				identityMap.put(c.getCustomerId(), c);
				result.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Customer> findCustomerByEmail(Customer customer){
		List<Customer> result = new ArrayList<Customer>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findCustomerByEmailStatement, dbConnection);
			findStatement.setString(1, customer.getEmail());
			ResultSet resultSet = findStatement.executeQuery();

			while(resultSet.next()) {
				Customer c = new Customer();
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(c);
				c.setCustomerId(resultSet.getInt(1));
				c.setCustomerName(resultSet.getString(2));
				c.setEmail(resultSet.getString(3));
				c.setAddress(resultSet.getString(4));
				c.setCustomerUserType(resultSet.getString(5));
				c.setCustomerPassword(resultSet.getString(6));
				identityMap.put(c.getUserId(), c);
				result.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<User> findAllUser(){
		List<User> result = new ArrayList<User>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAllUserStatement, dbConnection);
			ResultSet rs = findStatement.executeQuery();

			while(rs.next()) {
				User u = new User();
				IdentityMap<User> identityMap = IdentityMap.getInstance(u);
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setUserType(rs.getString(5));
				u.setPassword(rs.getString(6));
				identityMap.put(u.getUserId(),u);
				result.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Customer getCustomerByName(String username) {
		Customer customer = null;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findCustomerByName, dbConnection);
			findStatement.setString(1, username);
			ResultSet result = findStatement.executeQuery();
			while(result.next()) {
				customer= new Customer();
				customer.setUserId(result.getInt(1));
				customer.setName(result.getString(2));
				customer.setEmail(result.getString(3));
				customer.setAddress(result.getString(4));
				customer.setUserType(result.getString(5));  // need to update database for the consistency
				customer.setPassword(result.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public static Customer getCustomerById(int id) {

		Customer customer = null;

		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findCustomerByIdStatement, dbConnection);
			findStatement.setInt(1, id);
			ResultSet result = findStatement.executeQuery();
			while(result.next()) {
				customer= new Customer();
				customer.setUserId(result.getInt(1));
				customer.setName(result.getString(2));
				customer.setEmail(result.getString(3));
				customer.setAddress(result.getString(4));
				customer.setUserType(result.getString(5));  // need to update database for the consistence
				customer.setPassword(result.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}