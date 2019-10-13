package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class PlaceOrderControllerServlet
 */
@WebServlet("/PlaceOrderControllerServlet")
public class PlaceOrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in PlaceOrderControllerServlet");
		if(request.getParameter("confirm") != null){
			OrderService os = new OrderService();
			MobilePhoneService ms= new MobilePhoneService();
			CustomerService cs = new CustomerService();
			MobilePhone m = new MobilePhone();
			Customer c = new Customer();
			Order o = new Order();
		    Date date = new Date();
			List<MobilePhone> mobileResult = new ArrayList<MobilePhone>();
			List<Customer> customerResult = new ArrayList<Customer>();
			List<Order> allOrders = new ArrayList<Order>();
			String mobileId = request.getParameter("confirm");
			m.setMobilePhoneId(Integer.valueOf(mobileId));
			c.setCustomerId(AppSession.getCustomer().getUserId());
			mobileResult = ms.getMobilePhone(m);
			customerResult = cs.findCustomer(c);
			allOrders = os.getAllOrder();
			int size = allOrders.size();	
			o.setOrderId(3000+size+1);
			o.setCreateTime(date);
			o.setStatus("PROCESSING");
			o.setMobilePhone(mobileResult.get(0));
			o.setCustomer(customerResult.get(0));
			if(os.insertOrder(o)) {
				response.sendRedirect("ManageCustomerOrderControllerServlet");
			}
		} else {
			response.sendRedirect("ViewMobilePhonesControllerServlet"); 
		}
	}
}
