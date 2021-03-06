<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' href='style.css' />
<meta charset="UTF-8">
<title>Login Success Page</title>
</head>
<h1 class="h1-responsive font-weight-bold text-center my-5">Online
	Mobile Phone Store Management System</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="">Welcome, Administrator</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="">Dashboard
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ManageMobilePhoneControllerServlet">Manage Mobile Phones</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ManageOrderControllerServlet">Manage Orders</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Manage
					Customer Accounts</a></li>
		</ul>
		<div class="nav-item  my-2 my-lg-0">
			<form action="LogoutControllerServlet" method="post">
				<div class="form-group" style="margin-bottom: -25px">
					<label for="exampleInputPassword1"></label> <input type="hidden"
						class="form-control" style="text-align: center;" name="logout"
						value="logout">
				</div>
				<button type="submit" class="btn btn-primary">Logout</button>
			</form>
		</div>
	</div>
</nav>
<body>
	<section class="text-center">
		<!-- Grid row -->
		<div class="row" style="margin-top: 60px;">
			<!-- Grid column -->
			<div class="col-lg-4 col-md-12 mb-lg-0 mb-4">
				<!-- Featured image -->
				<div class="view overlay rounded z-depth-2 mb-4">
					<img style="width: 340px; height: 300px;"
						img-fluid"   
						src="Resources/manage-mobile.png"
						alt="Sample image"> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!-- Category -->
				<a href="#!" class="pink-text">
					<h6 class="font-weight-bold mb-3">
						<i class="fas fa-map pr-2"></i>
					</h6>
				</a>
				<!-- Post title -->
				<h4 class="font-weight-bold mb-3">Manage Mobile Phones</h4>
				<!-- Post data -->
				<p></p>
				<!-- Excerpt -->

				<!-- Read more button -->
				<a class="btn btn-info btn-rounded btn-md"
					href="ManageMobilePhoneControllerServlet"> Manage </a>
			</div>
			<!-- Grid column -->
			<!-- Grid column -->
			<div class="col-lg-4 col-md-6 mb-md-0 mb-4">
				<!-- Featured image -->
				<div class="view overlay rounded z-depth-2 mb-4">
					<img style="width: 340px; height: 300px;"
						img-fluid" 
						src="Resources/manage-order.png"
						alt="Sample image"> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!-- Category -->
				<a href="#!" class="deep-orange-text">
					<h6 class="font-weight-bold mb-3">
						<i class="fas fa-graduation-cap pr-2"></i>
					</h6>
				</a>
				<!-- Post title -->
				<h4 class="font-weight-bold mb-3">Manage Orders</h4>
				<!-- Post data -->
				<p></p>
				<!-- Excerpt -->

				<!-- Read more button -->
				<a class="btn btn-info btn-rounded btn-md" href="ManageOrderControllerServlet">
					Manage </a>
			</div>
			<!-- Grid column -->
			<!-- Grid column -->
			<div class="col-lg-4 col-md-6 mb-0">
				<!-- Featured image -->
				<div class="view overlay rounded z-depth-2 mb-4">
					<img style="width: 340px; height: 300px;"
						src="Resources/manage-account.png" alt="Sample image"> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!-- Category -->
				<a href="#!" class="blue-text">
					<h6 class="font-weight-bold mb-3">
						<i class="fas fa-fire pr-2"></i>
					</h6>
				</a>
				<!-- Post title -->
				<h4 class="font-weight-bold mb-3">Manage Customer Accounts</h4>
				<!-- Post data -->
				<p></p>
				<!-- Excerpt -->
				<!-- Read more button -->
				<a class="btn btn-info btn-rounded btn-md" href="#"> Manage </a>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->
	</section>
</body>
</html>