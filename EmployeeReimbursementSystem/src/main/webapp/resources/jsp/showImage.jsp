<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="get" action="displayImage" modelAttribute="showImag">
Name : ${showImag.name }
email : ${showImag.email }
<br>
Image :			<img src="data:image/jpeg;base64,${showImag.imageDisplay}" 
							style="width: 20% ">

</form:form>
</body>
</html>