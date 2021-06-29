<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div style="display: flex; justify-content: space-between; padding:10px">
		<h1>
			Welcome,
			<c:out value="${user.firstname}" />
		</h1>
		<h1>
			<a href="/logout">Logout</a>
		</h1>
	</div>
	<p>Here are some of the events in your state:</p>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stateEvents}" var="event">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td><c:out value="${event.date}" /></td>
					<td><c:out value="${event.location}" /></td>
					<td><c:out value="${event.host.firstname}" /></td>

					<td><c:choose>
							<c:when test="${event.host.id == user.id}">
								<div style="display:flex">
									<a href="/editEvent/${event.id}">Edit | </a> |
									<form style="margin-left:5px" action="/deleteEvent/${event.id}" method="post">
										<input type="hidden" name="_method" value="delete" /> <input
											type="submit" value="Delete">
									</form>


								</div>

							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${ event.users.contains(user) }">
										<span>Joining |<a href="/cancelJoin/${ event.id }">| Cancel</a></span>
									</c:when>
									<c:otherwise>
										<a href="/joinEvent/${ event.id }">Join</a>
									</c:otherwise>

								</c:choose>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reaminedEvents}" var="event">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td><c:out value="${event.date}" /></td>
					<td><c:out value="${event.location}" /></td>
					<td><c:out value="${event.host.firstname}" /></td>

					<td><c:choose>
							<c:when test="${event.host.id == user.id}">
								<div style="display:flex">
									<a href="/editEvent/${event.id}">Edit </a> |
									<form style="margin-left:5px" action="/deleteEvent/${event.id}" method="post">
										<input type="hidden" name="_method" value="delete" /> <input
											type="submit" value="Delete">
									</form>


								</div>

							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${ event.users.contains(user) }">
										<span>Joining <a href="/cancelJoin/${ event.id }">Cancel</a></span>
									</c:when>
									<c:otherwise>
										<a href="/joinEvent/${ event.id }">Join</a>
									</c:otherwise>

								</c:choose>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<form:form action="/creat_events" method="post" modelAttribute="event">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="date">Date</form:label>
			<form:errors path="date" />
			<form:input type="date" path="date" />
		</p>
		<div style="display: flex">
			<p>
				<form:label path="location">Location:</form:label>
				<form:input type="location" path="location" />
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
		<input type="submit" value="Create Event" />
	</form:form>




</body>
</html>