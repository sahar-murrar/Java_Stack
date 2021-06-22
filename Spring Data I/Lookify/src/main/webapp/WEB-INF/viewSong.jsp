<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Song</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<p> Title: ${song.title}</p>
<p> Artist: ${song.artist}</p>
<p> Rating: ${song.rating}</p>

<form:form action="/songs/${song.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete">
						</form:form>


</body>
</html>