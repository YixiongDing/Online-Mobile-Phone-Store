package domain;

public class CustomerAssembler {

	/**
	 * A method assemble data transfer object for Customer
	 * @param Customer customer
	 * @return CustomerDTO result
	 */
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