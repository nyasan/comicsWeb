<%@ page isErrorPage="true" import="java.io.*" language="java"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../static/base/style.jsp" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="error-template">
					<h1>Oops!</h1>
					<h2>500 Internal Server Error</h2>
					<div class="error-details">Sorry, an error has occured, I
						cant do what u want to do for many reasons...</div>
					<div class="error-actions">
						<a href="/ComicsWebProject/welcome.jsp"
							class="btn btn-primary btn-lg"><span
							class="glyphicon glyphicon-home"></span> Take Me Home </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>