<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Dashboard</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
  html,
  body,
  h1,
  h2,
  h3,
  h4,
  h5 {
    font-family: "Raleway", sans-serif
  }
</style>

<body class="w3-light-grey">
  <c:forEach var="getuserDetails" items="${userDetails}">
    <!-- Top container -->
    <div class="w3-bar w3-top w3-blue w3-large" style="z-index:4">
      <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
        onclick="w3_open();"><em class="fa fa-bars"></em></button>
      <span class="w3-bar-item w3-left">
        <div class="icon_img">
          <img src="resources/images/realcoderzicon.gif" alt="logo" style="height: 30px; width: 30px">
        </div>
      </span>
      <button class="w3-button w3-right"><em class="fa fa-info fa-fw"></em></button>
      <!--=================Search Box=====================-->
      <div class="search-container w3-right w3-margin-right w3-padding" style="float:none">
        <form action="#">
          <input type="text" placeholder="Search Employees" name="search">
          <button type="submit"><em class="fa fa-search"></em></button>
        </form>
      </div>
      <!--================Search Box End======================-->
    </div>

    <!-- Sidebar/menu -->
    <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
      <div class="w3-container w3-row w3-padding-large">
        <div class="w3-col s4 w3-padding">
          <img src="data:image/jpeg;base64,${getuserDetails.imageDisplay}" class="w3-circle w3-margin-right"
            style="width: 100px; height: 100px;" alt="Loggedin User image"><br><br>
          Name: ${getuserDetails.firstName}
          <!--Write name here!-->
        </div>
      </div>
      <hr>
      <div class="w3-container">
        <h5>Dashboard</h5>
      </div>
      <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
          onclick="w3_close()" title="close menu"><em class="fa fa-remove fa-fw"></em>  Close Menu</a>
        <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><em class="fa fa-home fa-fw"></em>  Home</a>
        <a href="generateticket" class="w3-bar-item w3-button w3-padding"><em class="fa fa-ticket fa-fw"></em>  Generate
          Ticket</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><em class="fa fa-cog fa-fw"></em>  Settings</a>
        <a href="logout" class="w3-bar-item w3-button w3-padding"><em class="fa fa-sign-out fa-fw"></em>  Logout</a>
        <br><br>
      </div>
    </nav>
  </c:forEach>

  <!-- Overlay effect when opening sidebar on small screens -->
  <div iclass="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer"
    title="close side menu" id="myOverlay">
  </div>

  <!-- !PAGE CONTENT! -->

  <div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
      <h5><b><i class="fa fa-dashboard"></i> Employee Dashboard</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">

      <div class="w3-quarter">
        <div class="w3-container w3-blue w3-padding-16">
          <div class="w3-left"><i class="fa fa-ticket w3-xxxlarge"></i></div>
          <div class="w3-right">
            <h3>52</h3>
          </div>
          <div class="w3-clear"></div>
          <h4>Total Tickets</h4>
        </div>
      </div>

      <div class="w3-quarter">
        <div class="w3-container w3-red w3-padding-16">
          <div class="w3-left"><i class="fa fa-clock-o w3-xxxlarge"></i></div>
          <div class="w3-right">
            <h3>99</h3>
          </div>
          <div class="w3-clear"></div>
          <h4>Pending Tickets</h4>
        </div>
      </div>
      <div class="w3-quarter">
        <div class="w3-container w3-green w3-padding-16">
          <div class="w3-left"><i class="fa fa-check w3-xxxlarge"></i></div>
          <div class="w3-right">
            <h3>23</h3>
          </div>
          <div class="w3-clear"></div>
          <h4>Approved Tickets</h4>
        </div>
      </div>
    </div>


    <hr>

    <div class="w3-container">
      <h5>Recent Tickets</h5>
      <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
        <tr>
          <td>Ticket No:&nbsp;
            <!--Ticket No-->0001</td>
          <td><button class="w3-button w3-blue">View</button></td>
        </tr>
        <tr>
          <td>Ticket No:&nbsp;
            <!--Ticket No-->0002</td>
          <td><button class="w3-button w3-blue">View</button></td>
        </tr>
        <tr>
          <td>Ticket No:&nbsp;
            <!--Ticket No-->0003</td>
          <td><button class="w3-button w3-blue">View</button></td>
        </tr>
        <tr>
          <td>Ticket No:&nbsp;
            <!--Ticket No-->0004</td>
          <td><button class="w3-button w3-blue">View</button></td>
        </tr>
        <tr>
          <td>Ticket No:&nbsp;
            <!--Ticket No-->0005</td>
          <td><button class="w3-button w3-blue">View</button></td>
        </tr>
        <tr>
          <td>Ticket No:&nbsp;
            <!--Ticket No-->0006</td>
          <td><button class="w3-button w3-blue">View</button></td>
        </tr>
      </table><br>
      <button class="w3-button w3-dark-grey">View All Tickets  <i class="fa fa-arrow-right"></i></button>
    </div>
    <hr>
    <br>


    <!-- End page content -->


    <script>
      // Get the Sidebar
      var mySidebar = document.getElementById("mySidebar");

      // Get the DIV with overlay effect
      var overlayBg = document.getElementById("myOverlay");

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

      // Close the sidebar with the close button
      function w3_close() {
        mySidebar.style.display = "none";
        overlayBg.style.display = "none";
      }
    </script>

</body>

</html>
