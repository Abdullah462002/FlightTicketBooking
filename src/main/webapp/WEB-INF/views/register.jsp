<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
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
Random rand = new Random();
int n = rand.nextInt(90000);
%>
	<div class="container">
		<h1>Register Page</h1>
		<h3 class="text text-primary">${suc}</h3>
		<h3 class="text text-danger">${fai}</h3>
		<form:form action="registerCus" method="post"
			modelAttribute="userDetails">
			<form:input path="cId" type="hidden" value="<%=n%>" />
			<form:input path="name" placeholder="Name" class="form-control" />
			<br><form:errors path="name" class="text text-danger"/>
			<form:input path="email" placeholder="E-mail" class="form-control"
				type="text" /><form:errors path="email" class="text text-danger"/>
			<br>
			<form:input path="password" placeholder="Enter Password"
				class="form-control" /><form:errors path="password" class="text text-danger"/>
			<br>
			<form:input path="reTypePassword" placeholder="Re-Enter Password"
				class="form-control" /><form:errors path="reTypePassword" class="text text-danger"/>
			<br>
			<form:input path="dateOfBirth" placeholder="Enter Date Of Birth"
				class="form-control" type="date" /><form:errors path="dateOfBirth" class="text text-danger"/>
			<br>
			<form:input path="address" placeholder="Enter Address"
				class="form-control" /><form:errors path="address" class="text text-danger"/>
			<br>
			<form:select path="gender" class="form-control">
				<form:option value="Male">Male</form:option>
				<form:option value="female">Female</form:option>
			</form:select><form:errors path="gender" class="text text-danger"/>
			<br>
			<form:input path="phone" placeholder="Enter Phone No."
				class="form-control" type="text" /><form:errors path="phone" class="text text-danger"/>
			<br>
			<form:input path="sSNType" placeholder="Enter SSN Type"
				class="form-control" type="text" /><form:errors path="sSNType" class="text text-danger"/>
			<br>
			<form:input path="sSNNumber" placeholder="Enter SSN Number"
				class="form-control" /><form:errors path="sSNNumber" class="text text-danger"/>
			<br>
			<div>
				<input type="submit" value="Register"
					class="btn btn-primary btn btn sm"> <input type="reset"
					value="Clear" class="btn btn-danger btn btn sm">
			</div>
		</form:form>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>