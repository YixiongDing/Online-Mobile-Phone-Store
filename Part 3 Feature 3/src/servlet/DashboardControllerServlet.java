package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.AppSession;

/**
 * Servlet implementation class AdminDashboardServlet
 */
@WebServlet("/DashboardControllerServlet")
public class DashboardControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated constructor stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from POST method in DashboardControllerServlet");
		if(AppSession.hasRole(AppSession.ADMIN_ROLE)) {
			request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("CustomerDashboard.jsp").forward(request, response);
		}
	}
}