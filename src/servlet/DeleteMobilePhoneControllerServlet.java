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
 * Servlet implementation class DeleteMobilePhoneControllerServlet
 */
@WebServlet("/DeleteMobilePhoneControllerServlet")
public class DeleteMobilePhoneControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMobilePhoneControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in DeleteMobilePhoneControllerServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in DeleteMobilePhoneControllerServlet");
		if(request.getParameter("delete") != null){
			MobilePhoneService ms= new MobilePhoneService();		
			MobilePhone m = new MobilePhone();
			String deleteId = request.getParameter("delete");
			m.setMobilePhoneId(Integer.valueOf(deleteId));
			if(ms.deleteMobilePhone(m)) {
				response.sendRedirect("ManageMobilePhoneControllerServlet");
			}
		} else {
			response.sendRedirect("ManageMobilePhoneControllerServlet"); 
		}
	}

}
