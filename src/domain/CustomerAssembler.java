package domain;

public class CustomerAssembler {



	public CustomerDTO writeDTO(Customer customer) {
		CustomerDTO result = new CustomerDTO();
		result.setCustomerId(customer.getCustomerId());
		result.setCustomerEmail(customer.getCustomerEmail());
		result.setCustomerName(customer.getCustomerName());
		result.setCustomerAddress(customer.getCustomerAddress());
		result.setCustomerUserType(customer.getCustomerUserType());
		result.setCustomerPassword(customer.getCustomerPassword());
		return result;
	}

}