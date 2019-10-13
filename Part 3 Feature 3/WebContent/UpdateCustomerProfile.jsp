<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.Customer"%>
<%@ page import="service.CustomerService"%>
<%@ page import="java.util.*"%>
<%@ page import="security.AppSession"%>

<!DOCTYPE html>
<html>
<head>
<title>Update Phone</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' href='style.css' />
</head>
<h1 class="h1-responsive font-weight-bold text-center my-5">Online
	Mobile Phone Store</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
</nav>
<body>
	<%
		Customer c = new Customer();
		c = (Customer)request.getAttribute("customer");
	
	%>
	<a href="DashboardControllerServlet" class="blue-text">
		<h6 class="font-weight-bold mb-3" style="font-size: 20px;">
			<i class="fas fa-fire pr-2"><- My Dashboard </i>
		</h6>
	</a>
	<section class="container text-center">
		<h2 style="margin-bottom: 20px;">Update My Profile</h2>

		<form action="UpdateCustomerProfileControllerServlet" method="post"
			style="margin-left: auto; margin-right: auto; width: 20%;">
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">
					Username</label> <input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="username" required
					<%out.println("value=\"" + c.getName() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Email
				</label> <input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="email" required
					<%out.println("value=\"" + c.getEmail() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Address</label>
				<input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="address" required
					<%out.println("value=\"" + c.getAddress() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Brand</label>
				<input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="password" required
					<%out.println("value=\"" + c.getPassword() + "\"");%>></input>
			</div>
			<footer>
				<button type="submit" name="button" value="submit"
					class="btn btn-primary">Submit</button>
			</footer>
		</form>
	</section>
</body>
</html>