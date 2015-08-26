<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../static/base/style.jsp"/>
<title>Add new comic</title>
</head>
<body>
    <form role="form" method="POST" action='ComicsController' name="formAddComic">
    <div class="form-group">
    	<label for="name">Name:</label>
    	<input type="text" class="form-control" id="name" value="<c:out value="${comic.getC().name}" />" name="name">
  	</div>
    <br />
    <div class="form-group">
    	<label for="Type">Type:</label>
    	<input type="text" class="form-control" id="Type" value="<c:out value="${comic.getC().getType().name}" />" name="Type">
  	</div>
  	<button type="submit" class="btn btn-primary">Submit</button>
    </form>
<jsp:include page="../../static/base/scripts.jsp"/>
</body>
</html>