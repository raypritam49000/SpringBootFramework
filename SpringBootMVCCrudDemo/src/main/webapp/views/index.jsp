<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User Page</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row">
		 <div class="col-md-8 offset-2 mt-3">
		 <h1 class="text-center">Add User</h1>
		  <form class="form-group" action="addLogic" method="post">
		   <label for="name">Enter Your Name</label>
		   <input class="form-control" id="name" name="name" placeholder="Enter Here" required="required">
		   
		   <label for="city">Enter Your City</label>
		   <input class="form-control" id="city" name="city" placeholder="Enter Here" required="required">
		   
		   <label for="mobile">Enter Your Mobile</label>
		   <input class="form-control" id="mobile" name="mobile" placeholder="Enter Here" required="required">
		   
		   <div class="container mt-2 text-center">
		    <button class="btn btn-outline-success" type="submit">Add</button>
		    <button class="btn btn-outline-primary" type="reset">Reset</button>
		   </div>
		  </form>
		 </div>
		</div>
	</div>
</body>
</html>