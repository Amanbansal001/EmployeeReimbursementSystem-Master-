<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="resources/css/adminDashboard.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/f299ae210a.js" crossorigin="anonymous"></script>
<script>
  $(document).ready(function(){
      $("#createticket").click(function(){
          $("#cont").load("adminticketapproval.html");
      });
  });
  </script>
<body>
  <div class="topheader">
    <img src="realcoderzicon.gif" alt="icon">
    <h1>Welcome to the Admin Portal</h1>
  </div>
  <div class="header">
    <h2>
      <form>
      <input type="text" class="textbox" placeholder="Search">
      <button type="submit" id="submitme"><i class="fa fa-search fa-2x"></i></button> 
      </form>
    </h2>
<div class="notification_icon">
  <button type="menu" id="notifyme" ><i class="fa fa-bell-o fa-2x"></i></button>
</div>
  </div>
  <input type="checkbox" id="chk">
  <label for="chk" class="show-btn">
    <i class="fa fa-bars" ></i>
  </label>
  <label for="chk" class="hide-btn">
    <i class="fa fa-bars"></i> 
  </label>
  <div class="content" id="cont">
   <div class="inventory_containers" >
     <div>Total Tickets</div>
     <div>Pending Tickets</div>
     <div>Approved Tickets</div>
   </div>
  </div>
  <div class="sidebar">
    <img src="resources/images/richa.jpeg" alt=""></br> 
    <p>Richa Tiwari</p>
    <ul>
      <li><a href="admindashboard.html" id="home">Home</a></li>
      <li><a href="showUsers" id="users">Users</a></li> 
      <li><a href="#" id="createticket">Create Ticket</a></li>
      <li><a href="#" id="settings">Settings</a></li>
      <li><a href="#" id="logout">Logout</a></li>
    </ul>
  </div>
  <div class="notification_dropdown">
  </div>
</body>
</html>