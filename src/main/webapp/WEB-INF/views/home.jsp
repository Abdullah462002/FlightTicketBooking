<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="org.springframework.web.servlet.ModelAndView
"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<%
if(session.getAttribute("name")==null){
	 System.out.println(session.getAttribute("name"));
	response.sendRedirect("login");
	return;
}
%>
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Ticket Booking</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarText"
						aria-controls="navbarText" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarText">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="home">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="register">Register
									Customer</a></li>
							<li class="nav-item"><a class="nav-link" href="edit">Edit
									Customer Profile</a></li>
							<li class="nav-item"><a class="nav-link" href="searnbook">Searching
									and Booking</a></li>
							<li class="nav-item"><a class="nav-link" href="cancel">Cancellation</a>
							</li>
						</ul>
						<span class="navbar-text"> <a href="logout"><input
								type="button" value="logout" class="btn btn-danger" /></a></span>
					</div>
				</div>
			</nav>
			<c:choose>
				<c:when test="${page eq 'hom'}">
					<div style="display: flex; margin: 2%">
						<div
							style="width: 40%; display: flex; flex-direction: column; margin: 5% 0 0 5%;">
							<h1>Find Your Next Destination</h1>
							<p style="margin-left: 5px;">Book Your Tickets Easily</p>
							<a href="searnbook"><input type="button" value="Book Now"
								class="btn btn-danger" /></a>
						</div>
						<img src="../../flightTicketBooking.svg" alt="home" />
					</div>
				</c:when>
				<c:when test="${page eq 'regis'}">
					<c:import url="register.jsp" />
				</c:when>
				<c:when test="${page eq 'edit'}">
					<h3>Edit Page</h3>
					<h4 class="text text-success">${suc}</h4>
					<h4 class="text text-danger">${fai}</h4>
					<table class="table">
						<form:form action="update" method="post"
							modelAttribute="userDetails">
							<tr>
								<th>Name</th>
								<th>Value</th>
							</tr>
							<tr>
								<td>Customer ID</td>
								<td><form:input path="cId" class="form-control"
										value="${cust.getcId()}" readonly="true" /></td>
							</tr>
							<tr>
								<td>Customer Name</td>
								<td><form:input path="name" class="form-control"
										value="${cust.getName()}" /> <form:errors path="name"
										class="text text-danger" /></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><form:input path="email" class="form-control"
										value="${cust.getEmail()}" /> <form:errors path="email"
										class="text text-danger" /></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><form:input path="password" class="form-control"
										value="${cust.getPassword()}" /> <form:errors path="password"
										class="text text-danger" /></td>
							</tr>
							<tr>
								<td>Date Of Birth</td>
								<td><form:input path="dateOfBirth" class="form-control"
										value="${cust.getDateOfBirth()}" /> <form:errors
										path="dateOfBirth" class="text text-danger" /></td>
							</tr>
							<tr>
								<td>Phone no</td>
								<td><form:input path="phone" class="form-control"
										value="${cust.getPhone()}" /> <form:errors path="phone"
										class="text text-danger" /></td>
							</tr>
							<tr>
								<td>Address</td>
								<td><form:input path="address" class="form-control"
										value="${cust.getAddress()}" /> <form:errors path="address"
										class="text text-danger" /></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><form:input path="gender" class="form-control"
										value="${cust.getGender()}" /> <form:errors path="gender"
										class="text text-danger" /></td>
							</tr>
							<tr>
								<td>SSN Number</td>
								<td><form:input path="SSNNumber" class="form-control"
										value="${cust.getSsnNumber()}" /> <form:errors
										path="SSNNumber" class="text text-danger" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Save"
									class="btn btn-primary"></td>
							</tr>
						</form:form>
					</table>
				</c:when>
				<c:when test="${page eq 'snb'}">
					<c:import url="booking.jsp" />
				</c:when>
				<c:when test="${page eq 'cancel'}">
					<c:import url="cancellation.jsp" />
				</c:when>
				<c:when test="${page eq 'editmsg'}">
					<c:import url="details.jsp" />
				</c:when>
			</c:choose>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>