<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index_style.css">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Dojo Survey Index</title>
</head>
<body>

	<main>
		<form action='/process_result' method='post'>

			<div>
				Your Name: <input style="border: 2px solid black;" type="text"
					id="name" name="name" placeholder="Enter your name...">
			</div>


			<div>
				Dojo Location: <select style="border: 2px solid black;"
					name="location">
					<option value="Palestine">Palestine</option>
					<option value="Paris">Paris</option>
					<option value="USA">USA</option>
				</select>
			</div>
			<div>
				Favourite Language: <select style="border: 2px solid black;"
					name="language">
					<option value="Python">Python</option>
					<option value="JavaScript">JavaScript</option>
					<option value="MERN">MERN</option>
				</select>
			</div>


			<div>
				Comment (optinal): <br>
				<textarea style="border: 2px solid black;" name="comment"
					id="comment" cols="50" rows="3" placeholder="Any Comments?"></textarea>
			</div>

			<input style="margin-left: 300px;" class="btn btn-info box-shadow"
				type='submit' value='Button'>
		</form>
	</main>

</body>
</html>