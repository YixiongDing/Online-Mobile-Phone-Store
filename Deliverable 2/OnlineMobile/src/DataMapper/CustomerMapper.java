package DataMapper;
import domain.Customer;
import domain.DomainObject;

import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper extends DataMapper {
	
	private static final String updateCustomerStatement =
			"UPDATE Customer SET "
					+ "name=?, email=?, address=? WHERE customerId=?";
	
	private static final String insertCustomerStatement = 
			"INSERT INTO Customer "
			+ "(customerId, name, email, address)"
			+ " VALUES (?, ?, ?, ?);";

	
	private static final String deleteCustomereStatement = 	
			"DELETE " +
			" FROM mobilephones " +
			" WHERE id  = ? ";
	private final static String findCustomerByIdStatement =
			"SELECT * from Customer WHERE customerId = ?";
	
	private final static String findCustomerByEmailStatement =
			"SELECT * from Customer WHERE email = ?";
	
	@Override
	public boolean insert(DomainObject obj) {
		Customer customer = (Customer) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertCustomerStatement, dbConnection);
			findStatement.setInt(1, customer.getUserId());
			findStatement.setString(2, customer.getname());
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
			findStatement.setString(2, customer.getname());
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
				c.setname(resultSet.getString(2));
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
				c.setname(resultSet.getString(2));
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


	
}


