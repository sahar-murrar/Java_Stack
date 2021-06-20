<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Book</title>
</head>
<body style="margin: 0px auto; width:800px">
	<h1>
		<c:out value="${book.title}" />
	</h1>
	<p>
		Description:
		<c:out value="${book.description}" />
	</p>
	<p>
		Language:
		<c:out value="${book.language}" />
	</p>
	<p>
		Number of pages:
		<c:out value="${book.numberOfPages}" />
	</p>
	<a href="/books/${book.id}/edit">Edit Book</a>
	<form action="/books/deleteBook/${book.id}" method="post" style="margin-top:15px">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete Book">
	</form>

</body>
</html>