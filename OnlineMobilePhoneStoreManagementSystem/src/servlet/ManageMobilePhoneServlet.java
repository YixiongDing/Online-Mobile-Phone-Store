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
 * Servlet implementation class ManageMobilePhoneServlet
 */
@WebServlet("/ManageMobilePhoneServlet")
public class ManageMobilePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageMobilePhoneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in ManageMobilePhoneServlet");
		List<MobilePhone> allMobilePhones = new ArrayList<MobilePhone>();
		MobilePhoneService ms= new MobilePhoneService();		
		allMobilePhones = ms.getAllMobilePhone();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");		
		request.setAttribute("mobiles", allMobilePhones);
		request.getRequestDispatcher("ManageMobilePhone.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in ManageMobilePhoneServlet");
		MobilePhoneService ms= new MobilePhoneService();		
		MobilePhone m = new MobilePhone();
		List<MobilePhone> result = new ArrayList<MobilePhone>();
		if(request.getParameter("update") != null){
			String updateId = request.getParameter("update");
			m.setMobilePhoneId(Integer.valueOf(updateId));
			result = ms.getMobilePhone(m);
			request.setAttribute("mobile", result);
			request.getRequestDispatcher("UpdateMobilePhoneInfo.jsp").forward(request, response); 
		} else {
			String deleteId = request.getParameter("delete");
			m.setMobilePhoneId(Integer.valueOf(deleteId));
			result = ms.getMobilePhone(m);
			request.setAttribute("mobile", result);
			request.getRequestDispatcher("DeleteConfirm.jsp").forward(request, response); 
		}
	}

}
