package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;  


import domain.MobilePhone;
import service.MobilePhoneService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in LoginServlet");
		response.sendRedirect("LoginPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Post method in LoginServlet");
		String user = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		String correctUser = getServletConfig().getInitParameter("userNameI");
		String correctPass = getServletConfig().getInitParameter("passWordI");					
		if(user.equals(correctUser) && pass.equals(correctPass)) {
            Cookie ck=new Cookie("name", user);  
            response.addCookie(ck);  
    		response.sendRedirect("AdminDashboardServlet");
		}else {
			response.sendRedirect("LoginFail.jsp");
		}
	}
}
