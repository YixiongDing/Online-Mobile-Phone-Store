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
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePageControllerServlet")
public class HomePageControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in HomePageControllerServlet");
		MobilePhoneService ms= new MobilePhoneService();
		List<MobilePhone> allMobilePhones = new ArrayList<MobilePhone>();
		allMobilePhones = ms.getAllMobilePhone();	
		request.setAttribute("mobiles", allMobilePhones);
		request.getRequestDispatcher("HomePage.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in HomePageControllerServlet");
		doGet(request, response);
	}
}
