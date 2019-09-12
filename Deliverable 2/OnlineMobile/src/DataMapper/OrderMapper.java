package DataMapper;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.DomainObject;
import domain.MobilePhone;
import domain.Order;

public class OrderMapper extends DataMapper {
	
	private static final String insertOrderStatement = 
			"INSERT INTO Order "
					+ "(orderId, createTime, status, mobilePhoneId, customerId)"
					+ " VALUES (?, ?, ?, ?, ?);";
	
	private static final String updateOrderStatement =
			"UPDATE Order SET "
					+ "createTime=?, status=?, mobilePhoneId=?, customerId=? "
					+ "WHERE orderId=?";
	
	private static final String deleteOrderStatement = 
			"DELETE FROM Order WHERE orderId = ?";
	
	private final static String findOrderByOrderIdStatement =
			"SELECT * from Order WHERE orderId = ?";
	
	private final static String findOrderByCustomerIdStatement =
			 "SELECT * from Order WHERE customerId = ?";
	
	@Override
	public boolean insert(DomainObject obj) {
		Order order = (Order) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(insertOrderStatement, dbConnection);
			findStatement.setLong(1, order.getOrderId());
			findStatement.setTimestamp(2, new Timestamp(order.getCreateTime().getTime()));
			findStatement.setString(3, order.getStatus());
			findStatement.setInt(4, order.getMobilePhone().getMobilePhoneId());
			findStatement.setInt(5, order.getCustomer().getUserId());

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
	public boolean update (DomainObject obj) {
		Order order = (Order)obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(updateOrderStatement, dbConnection);
			findStatement.setTimestamp(1, new Timestamp(order.getCreateTime().getTime()));
			findStatement.setString(2, order.getStatus());
			findStatement.setInt(3, order.getMobilePhone().getMobilePhoneId());
			findStatement.setInt(4, order.getCustomer().getUserId());

			
			findStatement.setInt(5, order.getOrderId());
			
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
		Order order = (Order) obj;
		int result = 0;
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(deleteOrderStatement, dbConnection);
			findStatement.setInt(1, order.getOrderId());
			
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
	
	public List<Order> findOrderByOrderId(Order order){
		List<Order> result = new ArrayList<Order>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findOrderByOrderIdStatement, dbConnection);
			findStatement.setLong(1, order.getOrderId());
			ResultSet resultSet = findStatement.executeQuery();
			
			while(resultSet.next()) {
				Order odr = new Order();
				//get Identity Map for Order
				IdentityMap<Order> identityMap = IdentityMap.getInstance(odr);
				
				odr.setOrderId(resultSet.getInt(1));
				
				odr.setCreateTime(resultSet.getTimestamp(2));
				odr.setStatus(resultSet.getString(3));
				
				//set MobilePhone
				MobilePhone mobilePhone = new MobilePhone();
				mobilePhone.setMobilePhoneId(resultSet.getInt(4));
				MobilePhoneMapper mobilePhoneMapper = new MobilePhoneMapper();
				odr.setMobilePhone(mobilePhoneMapper.findMobilePhone(mobilePhone).get(0));
				//set Customer
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getInt(5));
				CustomerMapper cm = new CustomerMapper();
				odr.setCustomer(cm.findCustomerById(customer).get(0));
				

				//put order into identity map
				identityMap.put(odr.getOrderId(), odr);
				
				result.add(odr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List<Order> findOrderByCustomerId(Order order){

		List<Order> result = new ArrayList<Order>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findOrderByCustomerIdStatement, dbConnection);
			findStatement.setInt(1, order.getCustomer().getUserId());
			ResultSet resultSet = findStatement.executeQuery();
			
			while(resultSet.next()) {
				Order odr = new Order();
				//get Identity Map for Order
				IdentityMap<Order> identityMap = IdentityMap.getInstance(odr);
				
				odr.setOrderId(resultSet.getInt(1));
				
				odr.setCreateTime(resultSet.getTimestamp(2));
				odr.setStatus(resultSet.getString(3));
				//set Mobilephone
				MobilePhone mobilePhone = new MobilePhone();
				mobilePhone.setMobilePhoneId(resultSet.getInt(4));
				MobilePhoneMapper mobilePhoneMapper = new MobilePhoneMapper();
				odr.setMobilePhone(mobilePhoneMapper.findMobilePhone(mobilePhone).get(0));
				//set Customer
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getInt(5));
				CustomerMapper cm = new CustomerMapper();
				odr.setCustomer(cm.findCustomerById(customer).get(0));
				
				
				
				//put order into identity map
				identityMap.put(odr.getOrderId(), odr);
				
				result.add(odr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
