package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import domain.MobilePhone;
import service.CustomerService;

/**
 * Servlet implementation class RegisterNewAccountServlet
 */
@WebServlet("/RegisterNewAccountServlet")
public class RegisterNewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterNewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in RegisterNewAccountServlet");
		request.getRequestDispatcher("RegisterNewAccount.jsp").forward(request, response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in RegisterNewAccountServlet");
		Customer c = new Customer();
		List<Customer> allCustomers = new ArrayList<Customer>();
		CustomerService cs= new CustomerService();		
		allCustomers = cs.getAllCustomer();
		int size = allCustomers.size();

		String fullName = request.getParameter("fullName");
		String emailAddress = request.getParameter("emailAddress");
		String postAddress = request.getParameter("postAddress");
		String password = request.getParameter("password");
		c.setCustomerId(2000+size+1);
		c.setCustomerName(fullName);
		c.setCustomerEmail(emailAddress);
		c.setCustomerPostAddress(postAddress);
		c.setCustomerPassword(password);
		cs.insertCustomer(c);
		Cookie ck=new Cookie("name",fullName);  
        response.addCookie(ck);  
		response.sendRedirect("HomePageServlet");
	}

}
