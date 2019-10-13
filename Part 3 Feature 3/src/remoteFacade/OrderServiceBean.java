package remoteFacade;

import dataMapper.OrderMapper;
import domain.Order;
import domain.OrderAssembler;
import domain.OrderDTO;

/**
 * a class for remote invoke
 */
public class OrderServiceBean {

	public OrderDTO getOrder(int id) {
		Order order = new Order();
		order.setOrderId(id);
		return new OrderAssembler().writeDTO(
				new OrderMapper().findOrderByOrderId(order).get(0));
	}
	
	public String getMobilePhoneString(int id) {
		 return getOrder(id).toString();
	}
}