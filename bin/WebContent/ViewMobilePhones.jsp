<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.MobilePhone"%>

<!DOCTYPE html>
<html>
<head>
<style>
/* Float four columns side by side */
.column {
	float: left;
	width: 25%;
	padding: 0 10px;
	margin-top: 20px;
}

/* Remove extra left and right margins, due to padding */
.row {
	margin: 0 -5px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
	.column {
		width: 100%;
		display: block;
		margin-bottom: 20px;
	}
}

/* Style the counter cards */
</style>

<title>View Mobile Phones</title>
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
			<li class="nav-item"><a class="nav-link" href="HomePageServlet">Home</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="ViewMobilePhones">All Mobile Phones<span class="sr-only">(current)</span>
			</a></li>
		</ul>
		<div class="nav-item  my-2 my-lg-0">
			<a class="nav-link" href="LoginServlet">Hello! Please Login</a>
		</div>
	</div>
</nav>
<body>
	<section class="text-center my-5">
		<div class="row">
			<%
						List<MobilePhone> mobiless = (ArrayList<MobilePhone>) request.getAttribute("mobiles");

						for (MobilePhone mobile : mobiless) {
							out.println("<div class=\"column\">");
							out.println("<div class=\"card\"\">");
							out.println("<img src=\"Resources/mp-" + mobile.getMobilePhoneId()+".jpg\" class=\"card-img-top\" alt=\"no image for this mobile phone\">");
							out.println("<div class=\"card-body\">");
							out.println("<h5 class=\"card-title\">"+mobile.getModelName()+"</h5>");
							out.println("<p class=\"card-text\">"+mobile.getDescription()+"</p>");
							out.println("<a href=\"#\" class=\"btn btn-primary\">View Detail</a>");
							out.println("</div></div></div>");
						}
					%>
		</div>
	</section>
</body>
</html>