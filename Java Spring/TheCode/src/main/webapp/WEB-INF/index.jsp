<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/code_style.css">
<title>Secret Code</title>
</head>
<body>
	<p class="error"> <c:out value="${error}" /> </p>
	<p>What is the code? </p>
	<form method="POST" action="/process_code">
		<input type="text" name="code" placeholder="enter the code here..">
		<br>
		<button>Try Code</button>
	</form>

</body>
</html>