<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Regis</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<form:form
		class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin"
		method="post" action="/EmployeeReimbursementSystem/editUserDetails" modelAttribute="uploadImage" enctype="multipart/form-data" >
		<h2 class="w3-center">Edit  Registration Form 
		${saved}
		</h2>

		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="empId" class="w3-input w3-border" 
					 placeholder="Enter empId" required="true" />
			</div>
		</div>

		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="role" class="w3-input w3-border" 
					 placeholder="Enter role"   required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="password" class="w3-input w3-border" 
					 placeholder="Enter password"  required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="designation" class="w3-input w3-border" 
					 placeholder="Enter designation"  required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="firstName" class="w3-input w3-border" 
					 placeholder="Enter first name"  required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="lastName" class="w3-input w3-border" 
					 placeholder="Enter lastName"  required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="gender" class="w3-input w3-border" 
					 placeholder="Enter gender"  required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input path="mobileNo" class="w3-input w3-border" 
					 placeholder="Enter mobile no"  required="true"/>
			</div>
		</div>
		
		<div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-user"></i>
			</div>
			<div class="w3-rest">
				<form:input   path="email" class="w3-input w3-border"
					 placeholder="Enter email"  required="true"/>
			</div>
		</div>

	 <div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-envelope-o"></i>
			</div>
			<div class="w3-rest">
				<form:input  path="currentAddress" class="w3-input w3-border" 
					placeholder="enter address"  required="true" />
			</div>
		</div> 

 <div class="w3-row w3-section">
			<div class="w3-col" style="width: 50px">
				<i class="w3-xxlarge fa fa-envelope-o"></i>
			</div>
			<div class="w3-rest">
				<form:input  type="file" path="uploadfile" class="w3-input w3-border" 
					placeholder="Upload File"  required="true" />
			</div>
		</div> 

		<p class="w3-center">
			<input type="submit" class="w3-button w3-section w3-blue w3-ripple"
				value="Save Details ">
		</p>
	</form:form>


</body>
</html>