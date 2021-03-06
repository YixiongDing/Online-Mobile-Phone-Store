package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MobilePhone;
import service.MobilePhoneService;

/**
 * Servlet implementation class UpdateMobilePhoneInfoControllerServlet
 */
@WebServlet("/UpdateMobilePhoneInfoControllerServlet")
public class UpdateMobilePhoneInfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMobilePhoneInfoControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in UpdateMobilePhoneInfoControllerServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in UpdateMobilePhoneInfoControllerServlet");
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
		ms.updateMobilePhone(m);
		response.sendRedirect("ManageMobilePhoneControllerServlet");
	}
}
