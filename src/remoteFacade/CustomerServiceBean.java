package remoteFacade;

import dataMapper.CustomerMapper;
import domain.Customer;
import domain.CustomerAssembler;
import domain.CustomerDTO;
/**
 * a class for remote invoke
 */
public class CustomerServiceBean {

	public CustomerDTO getCustomer(int id) {
		Customer customer = new Customer();
		customer.setCustomerId(id);
		
		return new CustomerAssembler().writeDTO(
				new CustomerMapper().findCustomerById(customer).get(0));
	}
	
	public String getCustomerString(int id) {
		 return getCustomer(id).toString();
	}
}