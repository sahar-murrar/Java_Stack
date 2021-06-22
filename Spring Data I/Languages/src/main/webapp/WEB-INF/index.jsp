<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="margin: 0px auto; width: 800px">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
				<tr>
					<td><c:out value="${language.name}" /></td>
					<td><c:out value="${language.creator}" /></td>
					<td><c:out value="${language.currentVersion}" /></td>
					<td><form:form action="/languages/${language.id}"
							method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete">
							<a href="/languages/${language.id}/edit">edit</a>
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add a new Language</h2>
	<form:form action="/languages" method="post" modelAttribute="language">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" name="name" />
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator" />
			<form:input path="creator" />
		</p>
		<p>
			<form:label path="currentVersion">Version</form:label>
			<form:errors path="currentVersion" />
			<form:input path="currentVersion" />
		</p>

		<input type="submit" value="Create Book" />
	</form:form>



</body>
</html>