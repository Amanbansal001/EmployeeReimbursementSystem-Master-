<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!-- @Auther: Shubham Mishra -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Submit Reimbursement Request</title>
</head>
<body>

    <div class="w3-container w3-center w3-display-middle w3-animate-zoom">
  <div class="w3-card-4" style="width:100%">
    <header class="w3-container w3-center">
      <h3>Upload Bill</h3>
    </header>
     <form:form action="GenerateUserTicketDao" method = "POST" modelAttribute="userTicketCreds" enctype="multipart/form-data">     
    <div class="w3-container">
      <p>${success}</p>
      <hr>
     
            <form:input class="w3-button" type="file" path="image"/><br>
            Amount:
            <form:input class="w3-button" path="amount"/><br>
      </div>
     	<input class="w3-button w3-block w3-green" type="submit" value="Save" />
       </form:form>
  </div>
</div>
</body>
</html>
