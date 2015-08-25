<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link href="<c:url value="css/bootstrap.css"/>" rel="stylesheet">
	<link href="<c:url value="css/bootstrap-theme.css"/>" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new comic</title>
</head>
<body>
    <form role="form" method="POST" action='ComicsController' name="formAddComic">
    <div class="form-group">
    	<label for="name">Name:</label>
    	<input type="text" class="form-control" id="name" value="<c:out value="${comic.name}" />" name="name">
  	</div>
    <br />
    <div class="form-group">
    	<label for="Type">Type:</label>
    	<input type="text" class="form-control" id="Type" value="<c:out value="${comic.Type}" />" name="Type">
  	</div>
  	<button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>