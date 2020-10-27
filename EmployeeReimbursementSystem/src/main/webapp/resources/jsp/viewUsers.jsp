<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>View Users</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">
​
<!-- Top container -->
<div class="w3-bar w3-top w3-blue w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <span class="w3-bar-item w3-left">RealcoderZ</span>
  <!--=================Search Box=====================-->
  <div class="search-container w3-right w3-margin-right w3-padding" style="float:none" >
    <form action="#">
      <input type="text" placeholder="Search Employees" name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
  <!--================Search Box End======================-->
</div>
​
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="#" class="w3-circle w3-margin-right" style="width:46px">
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-home fa-fw"></i>  Home</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  Users</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-ticket fa-fw"></i>  Generate Ticket</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Settings</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i>  Logout</a>
   <br><br>
  </div>
</nav>
​
​
<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
​
<!-- !PAGE CONTENT! -->
​
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
​
<!-- End page content -->

​
<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");
​
// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");
​
// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}
​
// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>
​
</body>
</html>




