<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/info_style.css">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<main>
		<div id="head">
			<h2>Submitted Info</h2>
			<div id="container">
				<div>
					<p>Name:</p>
					<p>Location:</p>
					<p>Language:</p>
					<p>Comment:</p>
				</div>
				<div>
					<p>
						<%
						String name = session.getAttribute("name") + ""; //we added +"" to cast the object that the session returned to string.
						out.print(name); // it is just like cout it will print the content.
						%>
					</p>
					<p>
						<%
						String location = session.getAttribute("location") + ""; //we added +"" to cast the object that the session returned to string.
						out.print(location); // it is just like cout it will print the content.
						%>
					</p>

					<p>
						<%
						String language = session.getAttribute("language") + ""; //we added +"" to cast the object that the session returned to string.
						out.print(language); // it is just like cout it will print the content.
						%>
					</p>
					<p>
						<%
						String comment = session.getAttribute("comment") + ""; //we added +"" to cast the object that the session returned to string.
						out.print(comment); // it is just like cout it will print the content.
						%>
					</p>

				</div>
			</div>
			<form action="/">
				<input style="margin-left: 300px;" class="btn btn-info box-shadow"
					type='submit' value='Go Back'>
			</form>

		</div>


	</main>

</body>
</html>