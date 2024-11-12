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
     
       <form action="insert" method="post">
        <caption>
         <h2>Add User Data </h2>
        </caption>
        <fieldset class="form-group">
         <label>User Name</label>
         <input type="text" class="form-control" name="name" required />
        </fieldset>
        
          <fieldset class="form-group">
         <label>User Email</label>
         <input type="email" class="form-control" name="email" required />
        </fieldset>
        
          <fieldset class="form-group">
         <label>Country</label>
         <input type="text" class="form-control" name="country" required />
         </fieldset>
         
           <fieldset class="form-group">
         <label>Password</label>
         <input type="password" class="form-control" name="password" required />
         </fieldset>
        
        <button type="submit" class="btn btn-success" >Save</button>
       </form>
     </div>
   </div>
  </div>
</body>
</html>