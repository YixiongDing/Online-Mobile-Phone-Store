<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.MobilePhone"%>
<%@ page import="java.util.*"%>


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
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

</nav>
<body>
	<%
		List<MobilePhone> mobiles = (ArrayList<MobilePhone>) request.getAttribute("mobile");
		MobilePhone mobile = mobiles.get(0);
	%>
	<section class="container text-center">
		<h2>Are you sure to delete</h2>
		<img style="width: 30%; height: 30%;"
			<%out.println("src=\"Resources/mp-" + mobile.getMobileId() + ".jpg\"");%>
			class="card-img-top" alt="...">
		<div class="card">

			<div class="card-body">
				<%
					out.println("<h5 class=\"card-title\">" + mobile.getMobileId()+ "</h5>");
					out.println("<p class=\"card-text\">" + mobile.getModel()+ "</p>");

				%>
			</div>
			<ul class="list-group list-group-flush">
				<%
					out.println("<li class=\"list-group-item\">" + mobile.getBrand()+ "</li>");
					out.println("<li class=\"list-group-item\"> Price: $" + mobile.getPrice()+ "</li>");
					out.println("<li class=\"list-group-item\"> Quantity: " + mobile.getQty()+ "</li>");

				%>
			</ul>
			<form action="DeleteMobilePhoneServlet" method="post">
				<button type="submit" name="delete" <% out.println("value="+ mobile.getMobileId()); %>
					class="btn btn-primary" >Delete</button>
				<button type="submit" name="cancel" value="cancel"
					class="btn btn-primary">Cancel</button>
			</form>
		</div>	
	</section>
</body>
</html>