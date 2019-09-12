<%@ page language="java" contentType="text/html charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.MobilePhone"%>

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
	Mobile Phone Store</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">Welcome</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="LoginSuccess.jsp">Dashboard</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="ManageMobilePhoneServlet">Manage Mobile Phones <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Manage
					Orders</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Manage
					Customer Accounts</a></li>
		</ul>

		<div class="nav-item  my-2 my-lg-0">
			<a class="nav-link" href="HomePageServlet">Logout</a>
		</div>
	</div>
</nav>
<body>
	<section class="text-center my-5">
		<div class='container'>
			<table class='table table-bordered table-striped'>
				<tr>
					<th>id</th>
					<th>Model</th>
					<th>Brand</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Operation</th>
				</tr>
				<tbody>
					<%
						List<MobilePhone> mobiles = (ArrayList<MobilePhone>) request.getAttribute("mobiles");

						for (MobilePhone mobile : mobiles) {
							out.println("<form action=\"ManageMobilePhoneServlet\" method=\"post\">");
							out.print("<tr><td>" + mobile.getMobileId() + "</td><td>" + mobile.getModel() + "</td><td>"
									+ mobile.getBrand() + "</td><td>" + mobile.getPrice() + "</td><td>" + mobile.getQty() + "</td>"
									+ "<td colspan=\"2\" align=\"center\">"
									+ "<button style=\"margin: 0px 10px 0px 10px;\" type=\"submit\" name=\"update\" value=\""
									+ mobile.getMobileId() + "\" class=\"btn btn-primary\">Update</button>"
									+ "<button style=\"margin: 0px 10px 0px 10px;\" type=\"submit\" name=\"delete\" value=\""
									+ mobile.getMobileId() + "\" class=\"btn btn-primary\">Delete</button></td></tr>");
							out.println("</form>");
						}
					%>
				</tbody>
			</table>
			<form action = "AddMobilePhoneServlet" method = "get">
				<button type="submit" name="insert" value="insert"
					class="btn btn-primary">Add A New Mobile Phone</button>
			</form>

		</div>
	</section>
</body>
</html>