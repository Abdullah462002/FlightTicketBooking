<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
	<div class="container">
		<h1>Cancellation Page</h1>
		<form:form action="cancelfli" method="post" modelAttribute="booking">
			<form:input path="bookid" placeholder="Enter Booking Id"
				class="form-control" />
			<br>
			<input type="submit" value="Confirm Cancel"
				class="btn btn-warning btn btn sm">
		</form:form>
		<c:if test="${fn:length(cli) > 0}">
		<c:forEach items="${cli}" var="c">
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Value</th>
				</tr>
				<tr>
					<th>Booking ID</th>
					<th>${c.getBookingID()}</th>
				</tr>
				<tr>
					<td>Booking Date</td>
					<td>${c.getBookingDate()}</td>
				</tr>
				<tr>
					<td>Departure Date</td>
					<td>${c.getDepartureDate()}</td>
				</tr>
				<tr>
					<td>Leaving from</td>
					<td>${c.getLeavingFrom()}</td>
				</tr>
				<tr>
					<td>Going To</td>
					<td>${c.getGoingTo()}</td>
				</tr>
				<tr>
					<td>Seats to book</td>
					<td>${c.getSeatsToBook()}</td>
				</tr>
				<tr>
					<td>Total Price</td>
					<td>${c.getTotalPrice()}</td>
				</tr>
				<tr>
					<td>Cancellation charge</td>
					<td>${charg}</td>
				</tr>
				<tr>
					<td>Refundable amount</td>
					<td>${reamt}</td>
				</tr>
				<tr>
				<td><form:form action="delbook" method="post" modelAttribute="booking">
					<form:input path="bookid" value="${c.getBookingID()}" type="hidden"/>
					<input type="submit" value="Confirm" class="btn btn-danger btn btn sm">
				</form:form>
				</td>
				</tr>
			</table>
		</c:forEach>
		</c:if>
		<h3 class="text text-success">${suc}</h3>
		
		<h3 class="text text-warning">${fai}</h3>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>