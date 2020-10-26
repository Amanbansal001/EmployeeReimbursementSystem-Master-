<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login New</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div class="w3-container  ">

		<div
			class="w3-container w3-card-4  w3-margin-left w3-margin-top w3-display-middle ">
			<p>
			<div class="w3-center">
				<form:form action="login" method="post" modelAttribute="usercreds">
						<img src="resources/images/real logo.png" alt="logo"
							style="width: 40%">
						
						<p>
							${notFound }
							<form:input class="w3-input w3-half " type="text" path="empId"
								placeholder="Enter Username" style="width:100%" />
						<p>
							<form:input class="w3-input w3-half " type="password"
								path="password" placeholder="Enter Password" style="width:100%"
								id="myInput" />
							<span class="eye" onClick="myFunction()"> 
								<i id="hide2" class="fa fa-eye-slash"></i>
							</span>
						<p>
							<input type="submit"
								class="w3-button w3-section w3-teal w3-ripple w3-margin-left "
								value="Login"> <br> <input id="milk"
								class="w3-check w3-margin-left " type="checkbox"
								checked="checked"> <label>Remember Me</label> <a
								href="forgetPassword"
								class="w3-button w3-section w3-teal w3-ripple w3-margin-left ">Forget
								Password</a>
						<p>
				</form:form>

			</div>

		</div>

	</div>
	<script>
function myFunction(){
	var x= document.getElementById("myInput");
	var y= document.getElementById("hide1");
	var z= document.getElementById("hide2");
	if(x.type === 'password')
		{
		x.type="text";
		y.style.display = "block";
		z.style.display = "none";
		
		}
	else
		{
		x.type="password";
		y.style.display = "none";
		z.style.display = "block";
		
		}	
}
</script>
</body>
</html>