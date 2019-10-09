package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CustomerMapper;
import dataMapper.IdentityMap;
import dataMapper.UnitOfWork;
import domain.Customer;
import domain.MobilePhone;

public class CustomerService {
	
	private CustomerMapper customerMapper;
	public CustomerService() {
		customerMapper = new CustomerMapper();
	}
	
	public boolean insertCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(customer);
		return UnitOfWork.getCurrent().commit();
	}
	
	public boolean deleteCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(customer);
		return UnitOfWork.getCurrent().commit();
	}
	
	public boolean updateCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(customer);
		return UnitOfWork.getCurrent().commit();
	}
	
	public List<Customer> findCustomer(Customer customer){
		IdentityMap<Customer> identityMap = IdentityMap.getInstance(customer);
		Customer customerMap = identityMap.get(customer.getUserId());
		if (customerMap != null) {
			List<Customer> result = new ArrayList<Customer>();
			result.add(customerMap);
			return result;
		}
		return customerMapper.findCustomerById(customer);
	}
	
	public List<Customer> findCustomerByEmail(Customer customer){
		//search identity map first
		IdentityMap<Customer> identityMap = IdentityMap.getInstance(customer);
		Customer customerMap = identityMap.get(customer.getUserId());
		//if object is found
		if (customerMap != null) {
			List<Customer> result = new ArrayList<Customer>();
			result.add(customerMap);
			return result;
		}
		//if not in the identity map
		return customerMapper.findCustomerByEmail(customer);
	}
	
	public List<Customer> getAllCustomer() {
		return customerMapper.findAllCustomer();
	}
	

}
