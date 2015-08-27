<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../static/base/style.jsp" />
<title>Add new Person</title>
</head>
<body>
	<section id="adding">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Person</h2>
				<h3 class="section-subheading text-muted">Completes the data
					below to create a new person</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form name="formAddPerson" id="personForm" novalidate role="form"
					method="POST" action='PersonsController'>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input name="name" type="text" class="form-control"
									placeholder="Name *" value="<c:out value="${person.name}" />"
									id="name" required
									data-validation-required-message="Please enter your name.">
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<input name="phone" type="tel" class="form-control"
									placeholder="Phone *"
									value="<c:out value="${person.telephone}" />" id="phone"
									required
									data-validation-required-message="Please enter your phone number.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea name="adress" class="form-control"
									placeholder="Your Adress *"
									value="<c:out value="${person.adress}" />" id="adress" required
									data-validation-required-message="Please enter an adress"></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="col-lg-12 text-center">
							<button type="submit" class="btn btn-xl">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="../../static/base/scripts.jsp" />
	<script src="js/validations.js"></script>
</body>
</html>