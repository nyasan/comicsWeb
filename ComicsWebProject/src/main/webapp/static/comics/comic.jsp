<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" errorPage="../exceptions/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../static/base/style.jsp" />
<title>Add new comic</title>
</head>
<body>
	<section id="adding">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Comic</h2>
				<h3 class="section-subheading text-muted">Completes the data
					below to create a new comic</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form name="formAddComic" id="comicForm" novalidate role="form"
					method="POST" action='ComicsController'>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<input name="name" type="text" class="form-control"
									placeholder="Name *"
									value="<c:out value="${comic.getC().name}" />" id="name"
									required
									data-validation-required-message="Please enter the name.">
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<label for="genreList">Genre:</label>
								<select id="genreList" name="Type" class="form-control" required
									data-validation-required-message="Please select a genre.">
								<c:forEach items="${genres}" var="genre">
  									<option value="<c:out value="${genre.name}" />" <c:if test="${comic.getC().getType().name == genre.name}">selected="true"</c:if>><c:out value="${genre.name}" /></option>
  								</c:forEach>
								</select>
								<p class="help-block text-danger"></p>
							</div>
							
						</div>
						<div class="clearfix"></div>
						<div class="col-lg-12 text-center">
							<div id="success"></div>
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