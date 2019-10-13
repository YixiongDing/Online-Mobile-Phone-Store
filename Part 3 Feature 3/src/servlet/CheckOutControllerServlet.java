package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MobilePhone;
import service.MobilePhoneService;

/**
 * Servlet implementation class CheckOutControllerServlet
 */
@WebServlet("/CheckOutControllerServlet")
public class CheckOutControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutControllerServlet() {
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
		// TODO Auto-generated method stub
		System.out.println("Hello from POST method in CheckOutControllerServlet");
		MobilePhoneService ms= new MobilePhoneService();		
		MobilePhone m = new MobilePhone();
		List<MobilePhone> result = new ArrayList<MobilePhone>();
		String mobileId = request.getParameter("buyNow");
		m.setMobilePhoneId(Integer.valueOf(mobileId));
		result = ms.getMobilePhone(m);
		request.setAttribute("mobile", result);
		request.getRequestDispatcher("CheckOutConfirmation.jsp").forward(request, response); 
	}
}
