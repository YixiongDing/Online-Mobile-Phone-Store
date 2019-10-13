package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;
import security.AppSession;
import service.*;

/**
 * Servlet implementation class UpdateCustomerProfileControllerServlet
 */
@WebServlet("/UpdateCustomerProfileControllerServlet")
public class UpdateCustomerProfileControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerProfileControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerResult = new ArrayList<Customer>();
		Customer c = new Customer();
		CustomerService cs = new CustomerService();
		c.setCustomerId(AppSession.getCustomer().getUserId());
		customerResult = cs.findCustomerAfterUpdate(c);
		c = customerResult.get(0);
		request.setAttribute("customer", c);
		request.getRequestDispatcher("UpdateCustomerProfile.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in UpdateCustomerProfileControllerServlet");
		Customer c = new Customer();
		CustomerService cs= new CustomerService();		
		String username = request.getParameter("username");
		String email = request.getParameter("email");			
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		c.setCustomerId(AppSession.getCustomer().getUserId());
		c.setCustomerName(username);
		c.setEmail(email);
		c.setCustomerAddress(address);
		c.setCustomerPassword(password);
		cs.updateCustomer(c);
		response.sendRedirect("DashboardControllerServlet");
	}

}
