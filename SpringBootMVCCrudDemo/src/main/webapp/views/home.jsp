<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">City</th>
					<th scope="col">Mobile</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<th scope="row">${user.id}</th>
						<td>${user.name}</td>
						<td>${user.city}</td>
						<td>${user.mobile}</td>
						
						<td>
							<a href="delete/${user.id}"><i class="fas fa-trash-alt text-danger" style="font-size: 20px"></i></a>
							<a href="update/${user.id}"><i class="fas fa-pen-nib text-primary" style="font-size: 20px"></i></a>
					    </td>
					</tr>
			</c:forEach>
        </tbody>
	</table>
	
	<div class="container text-center"><a href="addUser" class="btn btn-outline-success">ADD USER</a></div>
	</div>
</body>
</html>