<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artist Songs</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="margin: 0px auto; width: 800px">
	<div style="display: flex; justify-content:space-between">
		<p>Songs By artist: <c:out value="${artistName}"/> </p>
		<form:form action="/search/" method="post" modelAttribute="songg">
			<div style="display: flex">
				<p>
					<form:errors path="artist" />
					<form:input path="artist" value="${artistName}" />
				</p>
				<input style="height:30px; margin-left:10px" type="submit" value="Search Artist" />
			</div>

		</form:form>
		<a href="/dashboard"> Dashboard</a>
	</div>
<table class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${artistSongsList}" var="song">
				<tr>
					<td><a href="/songs/${song.title}">${song.title}</a></td>
					<td><c:out value="${song.rating}" /></td>
					<td><form:form action="/songs/${song.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete">
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>