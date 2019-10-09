<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li class="nav-item"><a class="nav-link" href="HomePageServlet">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ViewMobilePhonesServlet">All Mobile Phones</a></li>
		</ul>
	</div>
</nav>
<body>
	<section class="container text-center">
		<h2 style="margin-bottom: 20px;">Register Account</h2>
		<form action="RegisterNewAccountServlet" method="post"
			style="margin-left: auto; margin-right: auto; width: 20%;">
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Full
					Name</label> <input style="text-align: center;" class="form-control"
					required id="exampleFormControlinput1" name="fullName"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Email
					Address </label> <input style="text-align: center;" class="form-control"
					type="email" required id="exampleFormControlinput1"
					name="emailAddress"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Post
					Address</label> <input style="text-align: center;" class="form-control"
					required id="exampleFormControlinput1" name="postAddress"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Password</label>
				<input style="text-align: center;" class="form-control" required
					type="password" id="exampleFormControlinput1" name="password"></input>
			</div>
			<footer>
				<button type="submit" name="button" value="submit"
					class="btn btn-primary">Register</button>
			</footer>
		</form>
	</section>
</body>
</html>