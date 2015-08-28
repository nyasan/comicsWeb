<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../static/base/style.jsp" />
<link href="css/signin.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
<div class="container">
	<form role="form" method="POST" action='UsersController' name="formLogin form-signin">
	<h2 class="form-signin-heading">Please sign in</h2>
    <div class="form-group">
    	<label for="username">Username:</label>
    	<input placeholder="Username" type="text" class="form-control" id="username" name="username" required autofocus>
  	</div>
    <br />
    <div class="form-group">
    	<label for="password">Password:</label>
    	<input type="password" placeholder="Password" class="form-control" id="password" name="password" required>
  	</div>
  	<button type="submit" class="btn btn-lg btn-primary btn-block">Submit</button>
    </form>
    </div>
</body>
</html>