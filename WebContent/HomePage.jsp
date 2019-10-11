<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="security.AppSession"%>
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

<%
	List<MobilePhone> mobiles = (ArrayList<MobilePhone>) request.getAttribute("mobiles");
	MobilePhone m1 = mobiles.get(0);
	MobilePhone m2 = mobiles.get(1);
	MobilePhone m3 = mobiles.get(2);
%>

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
				href="HomePageServlet">Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ViewMobilePhonesServlet">All Mobile Phones</a></li>
		</ul>

		<div class="nav-item  my-2 my-lg-0">
			<%
				if (!AppSession.isAuthenticated()) {
			%>
			<a class="nav-link" href="LoginServlet">Hello! Please Login</a>
		</div>
		<%
			} else {
		%>
			<form action="LogoutControllerServlet" method="post">
				<div class="form-group" style="margin-bottom: -25px">
					<label for="exampleInputPassword1"></label> <input type="hidden"
						class="form-control" style="text-align: center;" name="logout"
						value="logout">
				</div>
				<button type="submit" class="btn btn-primary">Logout</button>
			</form>
		</div>

		<%
			}
		%>
	</div>
</nav>
<body>
	<section class="text-center my-5">
		<!-- Grid row -->
		<div class="row">
			<!-- Grid column -->
			<div class="col-lg-4 col-md-12 mb-lg-0 mb-4">
				<!-- Featured image -->
				<div class="view overlay rounded z-depth-2 mb-4">
					<img class="img-fluid"
						<%out.println("src=\"Resources/mp-" + m1.getMobilePhoneId() + ".jpg\"");%>
						alt="Sample image"> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!-- Category -->
				<a href="#!" class="pink-text">
					<h6 class="font-weight-bold mb-3">
						<i class="fas fa-map pr-2"></i>Ultimate
					</h6>
				</a>
				<!-- Post title -->
				<h4 class="font-weight-bold mb-3">
					<%
						out.println("<strong>" + m1.getModelName() + "</strong>");
					%>
				</h4>
				<!-- Post data -->
				<p>
					<%
						out.println("<a class=\"font-weight-bold\">" + "$" + m1.getPrice() + "</a>");
					%>
				</p>
				<!-- Excerpt -->
				<%
					out.println("<p class=\"dark-grey-text\">" + m1.getDescription() + "</p");
				%>
				<!-- Read more button -->
				<form action="MobilePhoneDetailControllerServlet" method="post">
					<div class="form-group" style="margin-bottom: -20px">
						<label for="m1"></label> <input type="hidden" class="form-control"
							style="text-align: center;" name="mobileDetail"
							value=<%out.println(m1.getMobilePhoneId());%>>
					</div>
					<button type="submit" class="btn btn-primary">Check More</button>
				</form>
			</div>
			<!-- Grid column -->
			<!-- Grid column -->
			<div class="col-lg-4 col-md-6 mb-md-0 mb-4">
				<!-- Featured image -->
				<div class="view overlay rounded z-depth-2 mb-4">
					<img class="img-fluid"
						<%out.println("src=\"Resources/mp-" + m2.getMobilePhoneId() + ".jpg\"");%>
						alt="Sample image"> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!-- Category -->
				<a href="#!" class="deep-orange-text">
					<h6 class="font-weight-bold mb-3">
						<i class="fas fa-graduation-cap pr-2"></i>Luxury
					</h6>
				</a>
				<!-- Post title -->
				<h4 class="font-weight-bold mb-3">
					<%
						out.println("<strong>" + m2.getModelName() + "</strong>");
					%>
				</h4>
				<!-- Post data -->
				<p>
					<%
						out.println("<a class=\"font-weight-bold\">" + "$" + m2.getPrice() + "</a>");
					%>
				</p>
				<!-- Excerpt -->
				<%
					out.println("<p class=\"dark-grey-text\">" + m2.getDescription() + "</p");
				%>
				<!-- Read more button -->
				<form action="MobilePhoneDetailControllerServlet" method="post">
					<div class="form-group" style="margin-bottom: -20px">
						<label for="m1"></label> <input type="hidden" class="form-control"
							style="text-align: center;" name="mobileDetail"
							value=<%out.println(m2.getMobilePhoneId());%>>
					</div>
					<button type="submit" class="btn btn-primary">Check More</button>
				</form>
			</div>
			<!-- Grid column -->
			<!-- Grid column -->
			<div class="col-lg-4 col-md-6 mb-0">
				<!-- Featured image -->
				<div class="view overlay rounded z-depth-2 mb-4">
					<img class="img-fluid"
						<%out.println("src=\"Resources/mp-" + m3.getMobilePhoneId() + ".jpg\"");%>
						alt="Sample image"> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!-- Category -->
				<a href="#!" class="blue-text">
					<h6 class="font-weight-bold mb-3">
						<i class="fas fa-fire pr-2"></i>Classic
					</h6>
				</a>
				<!-- Post title -->
				<h4 class="font-weight-bold mb-3">
					<%
						out.println("<strong>" + m3.getModelName() + "</strong>");
					%>
				</h4>
				<!-- Post data -->
				<p>
					<%
						out.println("<a class=\"font-weight-bold\">" + "$" + m3.getPrice() + "</a>");
					%>
				</p>
				<!-- Excerpt -->
				<%
					out.println("<p class=\"dark-grey-text\">" + m3.getDescription() + "</p");
				%>
				<!-- Read more button -->
				<form action="MobilePhoneDetailControllerServlet" method="post">
					<div class="form-group" style="margin-bottom: -20px">
						<label for="m1"></label> <input type="hidden" class="form-control"
							style="text-align: center;" name="mobileDetail"
							value=<%out.println(m3.getMobilePhoneId());%>>
					</div>
					<button type="submit" class="btn btn-primary">Check More</button>
				</form>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->
	</Section>
</body>
</html>