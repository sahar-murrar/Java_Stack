<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Questions</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="margin: 0px auto; width: 800px">
	<h1>Questions Dashboard</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allQuestions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}"><c:out value="${question.question}" /></a></td>
					<td>
					<c:forEach items="${question.tags}" var="tags">
						<c:out value="${tags.subject}," />
					</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/questions/new"style="margin-left:690px">New Question</a>

</body>
</html>