<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Ninja</title>
</head>
<body style="margin: 0px auto; width: 800px">
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new/create" method="post"
		modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojo:</form:label>
			<form:errors path="dojo" />
			<form:select type="select" path="dojo">
				<c:forEach items="${allDojos}" var="dojo">
					<form:option value="${dojo}">
						<c:out value="${dojo.name}" />
					</form:option>

				</c:forEach>
			</form:select>
		</p>
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
		<p>
			<form:label path="age">Age:</form:label>
			<form:errors path="age" />
			<form:input type="number" path="age" />
		</p>


		<input type="submit" value="Create" />
	</form:form>


</body>
</html>