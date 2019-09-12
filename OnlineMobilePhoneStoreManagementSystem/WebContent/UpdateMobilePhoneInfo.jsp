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
		<form action="UpdateMobilePhoneInfoServlet" method="post">
			<div class="form-group">
				<label for="exampleFormControlInput1" style=" font-size: 25px">Id</label> <input readonly
					name="id" class="form-control" id="exampleFormControlInput1"
					style="text-align: center;"
					<%out.println("value="+mobile.getMobileId()); %>>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style=" font-size: 25px">Model</label> <input
					style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="model"
					<%out.println("value="+mobile.getModel()); %> rows="1"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1"style=" font-size: 25px" >Brand</label> <input
					style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="brand"
					<%out.println("value="+mobile.getBrand()); %> rows="1"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1"style=" font-size: 25px" >Price</label> <input
					style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="price"
					<%out.println("value="+mobile.getPrice()); %> rows="1"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1"style=" font-size: 25px" >Quantity</label> <input
					style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="qty"
					<%out.println("value="+mobile.getQty()); %> rows="1"></input>
			</div>
			<div class="form-group">
				<label for="exampleFormControlinput1" style=" font-size: 25px" >Description</label> <input
					style="text-align: center;" class="form-control"
					id="exampleFormControlinput1" name="description"
					<%out.println("value="+mobile.getDescription()); %> rows="3"></input>
			</div>
			<footer>
				<button type="submit" name="button" value="submit" class="btn btn-primary">Submit</button>
				<button type="submit" name="button" value="cancel" class="btn btn-primary">Cancel</button>
			</footer>
		</form>
	</section>
</body>
</html>