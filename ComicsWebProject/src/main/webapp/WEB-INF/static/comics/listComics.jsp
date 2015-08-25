<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Comics</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${comics}" var="comic">
                <tr>
                    <td><c:out value="${comic.name}" /></td>
                    <td><c:out value="${comic.Type}" /></td>
                    <td><a href="ComicsController?action=edit&name=<c:out value="${comic.name}"/>">Update</a></td>
                    <td><a href="ComicsController?action=delete&name=<c:out value="${comic.name}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ComicsController?action=insert">Add Comic</a></p>
</body>
</html>