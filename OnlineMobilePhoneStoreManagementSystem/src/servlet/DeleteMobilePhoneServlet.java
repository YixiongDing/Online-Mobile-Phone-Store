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
 * Servlet implementation class DeleteMobilePhoneServlet
 */
@WebServlet("/DeleteMobilePhoneServlet")
public class DeleteMobilePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMobilePhoneServlet() {
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


		if(request.getParameter("delete") != null){
			MobilePhoneService ms= new MobilePhoneService();		
			MobilePhone m = new MobilePhone();
			List<MobilePhone> result = new ArrayList<MobilePhone>();
			String deleteId = request.getParameter("delete");
			m.setId(Integer.valueOf(deleteId));
			if(ms.deleteMobilePhone(m)) {
				response.sendRedirect("ManageMobilePhoneServlet");
			}
		} else {
			response.sendRedirect("ManageMobilePhoneServlet"); 
		}
	}

}
