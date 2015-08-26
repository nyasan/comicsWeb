<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="css/bootstrap.css"/>" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Login</title>
</head>
<body>
	<form role="form" method="POST" action='UsersController' name="formLogin">
    <div class="form-group">
    	<label for="username">Username:</label>
    	<input type="text" class="form-control" id="username" name="username">
  	</div>
    <br />
    <div class="form-group">
    	<label for="password">Password:</label>
    	<input type="password" class="form-control" id="password" name="password">
  	</div>
  	<button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>