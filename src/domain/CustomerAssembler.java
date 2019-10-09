package domain;

public class CustomerAssembler {
	
	
	
	public CustomerDTO writeDTO(Customer customer) {
		CustomerDTO result = new CustomerDTO();
		result.setCustomerId(customer.getCustomerId());
		result.setCustomerEmail(customer.getCustomerEmail());
		result.setCustomerName(customer.getCustomerName());
		result.setCustomerAddress(customer.getCustomerAddress());
		
		return result;
	}

}
