<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/agency.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
				<li><a class="page-scroll" href="#addPerson">Person</a></li>
				<li><a class="page-scroll" href="#">Contact</a></li>
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
			<a href="UsersController?action=login"
				class="page-scroll btn btn-xl">Loginc</a>
		</div>
	</div>
	</header>

	<!-- Add Section -->
	<section id="add" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">ABM</h2>
				<h3 class="section-subheading text-muted">This section is for your transactions</h3>
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
					<td><a href="ComicsController?action=edit&name=<c:out value="${comic.getC().name}"/>">Update</a></td>
                    <td><a href="ComicsController?action=delete&name=<c:out value="${comic.getC().name}"/>">Delete</a></td>
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
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td><c:out value="${person.name}" /></td>
					<td><c:out value="${person.telephone}" /></td>
					<td><c:out value="${person.adress}" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</section>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/agency.js"></script>
</body>
</html>