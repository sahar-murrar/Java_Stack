<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/time.js"></script>
<link rel="stylesheet" type="text/css" href="css/time.css">
<title>Time Template</title>
</head>
<body>
	<p> <c:out value="${time}"/> </p>

</body>
</html>