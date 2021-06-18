<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>

	<main>
		<div id="head">
			<div>Your Gold:</div>
			<div id="goldsnum">
			     <c:if test = "${golds == null}">
					 <c:out value="${0}" />
				 </c:if>
				 <c:if test = "${golds != null}">
					 <c:out value="${golds}" />
				 </c:if>
				
			</div>

		</div>
		<nav>
			<br>
			<div class="forms">
				<h4>Farm</h4>
				<p>(earns 10-20 golds)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="which_form" value="farm"> <input
						type="submit" name="button" value="Find Gold!">
				</form>
			</div>
			<br>
			<div class="forms">
				<h4>Cave</h4>
				<p>(earns 5-10 golds)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="which_form" value="cave"> <input
						type="submit" name="button" value="Find Gold!">
				</form>
			</div>
			<br>
			<div class="forms">
				<h4>House</h4>
				<p>(earns 2-5 golds)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="which_form" value="house"> <input
						type="submit" name="button" value="Find Gold!">
				</form>
			</div>
			<br>
			<div class="forms">
				<h4>Casino</h4>
				<p>(earns/takes 0-50 golds)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="which_form" value="casino"> <input
						type="submit" name="button" value="Find Gold!">
				</form>
			</div>
		</nav>


		<div>
			<h3>Activities:</h3>
			<div id="activities">
			 <c:forEach items="${arr}" var="activity">
				  <c:if test = "${fn:contains(activity, 'earned')}">
					 <p id="green">${activity}</p>
				 </c:if>
				  <c:if test = "${fn:contains(activity, 'lost')}">
					 <p id="red">${activity}</p>
				 </c:if>
		 		
        	</c:forEach>
        	</div>
			
		</div>
		


	</main>

</body>
</html>