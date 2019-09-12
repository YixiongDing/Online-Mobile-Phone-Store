<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.MobilePhone"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<title>Update Mobile Phone</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' href='style.css' />
</head>
<h1 class="h1-responsive font-weight-bold text-center my-5">Online
	Mobile Phone Store Management System</h1>
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
	<a href="ManageMobilePhoneServlet" class="blue-text">
		<h6 class="font-weight-bold mb-3" style="font-size: 20px;">
			<i class="fas fa-fire pr-2"><- Manage Mobile Phones </i>
		</h6>
	</a>
	<section class="container text-center">
		<h2 style="margin-bottom: 20px;">Update Mobile Phone Information</h2>

		<form action="UpdateMobilePhoneInfoServlet" method="post"
			style="margin-left: auto; margin-right: auto; width: 20%;">
			<div class="form-group">
				<label for="exampleFormControlInput1" style="font-size: 15px">Id</label>
				<input readonly name="id" class="form-control"
					id="exampleFormControlInput1" style="text-align: center;"
					<%out.println("value=\"" + mobile.getMobilePhoneId() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Model
					Name</label> <input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="modelName" required
					<%out.println("value=\"" + mobile.getModelName() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Storage
					Size</label> <input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="storageSize" required
					<%out.println("value=\"" + mobile.getStorageSize() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Color</label>
				<input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="color" required
					<%out.println("value=\"" + mobile.getColor() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Brand</label>
				<input style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="brand" required
					<%out.println("value=\"" + mobile.getBrand() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Price</label>
				<input style="text-align: center;" class="form-control"
					type="number" id="exampleFormControlinput1" name="price" required
					<%out.println("value=\"" + mobile.getPrice() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Quantity</label>
				<input style="text-align: center;" class="form-control"
					type="number" id="exampleFormControlinput1" name="qty" required
					<%out.println("value=\"" + mobile.getQty() + "\"");%>></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style="font-size: 15px">Description</label>
				<textarea style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="description" rows="5">
					<%
						out.println(mobile.getDescription());
					%>
				</textarea>
			</div>
			<footer>
				<button type="submit" name="button" value="submit"
					class="btn btn-primary">Submit</button>
			</footer>
		</form>
	</section>
</body>
</html>