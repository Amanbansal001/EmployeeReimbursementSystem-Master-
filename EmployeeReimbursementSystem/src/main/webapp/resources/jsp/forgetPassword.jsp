<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container  ">

		<div
			class="w3-container w3-card-4  w3-margin-left w3-margin-top w3-display-middle ">
			<p>
			<div class="w3-center">
				<form:form action="sendEmail" method="post" modelAttribute="forgetPassword">
					<div class="w3-center">
						<img src="resources/images/real logo.png" alt="logo"
							style="width: 40%">
						<p>
					   ${notFound }
					   <p>
							<form:input class="w3-input w3-half " type="password"
								path="empId" placeholder="Enter EmpID" style="width:100%"
								 />
						<p>
							<input type="submit"
								class="w3-button w3-section w3-teal w3-ripple w3-margin-left "
								value="Send"> 
						<p>
				</form:form>

			</div>

		</div>

	</div>
</body>
</html>