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
 * Servlet implementation class MobilePhoneDetailControllerServlet
 */
@WebServlet("/MobilePhoneDetailControllerServlet")
public class MobilePhoneDetailControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobilePhoneDetailControllerServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request	, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in MobilePhoneDetailControllerServlet");
		List<MobilePhone> result= new ArrayList<MobilePhone>();
		MobilePhone m = new MobilePhone();
		MobilePhoneService ms= new MobilePhoneService();	
		m.setMobilePhoneId(Integer.valueOf(request.getParameter("mobileDetail")));
		result = ms.getMobilePhone(m);
		request.setAttribute("mobile", result);
		request.getRequestDispatcher("MobilePhoneDetail.jsp").forward(request, response); 
	}

}
