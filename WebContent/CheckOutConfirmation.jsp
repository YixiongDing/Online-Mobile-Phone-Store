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
		<div style="margin-bottom: 30px;">
			<h2>Are you sure to place the order?</h2>
		</div>
		<img style="width: 20%; height: 20%; margin-bottom: 30px;"
			<%out.println("src=\"Resources/mp-" + mobile.getMobilePhoneId() + ".jpg\"");%>
			class="card-img-top" alt="...">
		<div class=""
			style=" margin-bottom: 30px; margin-left: auto; margin-right: auto; width: 20%;">
			<ul class="list-group list-group-flush mt-3 mb-3">
				<%
					out.println("<div> Model: " + mobile.getModelName() + "</div>");
					out.println("<div> Brand: " + mobile.getBrand() + "</div>");
					out.println("<div> Color: " + mobile.getColor() + "</div>");
					out.println("<div> StorageSize: " + mobile.getStorageSize() + "</div>");
					out.println("<div> Price: $" + mobile.getPrice() + "</div>");
				%>
			</ul>
		</div>
		<form action="PlaceOrderControllerServlet" method="post">
			<button type="submit" name="confirm"
				<%out.println("value=" + mobile.getMobilePhoneId());%>
				class="btn btn-primary">Confirm</button>
			<button type="submit" name="cancel" value="cancel"
				class="btn btn-primary">Cancel</button>
		</form>
	</section>
</body>
</html>