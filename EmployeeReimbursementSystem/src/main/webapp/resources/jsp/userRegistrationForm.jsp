<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Register User</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body class="w3-content" style="max-width: 60%">
<!-- First Grid: Logo & About -->
	<div class="w3-row w3-card w3-block">
		<div class="w3-half  w3-container w3-center" style="height: 800px">
			<img src="resources/images/chaandani.jpg"
				style="width: 100%; height: 100%; object-fit: cover;">
		</div>
		<!--form inputs-->
		<div class="w3-half w3-container" style="height: 600px">
			<div class="w3-container">
				<div class="w3-container w3-teal" style="width: 100%;">
					<h2>Register Employee</h2>
				</div>
				<form:form class="w3-container" action="saveUserDetails" modelAttribute="uploadImage"  enctype="multipart/form-data">
					<p>
						<form:input path="empId" class="w3-input"  placeholder="Employee id"/>
					<p>
						<form:select path="role" class="w3-select">
							<option value="" disabled selected>Role</option>
							<option value="Admin">Admin</option>
							<option value="User">Employee</option>
						</form:select>
					<p>
						<form:input class="w3-input" path="password" placeholder="Password"/>
					<p>
						<form:input  class="w3-input" path="designation" placeholder="Designation"/>
					<p>
						<form:input class="w3-input" path="firstName" type="text" placeholder="First Name"/>
					<p>
						<form:input class="w3-input" path="lastName" placeholder="last Name"/> 
					<p>
						Male : <form:radiobutton path="gender" value="Male"/>
						Female :<form:radiobutton path="gender" value="Female"/>
					</p>
					<form:input class="w3-input" path="mobileNo"  placeholder="Contact number"/>
					<p>
						<form:input class="w3-input" path="email" placeholder="Email"/>
					<p>
						<form:input class="w3-input" path="currentAddress" placeholder="Current Address"/>
					<p>
						<label>Display Picture</label> <form:input type="file"  path="uploadfile" />
						<br>
					<p>
						<input type="submit" class="w3-btn w3-blue" value="Save User">
					</p>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>