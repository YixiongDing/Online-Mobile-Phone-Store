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
		System.out.println("Hello from GET method in AddMobilePhoneServlet");
		List<MobilePhone> allMobilePhones = new ArrayList<MobilePhone>();
		MobilePhoneService ms= new MobilePhoneService();		
		allMobilePhones = ms.getAllMobilePhone();
		int size = allMobilePhones.size();
		request.setAttribute("size", size);
		request.getRequestDispatcher("AddMobilePhone.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in AddMobilePhoneServlet");
		MobilePhone m = new MobilePhone();
		MobilePhoneService ms= new MobilePhoneService();		
		String id = request.getParameter("id");
		String modelName = request.getParameter("modelName");
		String storageSize = request.getParameter("storageSize");
		String color = request.getParameter("color");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String qty = request.getParameter("qty");
		String description = request.getParameter("description");
		m.setMobilePhoneId(Integer.valueOf(id));
		m.setModelName(modelName);
		m.setStorageSize(storageSize);
		m.setColor(color);
		m.setBrand(brand);
		m.setPrice(Float.valueOf(price));
		m.setQty(Integer.valueOf(qty));
		m.setDescription(description);
		ms.insertMobilePhone(m);
		response.sendRedirect("ManageMobilePhoneServlet");
	}
}
