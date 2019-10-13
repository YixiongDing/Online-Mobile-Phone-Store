package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import domain.MobilePhone;
import domain.Order;
import security.AppSession;
import service.MobilePhoneService;
import service.OrderService;

/**
 * Servlet implementation class ManageCustomerOrderControllerServlet
 */
@WebServlet("/ManageCustomerOrderControllerServlet")
public class ManageCustomerOrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCustomerOrderControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in ManageCustomerOrderControllerServlet");
		List<Order> allOrders = new ArrayList<Order>();
		OrderService os= new OrderService();		
		allOrders = os.getOrderByCustomerId((Customer)AppSession.getCustomer());
		request.setAttribute("orders", allOrders);
		request.getRequestDispatcher("ManageCustomerOrder.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in ManageCustomerOrderControllerServlet");
		if(request.getParameter("cancel") != null){
			OrderService os= new OrderService();		
			Order o = new Order();
			String cancelId = request.getParameter("cancel");
			o.setOrderId(Integer.valueOf(cancelId));
			if(os.deleteOrder(o)) {
				response.sendRedirect("ManageCustomerOrderControllerServlet");
			}
		} else {
			response.sendRedirect("ManageCustomerOrderControllerServlet"); 
		}
	}

}
