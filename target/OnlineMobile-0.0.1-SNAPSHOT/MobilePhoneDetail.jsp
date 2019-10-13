<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="security.AppSession"%>
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
<%
		List<MobilePhone> mobiles = (ArrayList<MobilePhone>) request.getAttribute("mobile");
		MobilePhone mobile = mobiles.get(0);
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
			<li class="nav-item"><a class="nav-link" href="HomePageControllerServlet">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ViewMobilePhonesControllerServlet">All Mobile Phones</a></li>
			<li class="nav-item active"><a class="nav-link" href="#"> <%
						out.println(mobile.getModelName());
					%><span class="sr-only">(current)</span>
			</a></li>
		</ul>
		
		<div class="nav-item  my-2 my-lg-0">
			<%
				if (AppSession.isAuthenticated()) {
					
			%>
					<a class="nav-link" href="DashboardControllerServlet">Dashboard</a>
			<%
				} 
			%>
		</div>		

		<div class="nav-item  my-2 my-lg-0">
			<%
				if (!AppSession.isAuthenticated()) {
			%>
			<a class="nav-link" href="LoginControllerServlet">Hello! Please Login</a>
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

	<!-- Section: Features v.3 -->
	<section class="my-5">

		<!-- Section heading -->
		<h2 class="h1-responsive font-weight-bold text-center my-3">
			<%
				out.println(mobile.getModelName());
			%>
		</h2>
		<!-- Section description -->
		<p class="lead grey-text text-center w-50 mx-auto mb-5">
			<%
				out.println(mobile.getDescription());
			%>
		</p>

		<!-- Grid row -->
		<div class="row">

			<!-- Grid column -->
			<div class="col-lg-5 text-center text-lg-left">
				<img class="img-fluid"
					<%out.println("<img src=\"Resources/mp-" + mobile.getMobilePhoneId()
					+ ".jpg\" class=\"card-img-top\" alt=\"no image for this mobile phone\"");%>>
			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-lg-7">

				<!-- Grid row -->
				<div class="row mb-3">

					<!-- Grid column -->
					<div class="col-1">
						<i class="fas fa-share fa-lg indigo-text"></i>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-xl-10 col-md-11 col-10">
						<h5 class="font-weight-bold mb-3">
							<%
								out.println(mobile.getBrand());
							%>
						</h5>
						<p class="grey-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit enim ad minima veniam, quis nostrum
							exercitationem ullam. Reprehenderit maiores aperiam assumenda
							deleniti hic.</p>
					</div>
					<!-- Grid column -->

				</div>
				<!-- Grid row -->
				<div class="row mb-3">

					<!-- Grid column -->
					<div class="col-1">
						<i class="fas fa-share fa-lg indigo-text"></i>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-xl-10 col-md-11 col-10">
						<h5 class="font-weight-bold mb-3">
							<%
								out.println(mobile.getColor());
							%>
						</h5>
						<p class="grey-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit enim ad minima veniam, quis nostrum
							exercitationem ullam. Reprehenderit maiores aperiam assumenda
							deleniti hic.</p>
					</div>
					<!-- Grid column -->

				</div>
				<!-- Grid row -->

				<!-- Grid row -->
				<div class="row mb-3">

					<!-- Grid column -->
					<div class="col-1">
						<i class="fas fa-share fa-lg indigo-text"></i>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-xl-10 col-md-11 col-10">
						<h5 class="font-weight-bold mb-3">
							<%
								out.println(mobile.getStorageSize());
							%>
						</h5>
						<p class="grey-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit enim ad minima veniam, quis nostrum
							exercitationem ullam. Reprehenderit maiores aperiam assumenda
							deleniti hic.</p>
					</div>
					<!-- Grid column -->

				</div>
				<!-- Grid row -->

				<!--Grid row-->
				<div class="row mb-3">
					<!-- Grid column -->
					<div class="col-1">
						<i class="fas fa-share fa-lg indigo-text"></i>
					</div>
					<!-- Grid column -->
					<!-- Grid column -->
					<div class="col-xl-10 col-md-11 col-10">
						<h5 class="font-weight-bold mb-3">
							<%
								out.println("$" + mobile.getPrice());
							%>
						</h5>
						<p class="grey-text mb-0">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit enim ad minima veniam, quis nostrum
							exercitationem ullam. Reprehenderit maiores aperiam assumenda
							deleniti hic.</p>
					</div>
					<!-- Grid column -->
				</div>
				<!--Grid row-->
				<!--Grid row-->
				<div class="row mb-3">
					<!-- Grid column -->
					<div class="col-1">
						<i class="fas fa-share fa-lg indigo-text"></i>
					</div>
					<!-- Grid column -->
					<!-- Grid column -->
					<div class="col-xl-10 col-md-11 col-10">
						<%
							if (AppSession.isAuthenticated() && AppSession.hasRole(AppSession.CUSTOMER_ROLE)) {
						%>
						<form action="CheckOutControllerServlet" method="post">
							<div class="form-group">
								<label for="atc"></label> <input type="hidden"
									class="form-control" style="text-align: center;"
									name="buyNow" value=<%out.println(mobile.getMobilePhoneId());%>>
							</div>
							<button type="submit" class="btn btn-primary">Buy Now</button>
						</form>
						<%
							} else {
						%>
						<h4 class="text-primary mt-5 "> Login to purchase this mobile phone </h4>
						<%
							}
						%>
					</div>
					<!-- Grid column -->
				</div>
				<!--Grid row-->
			</div>
			<!--Grid column-->
		</div>
		<!-- Grid row -->

	</section>
	<!-- Section: Features v.3 -->
</body>
</html>