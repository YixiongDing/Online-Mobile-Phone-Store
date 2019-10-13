package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import domain.*;
import security.AppSession;
import service.*;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method in LoginControllerServlet");
		String view ="/LoginPage.jsp";
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispathcer = servletContext.getRequestDispatcher(view);
		requestDispathcer.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Post method in LoginControllerServlet");
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		
		Subject currentUser = SecurityUtils.getSubject();	
		String view = "/LoginPage.jsp";
		
		try {
			currentUser.login(token);
			view = "/DashboardControllerServlet";
			User user = User.getUser(username);
			request.setAttribute("userType", user.getUserType());
			if(user.getUserType().equals("CUSTOMER")) {
				Customer c = new Customer();
				CustomerService cs = new CustomerService();
				c.setCustomerId(user.getUserId());
				AppSession.init(cs.findCustomer(c).get(0));
			}else if(user.getUserType().equals("ADMIN")) {
				AppSession.init((Administrator)user);
				
			} else {
				AppSession.init(user);
			}
		}catch (UnknownAccountException | IncorrectCredentialsException e) {
			view = "/LoginFail.jsp";
		}finally {
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
			requestDispatcher.forward(request,response);
			
		}
	}

}
