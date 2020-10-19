<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="resources/css/loginStyle.css" rel="stylesheet"
	type="text/css">

</head>
<body>

	<div class="w3-container">

		<div class="w3-container w3-half w3-card-4 w3-display-middle">
			<form:form action="login" method="post" modelAttribute="usercreds">
				<div class="w3-center">
				 <img src="resources/images/real logo.png" alt="Avatar"
						style="width: 30%" class="w3-circle ">
				</div>


				<div class="w3-section">

					<form:input class="w3-input w3-half " type="text" path="empId"
						placeholder="Enter Username" style="width:100%" />


					<form:input class="w3-input w3-half " type="password" path="password"
						placeholder="Enter Password" style="width:100%" />
					<button class="w3-button w3-block w3-green w3-section w3-padding w3-half w3-display-middle"
						type="submit">Login</button>
					<input class="w3-check w3-margin-top" type="checkbox"
						checked="checked"> Remember me <span
						class="w3-right w3-padding w3-hide-small">Forgot <a
						href="#">password?</a></span>
				</div>
			</form:form>
<form:form method="post" action="forgetPassword" >
<input type="submit" class="w3-submit w3-display-middle" value="forget Password">
</form:form>
</div>
		</div>
	

</body>
</html>