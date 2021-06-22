<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
</head>
<body style="margin: 0px auto; width:800px">

	<div style="display:flex">
	<a href="/dashboard"> Dashboard</a>
	<form:form action="/languages/${languageId}"
							method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form:form>
	</div>
	<h1>
		Edit
		<c:out value="${language.name}" />
		Language
	</h1>
	<form:form action="/languages/${languageId}" method="post"
		modelAttribute="language">
		<input type="hidden" name="_method" value="put">

		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" value="${name}" />
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator" />
			<form:input path="creator" value="${creator}" />
		</p>
		<p>
			<form:label path="currentVersion">Version</form:label>
			<form:errors path="currentVersion" />
			<form:input path="currentVersion"  value="${currentVersion}"/>
		</p>

		<input type="submit" value="Edit Book" />
	</form:form>


</body>
</html>