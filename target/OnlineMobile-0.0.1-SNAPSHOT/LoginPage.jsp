<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="security.AppSession"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
			<li class="nav-item"><a class="nav-link" href="HomePageControllerServlet">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ViewMobilePhonesControllerServlet">All Mobile Phones</a></li>
			<li class="nav-item active"><a class="nav-link" href="#">Login<span
					class="sr-only">(current)</span>
			</a></li>
		</ul>
	</div>
</nav>
<body>
	<section class="container text-center">
		<%
			if (!AppSession.isAuthenticated()) {
		%>
		<form action="LoginControllerServlet" method="post"
			style="margin-left: auto; margin-right: auto; margin-top: 100px; width: 20%;">
			<div class="form-group">
				<label for="exampleInputName">Username</label> <input type="name"
					class="form-control" id="exampleInputName" name="userName" required
					style="text-align: center;" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					required style="text-align: center;" name="passWord"
					placeholder="Enter Password">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<a class="btn btn-primary" href="RegisterControllerServlet"
				role="button">Register</a>
		</form>
		<%
			} else {
		%>
		<div style="margin-left: auto; margin-right: auto; margin-top: 200px;">
			<h1 class="h1-responsive font-weight-bold text-center my-5">
				Welcome, You have already login</h1>
		</div>
		<form action="LogoutControllerServlet" method="post">
			<div class="form-group">
				<label for="exampleInputPassword1"></label> <input type="hidden"
					class="form-control" style="text-align: center;" name="logout"
					value="logout">
			</div>
			<button type="submit" class="btn btn-primary">Logout</button>
		</form>
		<%
			}
		%>
	</section>
</body>
</html>