<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Language</title>
</head>
<body>
	<a href="/dashboard"> Dashboard</a>
	<p>
		<c:out value="${language.name}" />
	</p>
	<p>
		<c:out value="${language.creator}" />
	</p>
	<p>
		<c:out value="${language.currentVersion}" />
	</p>
	<a href="/languages/${language.id}/edit">edit</a>
	<form:form action="/languages/${language.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form:form>

</body>
</html>