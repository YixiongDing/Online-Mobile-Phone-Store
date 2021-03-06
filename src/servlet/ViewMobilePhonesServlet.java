package servlet;

import domain.MobilePhone;
import service.MobilePhoneService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewMobilePhones
 */
@WebServlet("/ViewMobilePhonesServlet")
public class ViewMobilePhonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMobilePhonesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in ViewMobilePhonesServlet");
		List<MobilePhone> allMobilePhones = new ArrayList<MobilePhone>();
		MobilePhoneService ms= new MobilePhoneService();		
		allMobilePhones = ms.getAllMobilePhone();
		request.setAttribute("mobiles", allMobilePhones);
		request.getRequestDispatcher("ViewMobilePhones.jsp").forward(request, response); 
	}
}
