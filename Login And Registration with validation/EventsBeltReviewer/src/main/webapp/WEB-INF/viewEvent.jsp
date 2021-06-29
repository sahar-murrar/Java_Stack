<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Event</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div style="display: flex; justify-content: space-between;">

		<div>
			<h1>
				<c:out value="${event.name}" />
			</h1>
			<p>
				Host:
				<c:out value="${event.host.firstname} ${event.host.lastname}" />
			</p>
			<p>
				Date:
				<c:out value="${event.date}" />
			</p>
			<p>
				Location:
				<c:out value="${event.location}, ${event.stateEvent}" />
			</p>
			<p>
				People who are attending this event are:
				<c:out value="${numbOfAtendees}" />
			</p>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attendees}" var="user">
						<tr>
							<td><c:out value="${user.firstname} ${user.lastname}" /></td>
							<td><c:out value="${event.location}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>

		<div>
			<h1>Message Wall</h1>
			<textarea class="scrollabletextbox" name="note" style="width:300px; height:350px">
				<c:forEach items="${eventComments}" var="comment">
	  						<c:out value="${comment.user.firstname} ${comment.user.lastname} says: ${comment.comment}" />
	  						         ------------------------
	  			</c:forEach>
			</textarea>

			<form:form action="/addComment/${event.id}" method="post"
				modelAttribute="comment">
				<p>
					<form:label path="comment">Add Comment:</form:label>
					<form:errors path="comment" />
					<form:textarea path="comment" />
				</p>
				<input type="submit" value="Submit" />
			</form:form>

		</div>


	</div>

</body>
</html>