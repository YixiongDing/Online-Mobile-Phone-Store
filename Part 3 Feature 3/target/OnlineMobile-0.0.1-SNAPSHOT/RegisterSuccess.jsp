<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.MobilePhone"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Mobile Phone Store Management System</title>
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
			<li class="nav-item active"><a class="nav-link"
				href="HomePageControllerServlet">Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="ViewMobilePhonesControllerServlet">All
					Mobile Phones</a></li>
		</ul>
	</div>
</nav>
<body>
	<section class="text-center my-5">
		<div style="margin-left: auto; margin-right: auto; margin-top: 200px;">
			<h1 class="h1-responsive font-weight-bold text-center my-5">
				Register Success, please login!</h1>
		</div>
		<form action="LoginControllerServlet" method="get">
			<button type="submit" name="button" value="submit"
				class="btn btn-primary">OK</button>
		</form>
	</Section>
</body>
</html>