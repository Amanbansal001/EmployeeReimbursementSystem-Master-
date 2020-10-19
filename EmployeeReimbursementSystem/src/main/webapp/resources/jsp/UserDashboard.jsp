<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body bgcolor="#D8D8D8">
  <div class="w3-container w3-black">
  <div class="icon_img"> 
    <img src="resources/images/realcoderzicon.gif" alt="logo" style="height:10%;width:10%"> 
  </div>
</div>
    <div class="w3-sidebar w3-bar-block w3-card w3-animate-left w3-teal" style="display:none; " id="mySidebar">
        <button class="w3-bar-item w3-button w3-large"
        onclick="w3_close()">Close</button>
         <a href="#" class="w3-bar-item w3-button">Home</a>
        <a href="#" class="w3-bar-item w3-button">My Profile</a>
        <a href="#" class="w3-bar-item w3-button">Create Ticket</a>
        <a href="#" class="w3-bar-item w3-button">Settings</a>
        <a href="#" class="w3-bar-item w3-button">Logout</a>
      </div>
      
      <div id="main">
        <div class="w3-bar w3-border w3-teal">
          <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
          <button type="menu" id="notifyme" style="float: right;margin-right:16px; margin-top:7px;background: none;border: none;" >
            <i class="fa fa-bell-o fa-2x"></i>
          </button>
          <button type="submit" id="submitme" style="float: right;margin-right:16px; margin-top:7px;background: none;border: none;">
            <i class="fa fa-search fa-2x"></i>
          </button> 
          <input type="text" class="w3-bar-item w3-input" placeholder="Search.." style="border-radius:15px; float:right; margin-right:16px; margin-top:7px;"> 
        </div>
      </div>

      <div class="w3-container w3-margin-top"> 
      </div>
      <div class="w3-container w3-margin-top"> 
      </div>
      <div class="w3-container w3-margin-top"> 
      </div>

      <div class="w3-cell-row">
        <div class="w3-container w3-margin-right"> 
        </div>

        <div class="w3-container w3-white w3-cell w3-mobile">
          <p class="w3-large" style="text-align: center;margin-top:60px;margin-bottom:60px">  Total Tickets  </p>
          <div class="w3-light-grey w3-round-xlarge" style="margin-bottom:30px">
            <div class="w3-container w3-blue w3-round-xlarge" style="width:25%">25%</div>
          </div>
        </div>

        <div class="w3-container w3-margin-right"> 
        </div>

        <div class="w3-container w3-white w3-cell w3-mobile">
          <p class="w3-large" style="text-align: center;margin-top:60px;margin-bottom:60px">Approved Tickets</p>
          <div class="w3-light-grey w3-round-xlarge" style="margin-bottom:30px">
            <div class="w3-container w3-red w3-round-xlarge" style="width:25%">25%</div>
          </div>
        </div>

        <div class="w3-container w3-margin-right"> 
        </div>

        <div class="w3-container w3-white w3-cell w3-mobile w3-margin">
          <p class="w3-large" style="text-align: center;margin-top:60px;margin-bottom:60px">Pending Tickets</p>
          <div class="w3-light-grey w3-round-xlarge" style="margin-bottom:30px">
            <div class="w3-container w3-green w3-round-xlarge" style="width:25%">25%</div>
          </div>
        </div>

        <div class="w3-container w3-margin-right"> 
        </div>
      </div>

        <script>
          function w3_open() {
            document.getElementById("main").style.marginLeft = "20%";
            document.getElementById("mySidebar").style.width = "20%";
            document.getElementById("mySidebar").style.display = "block";
            document.getElementById("openNav").style.display = 'none';
          }
          function w3_close() {
            document.getElementById("main").style.marginLeft = "0%";
            document.getElementById("mySidebar").style.display = "none";
            document.getElementById("openNav").style.display = "inline-block";
          }
          </script>
          
</body>
</html>
