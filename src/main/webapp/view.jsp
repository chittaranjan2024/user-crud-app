<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-body">


				<h2>View User Data</h2>
				<div class="card">
					<div class="card-header">User Detail</div>
					<div class="card-body">
						<h5 class="card-title">Id</h5>
						<p class="card-text"><c:out value="${user.id}"/></p>
						
						<h5 class="card-title">Name</h5>
						<p class="card-text"><c:out value="${user.name}"/></p>
						
						<h5 class="card-title">Email</h5>
						<p class="card-text"><c:out value="${user.email}"/></p>
						
						<h5 class="card-title">Country</h5>
						<p class="card-text"><c:out value="${user.name}"/></p>
						<a href="list" class="btn btn-primary">Go to userlist</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>