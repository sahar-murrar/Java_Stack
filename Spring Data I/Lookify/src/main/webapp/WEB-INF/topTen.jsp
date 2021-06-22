<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten Songs</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="margin: 0px auto; width: 800px">
	<div style="display: flex; justify-content:space-between">
		<p>Top Ten Songs:</p>
		<a href="/dashboard"> Dashboard</a>

	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Rating</th>
				<th>Title</th>
				<th>Artist</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${topTenSongs}" var="song">
				<tr>
					<td><c:out value="${song.rating}" /></td>
					<td><a href="/songs/${song.title}">${song.title} </a></td>
					<td><c:out value="${song.artist}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>