package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import domain.MobilePhone;
import domain.User;
import security.AppSession;
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
		String view ="/LoginPage.jsp";
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispathcer = servletContext.getRequestDispatcher(view);
		requestDispathcer.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Post method in LoginServlet");
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		
		Subject currentUser = SecurityUtils.getSubject();	
		String view = "/LoginPage.jsp";
		
		try {
			currentUser.login(token);
			view = "/AdminDashboardControllerServlet";
			User user = User.getUser(username);
			AppSession.init(user);
		}catch (UnknownAccountException | IncorrectCredentialsException e) {
			view = "/LoginFail.jsp";
		}finally {
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
			requestDispatcher.forward(request,response);
			
		}
		
	}
}
