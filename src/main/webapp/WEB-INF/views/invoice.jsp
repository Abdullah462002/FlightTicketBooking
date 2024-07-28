<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h3>Booking Invoice</h3>
		<h4>${suc}</h4>
		<h3 class="text text-warning">*Please Note Your Booking ID</h3>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Value</th>
			</tr>
			<tr>
				<th>Booking ID</th>
				<th>${invli.getBookingId()}</th>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td>${invli.getCustomerName()}</td>
			</tr>
			<tr>
				<td>Airline Name</td>
				<td>${invli.getAirlineName()}</td>
			</tr>
			<tr>
				<td>Leaving from</td>
				<td>${invli.getLeavingfrom()}</td>
			</tr>
			<tr>
				<td>Going To</td>
				<td>${invli.getGoingTo()}</td>
			</tr>
			<tr>
				<td>Date Of Journey</td>
				<td>${invli.getDateOfJourney()}</td>
			</tr>
			<tr>
				<td>Departure Time</td>
				<td>${invli.getDepartureTime()}</td>
			</tr>
			<tr>
				<td>Booking Date</td>
				<td>${invli.getBookingDate()}</td>
			</tr>
			<tr>
				<td>Total Price</td>
				<td>${invli.getTotalPrice()}</td>
			</tr>
			<tr>
				<td>Seats to book</td>
				<td>${invli.getSeatstobook()}</td>
			</tr>
		</table>
		<h3>Press Ctrl+P for download Invoice</h3>
		<a class="link-opacity-90" href="home"><input type="button"
			value="Home" class="btn btn-danger" /></a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>