package security;


import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Administrator;

public class UserStore {
	

	static List<Customer> authenticatedCustomer = new ArrayList<Customer>();

	static List<Administrator> authenticatedManager = new ArrayList<Administrator>();

}
