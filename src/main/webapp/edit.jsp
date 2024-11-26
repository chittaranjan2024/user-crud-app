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

        <form action="update" method="post">
        <caption>
         <h2>Edit User Data </h2>
        </caption>
         <fieldset class="form-group">
         <label>User Id</label>
         <input type="number" class="form-control" name="id" value="${user.id}" required readonly/>
        </fieldset>
        <fieldset class="form-group">
         <label>User Name</label>
         <input type="text" class="form-control" name="name" value="${user.name}" required />
        </fieldset>
        
          <fieldset class="form-group">
         <label>User Email</label>
         <input type="email" class="form-control" name="email" value="${user.email}" required />
        </fieldset>
        
          <fieldset class="form-group">
         <label>Country</label>
         <input type="text" class="form-control" name="country" value="${user.country}" required />
         </fieldset>
        
        
        <button type="submit" class="btn btn-success" >Update</button>
       </form>
     </div>
   </div>
  </div>
</body>
</html>