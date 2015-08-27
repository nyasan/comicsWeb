<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../static/base/style.jsp" />
<title>Create new Loan</title>
</head>
<body>
	<section id="adding">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Loan</h2>
				<h3 class="section-subheading text-muted">Completes the data
					below to create a new loan</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form name="formAddLoan" id="loanForm" novalidate role="form"
					method="POST" action='LoansController'>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="comicList">Comic:</label>
								<select id="comicList" name="name" class="form-control" required
									data-validation-required-message="Please select a comic.">
								<c:forEach items="${comics}" var="comic">
  									<option value="<c:out value="${comic.getC().name}" />"><c:out value="${comic.getC().name}" /></option>
  								</c:forEach>
								</select>
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<label for="personList">Person:</label>
								<select id="personList" name="person" class="form-control" required
									data-validation-required-message="Please select a person.">
								<c:forEach items="${persons}" var="person">
  									<option value="<c:out value="${person.name}" />"><c:out value="${person.name}" /></option>
  								</c:forEach>
								</select>
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