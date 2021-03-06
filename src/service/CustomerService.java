package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CustomerMapper;
import dataMapper.IdentityMap;
import dataMapper.UnitOfWork;
import domain.*;

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
			//System.out.println("customer service result "+ result.get(0).getCustomerId());
			return result;
		}
		//System.out.println("customer service 2 "+ customerMapper.findCustomerById(customer).get(0).getCustomerName());
		return customerMapper.findCustomerById(customer);
	}
	
	public List<Customer> findCustomerAfterUpdate(Customer customer){
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
	
	public List<User> getAllUser() {
		return customerMapper.findAllUser();
	}
	

}
