<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Question</title>
</head>
<body style="margin: 0px auto; width:800px">
<h1>What is your Question?</h1>
	
	<form method="post" action="/questions/new/create">
	<div style="display:flex">
	<label for="question" style="margin-right:5px">Question:</label>
    <textarea  name="question" rows="4" cols="30"></textarea>
	</div>
    <br>
    Tags: <input  type="text" name="tags" >
    <br>
    <br>
    <button style="margin-left:300px">Submit</button>

</form>

</body>
</html>