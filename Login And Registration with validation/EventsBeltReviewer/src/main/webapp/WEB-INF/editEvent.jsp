<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
	<h1>
		<c:out value="${event.name}" />
	</h1>
	<p>Edit Event</p>
<form:form action="/process_editEvent" method="post" modelAttribute="event">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"  />
			<form:input path="name" value="${event.name}"/>
		</p>
		<p>
			<form:label path="date">Date</form:label>
			<form:errors path="date" />
			<form:input type="date" path="date" value="${event.date}"/>
		</p>
		<div style="display: flex">
			<p>
				<form:label path="location">Location:</form:label>
				<form:errors path="location" />
				<form:input type="location" path="location" value="${event.location}"/>
			</p>
			<p>
				<form:select name="stateEvent" id="stateEvent" path="stateEvent">
					<form:option value="CA">CA</form:option>
					<form:option value="WA">WA</form:option>
					<form:option value="AZ">AZ</form:option>
					<form:option value="KW">KW</form:option>
					<form:option value="JR">JR</form:option>
					<form:option value="PS">PS</form:option>
				</form:select>
			</p>

		</div>
		<input type="submit" value="Edit" />
	</form:form>


</body>
</html>