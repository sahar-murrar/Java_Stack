<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body style="margin: 0px auto; width: 800px">
	<h1>New Person</h1>

	<form:form action="/persons/new/create" method="post" modelAttribute="persons">
		<p>
			<form:label path="firstname">First Name:</form:label>
			<form:errors path="firstname" />
			<form:input path="firstname" />
		</p>
		<p>
			<form:label path="lastname">Last Name:</form:label>
			<form:errors path="lastname" />
			<form:input path="lastname" />
		</p>

		<input type="submit" value="Create" />
	</form:form>


</body>
</html>