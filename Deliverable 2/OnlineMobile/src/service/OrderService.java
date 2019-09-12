package service;

import java.util.ArrayList;
import java.util.List;

import DataMapper.IdentityMap;
import DataMapper.OrderMapper;
import DataMapper.UnitOfWork;
import domain.Order;

public class OrderService {
	
	private OrderMapper orderMapper;
	public OrderService() {
		orderMapper = new OrderMapper();
	}
	
	public boolean insertOrder(Order order) {
		boolean result = true;

		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(order);
		
		result = UnitOfWork.getCurrent().commit();
		return result;
	}
	
	public boolean deleteOrder(Order order) {
		boolean result = true;
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(order);
		
		result = UnitOfWork.getCurrent().commit();
		return result;
	}
	
	public boolean updateOrder(Order order) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(order);
		
		return UnitOfWork.getCurrent().commit();
	}
	
	public List<Order> findOrder(Order order){
		if (order.getOrderId() != 0) {
			//search identity map first
			IdentityMap<Order> identityMap = IdentityMap.getInstance(order);
			Order orderMap = identityMap.get(order.getOrderId());
			//if object is found
			if (orderMap != null) {
				List<Order> result = new ArrayList<Order>();
				result.add(orderMap);
				return result;
			}
			//if object is not found in identity map, fetch from DB
			return orderMapper.findOrderByOrderId(order);
		}
		else if (order.getCustomer() != null)
			return orderMapper.findOrderByCustomerId(order);
		else
			return null;
	}
}