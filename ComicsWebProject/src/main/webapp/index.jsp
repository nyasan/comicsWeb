<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" errorPage="static/exceptions/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="static/base/style.jsp" />
<title>Show All Comics</title>
</head>
<body id="page-top" class="index">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top">Sheldon
				Store</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a></li>
				<li><a class="page-scroll" href="#add">ABM</a></li>
				<li><a class="page-scroll" href="#listComics">Comic List</a></li>
				<li><a class="page-scroll" href="#listPersons">Person List</a>
				</li>
				<li><a class="page-scroll" href="#listLoans">Loan List</a></li>
				<li><a class="page-scroll" href="UsersController?action=logout">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- Header -->
	<header>
	<div class="container">
		<div class="intro-text">
			<div class="intro-lead-in">Welcome To Our Store!</div>
			<div class="intro-heading">It's Nice To Meet You</div>
			<a href="UsersController?action=login" class="page-scroll btn btn-xl">Login</a>
		</div>
	</div>
	</header>

	<!-- Add Section -->
	<section id="add" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">ABM</h2>
				<h3 class="section-subheading text-muted">This section is for
					your transactions</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a href="PersonsController?action=insert" class="portfolio-link">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fa fa-plus fa-3x"></i>
						</div>
					</div> <img src="img/abm/add-persons-min.jpg" class="img-responsive"
					alt="">
				</a>
				<div class="portfolio-caption">
					<h4>Add Person</h4>
					<p class="text-muted">Person</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a href="ComicsController?action=insert" class="portfolio-link">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fa fa-plus fa-3x"></i>
						</div>
					</div> <img src="img/abm/add-comics-min.jpg" class="img-responsive"
					alt="">
				</a>
				<div class="portfolio-caption">
					<h4>Add Comic</h4>
					<p class="text-muted">Comic</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a href="LoansController?action=insert" class="portfolio-link">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fa fa-plus fa-3x"></i>
						</div>
					</div> <img src="img/abm/add-loans-min.jpg" class="img-responsive" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>Add Loan</h4>
					<p class="text-muted">Loan</p>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- Comic List Section-->
	<section id="listComics">
	<div class="container">
		<h2>Comic List</h2>
		<p>This table shows the comics of my store:</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Genre</th>
					<th>Avalible</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comics}" var="comic">
					<tr>
						<td><c:out value="${comic.getC().name}" /></td>
						<td><c:out value="${comic.getC().getType().name}" /></td>
						<td><c:out value="${comic.isAvalible()}" /></td>
						<td><input class="btn btn-primary" id="update" name="update"
							type="button"
							onclick="location.href='ComicsController?action=edit&name=<c:out value="${comic.getC().name}"/>'"
							value="Update"></td>
						<td><input class="btn btn-primary" name="delete"
							type="button"
							onclick="location.href='ComicsController?action=delete&name=<c:out value="${comic.getC().name}"/>'"
							value="Delete"></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Name</th>
					<th>Genre</th>
					<th>Avalible</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</tfoot>
		</table>
	</div>
	</section>

	<!-- Person List Section-->
	<section id="listPersons" class="bg-light-gray">
	<div class="container">
		<h2>Persons List</h2>
		<p>This tables show what friends have the contact list:</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Adress</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${persons}" var="person">
					<tr>
						<td><c:out value="${person.name}" /></td>
						<td><c:out value="${person.telephone}" /></td>
						<td><c:out value="${person.adress}" /></td>
						<td><input class="btn btn-primary" id="update" name="update"
							type="button"
							onclick="location.href='PersonsController?action=edit&name=<c:out value="${person.name}"/>'"
							value="Update"></td>
						<td><input class="btn btn-primary" name="delete"
							type="button"
							onclick="location.href='PersonsController?action=delete&name=<c:out value="${person.name}"/>'"
							value="Delete"></td>
					</tr>
				</c:forEach>
			<tfoot>
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Adress</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</tfoot>
			</tbody>
		</table>
	</div>
	</section>

	<!-- Loan List Section-->
	<section id="listLoans" class="bg-light-gray">
	<div class="container">
		<h2>Loan List</h2>
		<p>This tables show which friends has comics:</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Person</th>
					<th>Comic</th>
					<th>Date</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${loans}" var="loan">
					<tr>
						<td><c:out value="${loan.getPerson().name}" /></td>
						<td><c:out value="${loan.getComic().getC().name}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${loan.getDate().getTime()}" /></td>
						<td><input class="btn btn-primary" id="update" name="update"
							type="button"
							onclick="location.href='PersonsController?action=edit&name=<c:out value="${loan.date}"/>'"
							value="Update"></td>
						<td><input class="btn btn-primary" name="delete"
							type="button"
							onclick="location.href='PersonsController?action=delete&name=<c:out value="${loan.date}"/>'"
							value="Delete"></td>
					</tr>
				</c:forEach>
			<tfoot>
				<tr>
					<th>Person</th>
					<th>Comic</th>
					<th>Date</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</tfoot>
			</tbody>
		</table>
	</div>
	</section>
	<jsp:include page="static/base/footer.jsp" />
	<%
		Boolean allow = (Boolean) session.getAttribute("admin");
		if (allow!=null) {
	%>
	<script type="text/javascript">
		var update = document.getElementsByName("update");
		for (i = 0; i < update.length; i++) {
			document.getElementsByName("update")[i].disabled = false;
			document.getElementsByName("delete")[i].disabled = false;
		}
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		var update = document.getElementsByName("update");
		for (i = 0; i < update.length; i++) {
			document.getElementsByName("update")[i].setAttribute("disabled",
					true);
			document.getElementsByName("delete")[i].setAttribute("disabled",
					true);
		}
	</script>
	<%
		}
	%>

	<jsp:include page="static/base/scripts.jsp" />
</body>


</html>