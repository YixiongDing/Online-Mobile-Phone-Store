<%@ page language="java" contentType="text/html charset=UTF-8"
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
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

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
			<li class="nav-item active"><a class="nav-link"
				href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="ViewMobilePhones">All
					Mobile Phones</a></li>
			<li class="nav-item"><a class="nav-link"
				href="SimpleLogInForm.html">Login</a></li>

		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>
<body>
	<section class="text-center my-5">

		<div class='container'>
			<table class='table table-bordered table-striped'>
				<tr>
					<th>id</th>
					<th>Model Name</th>
					<th>Storage Size</th>
					<th>Color</th>
					<th>Brand</th>
					<th>Price</th>
					<th>Add to Cart</th>
				</tr>
				<tbody>
					<%
						List<MobilePhone> mobiles = (ArrayList<MobilePhone>) request.getAttribute("mobiles");

						for (MobilePhone mobile : mobiles) {
							out.println("<form action=\"cart\" method=\"post\">");
							out.print("<tr><td>" + mobile.getMobilePhoneId() + "</td><td>" + mobile.getModelName() + "</td>"
									+ "<td>" + mobile.getStorageSize() 
									+ "</td><td>" + mobile.getColor() + "</td>"
									+ "<td>"
									+ mobile.getBrand() + "</td><td>" + mobile.getPrice() + "</td>"
									+ "<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"isbn\" value=\""
									+ mobile.getId() + "\" class=\"btn btn-default\">Add to Cart</button></td></tr>");
							out.println("</form>");
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="row">
			<%
						List<MobilePhone> mobiless = (ArrayList<MobilePhone>) request.getAttribute("mobiles");

						for (MobilePhone mobile : mobiless) {
							out.println("<div class=\"column\">");
							out.println("<div class=\"card\"\">");
							out.println("<img src=\"Resources/apple-iphone-xs-max-gold.jpg\" class=\"card-img-top\" alt=\"...\">");
							out.println("<div class=\"card-body\">");
							out.println("<h5 class=\"card-title\">"+mobile.getModelName()+"</h5>");
							out.println("<p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the cards content.</p>");
							out.println("<a href=\"#\" class=\"btn btn-primary\">View Detail</a>");
							out.println("</div></div></div>");
						}
					%>
		</div>
	</section>
</body>
</html>