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
  
    <table class="table table-bordered">
      <thead>
       <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Email</th>
           <th>Country</th>
       </tr>
      </thead>
      
      <tbody>
      
         <c:forEach var="user" items="${listuser}">
         
           <tr>
            <td> <c:out value="${user.id}"/></td>
            <td> <c:out value="${user.name}"/></td>
            <td> <c:out value="${user.email}"/></td>
            <td> <c:out value="${user.country}"/></td>
           </tr>
          
         </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>