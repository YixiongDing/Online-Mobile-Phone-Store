package security;

import domain.Administrator;
import domain.Customer;
import domain.User;
import org.apache.shiro.SecurityUtils;


public class AppSession {

	public static final String  USER_ATTRIBUTE_NAME = "user";
	public static final String  CUSTOMER_ROLE = "customer";
	public static final String  ADMIN_ROLE = "admin";

	public static boolean hasRole(String role) {

		return SecurityUtils.getSubject().hasRole(role);

	}

	public static boolean isAuthenticated() {

		return SecurityUtils.getSubject().isAuthenticated();

	}

	public static void init(User user) {

		SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);


	}
	public static void init(Customer user) {

		SecurityUtils.getSubject().getSession().setAttribute(CUSTOMER_ROLE, user);


	}
	public static void init(Administrator user) {

		SecurityUtils.getSubject().getSession().setAttribute(ADMIN_ROLE, user);


	}

	public static User getUser() {

		return (User) SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);

	}

	public static User getCustomer() {

		return (User) SecurityUtils.getSubject().getSession().getAttribute(CUSTOMER_ROLE);
	}
	

	public static User getAdmin() {

		return (User) SecurityUtils.getSubject().getSession().getAttribute(ADMIN_ROLE);
	}
	
}
