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
 * Servlet implementation class AddMobilePhoneServlet
 */
@WebServlet("/AddMobilePhoneServlet")
public class AddMobilePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMobilePhoneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("AddMobilePhone.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if(button.equals("submit")){
			MobilePhone m = new MobilePhone();
			MobilePhoneService ms= new MobilePhoneService();		
			String id = request.getParameter("id");
			String model = request.getParameter("model");
			String brand = request.getParameter("brand");
			String price = request.getParameter("price");
			String qty = request.getParameter("qty");
			String description = request.getParameter("description");

			m.setId(Integer.valueOf(id));
			m.setModel(model);
			m.setBrand(brand);
			m.setPrice(Float.valueOf(price));
			m.setQty(Integer.valueOf(qty));
			m.setDescription(description);
			ms.insertMobilePhone(m);
			response.sendRedirect("ManageMobilePhoneServlet");
		}else if(button.equals("cancel")) {
			response.sendRedirect("ManageMobilePhoneServlet");

		}
	}

}
