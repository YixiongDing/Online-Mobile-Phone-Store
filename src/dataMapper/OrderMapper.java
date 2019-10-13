package dataMapper;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.DomainObject;
import domain.MobilePhone;
import domain.Order;
import service.CustomerService;
import service.MobilePhoneService;

public class OrderMapper extends DataMapper {
	
	private static final String insertOrderStatement = 
			"INSERT INTO Orders "
					+ "(orderId, createTime, status, mobilePhoneId, userid)"
					+ " VALUES (?, ?, ?, ?, ?);";
	
	private static final String updateOrderStatement =
			"UPDATE Orders SET "
					+ "createTime=?, status=?, mobilePhoneId=?, userid=? "
					+ "WHERE orderId=?";
	
	private static final String deleteOrderStatement = 
			"DELETE FROM Orders WHERE orderId = ?";
	
	private final static String findOrderByOrderIdStatement =
			"SELECT * from Orders WHERE orderId = ?";
	
	private final static String findOrderByCustomerIdStatement =
			 "SELECT * from Orders WHERE userid = ?";
	
	private static final String findAllOrderStatement =
			"SELECT * " + 
					" FROM Orders ";
	
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
	
	
	public List<Order> findOrderByCustomerId(Customer c){

		List<Order> result = new ArrayList<Order>();
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findOrderByCustomerIdStatement, dbConnection);
			findStatement.setInt(1, c.getUserId());
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
	
	public List<Order> findAllOrder(){
		List<Order> result = new ArrayList<Order>();
		List<MobilePhone> mobileResult = new ArrayList<MobilePhone>();
		List<Customer> customerResult = new ArrayList<Customer>();
		MobilePhoneService ms= new MobilePhoneService();
		CustomerService cs = new CustomerService();
		
		try {
			Connection dbConnection = DBConnection.getDBConnection();
			PreparedStatement findStatement = DBConnection.prepare(findAllOrderStatement, dbConnection);
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				Order odr = new Order();
				IdentityMap<Order> identityMap = IdentityMap.getInstance(odr);
				odr.setOrderId(rs.getInt(1));
				odr.setCreateTime(rs.getTimestamp(2));
				odr.setStatus(rs.getString(3));
				MobilePhone mobilePhone = new MobilePhone();
				mobilePhone.setMobilePhoneId(rs.getInt(4));
				mobileResult = ms.getMobilePhone(mobilePhone);				
				odr.setMobilePhone(mobileResult.get(0));
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt(5));
				customerResult = cs.findCustomer(customer);
				odr.setCustomer(customerResult.get(0));	
				identityMap.put(odr.getOrderId(), odr);
				result.add(odr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
