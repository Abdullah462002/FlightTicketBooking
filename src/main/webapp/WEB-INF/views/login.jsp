<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="../../login.css">
</head>
<body>
	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 ">
		<div class="card card0 border-0">
			<div class="row d-flex">
				<div class="col-lg-6">
					<div class="card1 pb-5">
						<div class="row">
							<img src="../../logo.jpg" alt="ABD" class="logo">
						</div>
						<div class="row px-3 justify-content-center mt-4 mb-5 border-line">
							<img src="https://i.imgur.com/uNGdWHi.png" alt="img" class="image">
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="card2 card border-0 px-4 py-5">
						<div class="row mb-4 px-3">
							<h6 class="mb-0 mr-4 mt-2">Sign in with</h6>
						</div>
						<div class="row px-3 mb-4">
							<div class="line"></div>
							<div class="line"></div>
						</div>
						<h4 class="text text-danger">${error}</h4>
						<h4 class="text text-danger">${err}</h4>
						<form:form action="validate" method="post" modelAttribute="user">
							<div class="row px-3">
								<label class="mb-1"><h6 class="mb-0 text-sm">User
										Name</h6></label>
								<form:input path="name" class="form-control"
									placeholder="Enter Username" />
								<form:errors path="name" class="text text-danger" />
							</div>
							<div class="row px-3">
								<label class="mb-1"><h6 class="mb-0 text-sm">Password</h6></label>
								<form:password path="password" class="form-control"
									placeholder="Enter Password" />
								<form:errors path="password" class="text text-danger" />
							</div>

							<div class="row mb-3 px-3">
								<button type="submit" class="btn btn-blue text-center">Login</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<div class="bg-blue py-4">
				<div class="row px-3">
					<small class="ml-4 ml-sm-5 mb-2">Copyright &copy; 2023. All
						rights reserved.</small>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>