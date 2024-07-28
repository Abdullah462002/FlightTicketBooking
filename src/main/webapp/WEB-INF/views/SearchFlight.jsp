<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<h4>Flight Details</h4>
		<h4>Customer ID: ${sessionScope.cid}</h4>
		<c:if test="${fn:length(flightli) > 0}">
		<table class="table table-success table-striped">
			<tr class="table-dark">
				<th>Flight Id</th>
				<th>Departure Airport</th>
				<th>Destination Airport</th>
				<th>Departure Date</th>
				<th>Departure time</th>
				<th>Seats to be booked</th>
				<th>Airline Name</th>
				<th>Book</th>
			</tr>
			
			<c:forEach items="${flightli}" var="e">

				<tr>
					<form:form action="bookfli" method="post"
						modelAttribute="flightsearch">
						<td><form:input path="flightid" class="form-control"
								value="${e.getFlightid()}" readonly="true" /></td>
						<td><form:input path="from" class="form-control"
								value="${e.getFrom()}" readonly="true" /></td>
						<td><form:input path="to" class="form-control"
								value="${e.getTo()}" readonly="true" /></td>
						<td><form:input path="date" class="form-control"
								value="${e.getDate()}" readonly="true" /></td>
						<td><form:input path="time" class="form-control"
								value="${e.getTime()}" readonly="true" /></td>
						<td><form:input path="seat" class="form-control"
								value="${e.getSeat()}"  /></td>
						<td><form:input path="airlineName" class="form-control"
								value="${e.getAirlineName()}" readonly="true" /></td>
						<td><input type="submit" value="Book"
							class="btn btn-primary btn btn sm"></td>
					</form:form>
				</tr>

			</c:forEach>
		</table>
		</c:if>
		<h3 class="text">${fai}</h3>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>