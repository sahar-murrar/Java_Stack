<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Info</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="margin: 0px auto; width: 600px">
	<h1>
		<c:out value="${question.question}" />
	</h1>
	<div style="margin-bottom:20px">
		Tags:
		<c:forEach items="${question.tags}" var="tags">
		<span style="border:2px solid black; margin-right:5px; padding:3px;"><c:out value="${tags.subject}" /></span>
			
		</c:forEach>
	</div>
	<div style="display: flex; justify-content: space-between;">
		<table class="table table-bordered" style="margin-right:20px">
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${answerList}" var="answer">
					<tr>
						<td><c:out value="${answer.answer}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div style="width:400px">

			<h3>Add Your Answer:</h3>
			<form:form action="/answers/process/${question.id}" method="post"
				modelAttribute="answers">
				<p style="display:flex">
					<form:label style="margin-right:8px" path="answer">Answer:</form:label>
					<form:errors path="answer" />
					<form:textarea path="answer" />
				</p>

				<input style="margin-left:80px" type="submit" value="Answer it!" />
			</form:form>

		</div>
	</div>

</body>
</html>