package domain;

public class OrderAssembler {
	
  /**
	* A method assemble data transfer object for Order
	* @param Order order
	* @return OrderDTO result
	*/
	public OrderDTO writeDTO(Order order) {
		OrderDTO result = new OrderDTO();
		result.setCreateTime(order.getCreateTime());
		result.setOrderId(order.getOrderId());
		result.setStatus(order.getStatus());
		
		//customer
		writeCustomerDTO(result, order);
		
		//mobile phone
		writeMobilePhoneDTO(result, order);
		return result;
	}	
	
	/**
	 * A method assemble data transfer object for Order using Customer
	 * @param OrderDTO drderDTO, Order order
	 */
	private void writeCustomerDTO(OrderDTO orderDTO, Order order) {
		CustomerDTO customerDTO = new CustomerDTO();
		Customer customer = order.getCustomer();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setCustomerEmail(customer.getCustomerEmail());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setCustomerAddress(customer.getCustomerAddress());
		orderDTO.setCustomer(customerDTO);
	}
	
	/**
	 * A method assemble data transfer object for Order using Mobile Phone
	 * @param OrderDTO drderDTO, Order order
	 */
	public void writeMobilePhoneDTO(OrderDTO orderDTO, Order order) {
		MobilePhoneDTO mobilePhoneDTO = new MobilePhoneDTO();
		MobilePhone mobilePhone = order.getMobilePhone();
		mobilePhoneDTO.setMobilePhoneId(mobilePhone.getMobilePhoneId());
		mobilePhoneDTO.setBrand(mobilePhone.getBrand());
		mobilePhoneDTO.setModelName(mobilePhone.getModelName());
		mobilePhoneDTO.setStorageSize(mobilePhone.getStorageSize());
		mobilePhoneDTO.setColor(mobilePhone.getColor());
		mobilePhoneDTO.setPrice(mobilePhone.getPrice());
		mobilePhoneDTO.setQty(mobilePhone.getQty());
		mobilePhoneDTO.setDescription(mobilePhone.getDescription());
		orderDTO.setMobilePhone(mobilePhoneDTO);
	}
}
