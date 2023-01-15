<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="bootstrap.jsp" %>
</head>
<body>
<div class="container">
		<div class="row">
		 <div class="col-md-8 offset-2 mt-3">
		 <h1 class="text-center">Update User</h1>
		  <form class="form-group" action="${pageContext.request.contextPath}/addLogic" method="post">
		  
		   <label for="id">Enter Your Id</label>
		   <input class="form-control" id="id" name="id" value="${user.id}" placeholder="Enter Here" required="required" readonly="readonly">
		   
		   <label for="name">Enter Your Name</label>
		   <input class="form-control" id="name" name="name" value="${user.name}" placeholder="Enter Here" required="required">
		   
		   <label for="city">Enter Your City</label>
		   <input class="form-control" id="city" name="city" value="${user.city}" placeholder="Enter Here" required="required">
		   
		   <label for="mobile">Enter Your Mobile</label>
		   <input class="form-control" id="mobile" name="mobile" value="${user.mobile}" placeholder="Enter Here" required="required">
		   
		   <div class="container mt-2 text-center">
		    <button class="btn btn-outline-success" type="submit">Add</button>
		     <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
		   </div>
		   
		  </form>
		 </div>
		</div>
	</div>

</body>
</html>