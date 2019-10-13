<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.Order"%>
<%@ page import="security.AppSession"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Mobile Phone</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' href='style.css' />
</head>
<h1 class="h1-responsive font-weight-bold text-center my-5">Online
	Mobile Phone Store Management System</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
</nav>
<body>
	<a href="DashboardControllerServlet" class="blue-text">
		<h6 class="font-weight-bold mb-3" style="font-size: 20px;">
			<i class="fas fa-fire pr-2"><- My Dashboard </i>
		</h6>
	</a>
	<section class="text-center my-5">
		<h2 style="margin-bottom: 20px;">Manage My Order</h2>
		<div class='container'>
			<table class='table table-bordered table-striped'>
				<tr>
					<th>id</th>
					<th>Create Time</th>
					<th>Status</th>
					<th>Mobile Model</th>
					<th>Deliver Address</th>
					<th>Operation</th>
				</tr>
				<tbody>
					<%
						List<Order> orders = (ArrayList<Order>) request.getAttribute("orders");

						for (Order order : orders) {
							out.println("<form action=\"ManageCustomerOrderControllerServlet\" method=\"post\">");
							out.print("<tr><td>" + order.getId() + "</td><td>" + order.getCreateTime() + "</td><td>"
									+ order.getStatus() + "</td><td>" + order.getMobilePhone().getModelName() + "</td><td>"
									+ order.getCustomer().getCustomerAddress() + "</td>" + "<td colspan=\"2\" align=\"center\">"
									+ "<button style=\"margin: 0px 10px 0px 10px;\" type=\"submit\" name=\"cancel\" value=\""
									+ order.getId() + "\" class=\"btn btn-primary\">Cancel</button></td></tr>");
							out.println("</form>");
						}
					%>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>