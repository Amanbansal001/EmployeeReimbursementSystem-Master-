<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Users !!!!</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="w3-container w3-black">
		<div class="icon_img">
			<img src="resources/images/realcoderzicon.gif" alt="logo"
				style="height: 10%; width: 10%">
		</div>
	</div>

	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left w3-teal"
		style="display: none" id="mySideBar">
	    <button class="w3-bar-item w3-button w3-large"
        onclick="w3_close()">Close</button>
         <a href="#" class="w3-bar-item w3-button">Home</a>
        <a href="#" class="w3-bar-item w3-button">Users</a>
        <a href="#" class="w3-bar-item w3-button">Create Ticket</a>
        <a href="#" class="w3-bar-item w3-button">Settings</a>
        <a href="logout" class="w3-bar-item w3-button">Logout</a>
      </div>
      

	<div id="main">
		<div class="w3-teal">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
</div>
</div>

<h1 class="w3-center ">Users List</h1>
<h1 class="w3-center"><a class="w3-button w3-section w3-teal w3-ripple w3-margin-left" href="addUserRegis">Add User</a></h1>

<h1>${notFound}</h1>

<c:forEach var="val" items="${userImage}">
<div class="w3-container w3-card-4 w3-margin-left w3-margin-top w3-half">
	<a href="userProfile/${val.empId}"><img   class="w3-circle"  src="data:image/jpeg;base64,${val.imageDisplay}" 
							style="width: 10% ">
						</a>	
Name : ${val.firstName}${val.lastName}		 <a class="w3-button w3-section w3-teal w3-ripple w3-margin-left" href="editUser/${val.empId}">Edit</a>	
<p>					
EmpID : ${val.empId }	 	
<p>
Designation : ${val.designation}			
	
	</div>
	</c:forEach>
	<script>
	 function w3_open() {
         document.getElementById("main").style.marginLeft = "20%";
         document.getElementById("mySideBar").style.width = "20%";
         document.getElementById("mySideBar").style.display = "block";
         document.getElementById("openNav").style.display = 'none';
       }
       function w3_close() {
         document.getElementById("main").style.marginLeft = "0%";
         document.getElementById("mySideBar").style.display = "none";
         document.getElementById("openNav").style.display = "inline-block";
       }
	</script>
</body>
</html>