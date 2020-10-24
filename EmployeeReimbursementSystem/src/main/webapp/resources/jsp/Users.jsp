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

</head>
<body>
	<div class="w3-container w3-black">
		<div class="icon_img">
			<img src="resources/images/realcoderzicon.gif" alt="logo"
				style="height: 10%; width: 10%">
		</div>
	</div>

	<div class="w3-sidebar w3-bar-block  w3-card w3-animate-left"
		style="display: none" id="mySideBar">
		<button class="w3-bar-item w3-button w3-hide-large"
			onclick="w3_close()">Close &times;</button>
		<a href="#" class="w3-bar-item w3-button">Home</a> <a href="#"
			class="w3-bar-item w3-button">Users</a> <a href="#"
			class="w3-bar-item w3-button">Ticket Generation</a>
	</div>

	<div id="main">
		<div class="w3-teal">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
</div>
	</div>

	<script>
		function w3_open() {
			document.getElementById("main").style.marginLeft="25%";
			document.getElementById("mySidebar").style.width = "25%";
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("openNav").style.display = "none";
		}

		function w3_close() {
			  document.getElementById("main").style.marginLeft = "0%";
			  document.getElementById("mySidebar").style.display = "none";
			  document.getElementById("openNav").style.display = "inline-block";
		}
	</script>
</body>
</html>