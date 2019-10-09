package dataMapper;
import domain.Customer;
import domain.DomainObject;
import domain.MobilePhone;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper extends DataMapper {

	private static final String updateCustomerStatement =
			"UPDATE users SET "
					+ "name=?, email=?, address=?, password=? WHERE userid=?";

	private static final String insertCustomerStatement = 
			"INSERT INTO users "
					+ " (userid, name, email, address, password)"
					+ " VALUES (?, ?, ?, ?, ?);";


	private static final String deleteCustomereStatement = 	
			"DELETE " +
					" FROM users " +
					" WHERE id  = ? ";
	private final static String findCustomerByIdStatement =
			"SELECT * from users WHERE userid = ?";

	private final static String findCustomerByEmailStatement =
			"SELECT * from users WHERE email = ?";

	private static final String findAllCustomerStatement =
			"SELECT * " + 
					" FROM users ";
	
	@Override
	public boolean insert(DomainObject obj) {
		Customer customer = (Customer) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertCustomerStatement, dbConnection);
			findStatement.setInt(1, customer.getCustomerId());
			findStatement.setString(2, customer.getCustomerName());
			findStatement.setString(3, customer.getCustomerEmail());
			findStatement.setString(4, customer.getCustomerPostAddress());
			findStatement.setString(5, customer.getCustomerPassword());
			
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
			findStatement.setInt(1, customer.getUserId());
			findStatement.setString(2, customer.getCustomerName());
			findStatement.setString(3, customer.getEmail());
			findStatement.setString(4, customer.getAddress());

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
			findStatement.setInt(1, customer.getUserId());
			ResultSet resultSet = findStatement.executeQuery();

			while(resultSet.next()) {
				Customer c = new Customer();
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(c);
				c.setCustomerId(resultSet.getInt(1));
				c.setCustomerName(resultSet.getString(2));
				c.setEmail(resultSet.getString(3));
				c.setAddress(resultSet.getString(4));

				identityMap.put(c.getUserId(), c);
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

				identityMap.put(c.getUserId(), c);
				result.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Customer> findAllCustomer(){
		List<Customer> result = new ArrayList<Customer>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAllCustomerStatement, dbConnection);
			ResultSet rs = findStatement.executeQuery();

			while(rs.next()) {
				Customer c = new Customer();
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(c);
				c.setCustomerId(rs.getInt(1));
				c.setCustomerName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setCustomerPostAddress(rs.getString(4));
				c.setCustomerPassword(rs.getString(5));
				identityMap.put(c.getCustomerId(),c);
				result.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}


