<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Query Result</title>
</head>
<body>


	<div>
		<h1>First Query</h1>
		<!--  
	<c:forEach items="${Speaks}" var="speak">


		<p>Percentage:
			<c:out value="${speak[1]}"></c:out>
		</p>
		<p>Country Name:
			<c:out value="${speak[2]}"></c:out>
		</p>
		<p>Langauge:
			<c:out value="${speak[0]}"></c:out>
		</p>
		<p>---------------------------------------------------</p>



	</c:forEach>
	-->

	</div>

	<div>

		<h1>Second Query</h1>

		<!-- <c:forEach items="${query2}" var="query2">


		<p># of CIty:
			<c:out value="${query2[1]}"></c:out>
		</p>
		<p>Country Name:
			<c:out value="${query2[0]}"></c:out>
		</p>
				<p>---------------------------------------------------</p>



	</c:forEach>
	             -->
	</div>

	<div>
		<h1>Third Query</h1>
		<!-- 
  
	   <c:forEach items="${query3}" var="query3">


<p>City:
			<c:out value="${query3[0]}"></c:out>
		</p>
		<p>Population:
			<c:out value="${query3[1]}"></c:out>
		</p>
		<p>Country:
			<c:out value="${query3[2]}"></c:out>
		</p>
		<p>---------------------------------------------------</p>


		

	</c:forEach>
	 -->

	</div>

	<div>

		<h1>Fourth Query</h1>
		<!--	
	   <c:forEach items="${query4}" var="query4">


<p>Percentage:
			<c:out value="${query4[2]}"></c:out>
		</p>
		<p>Country Name:
			<c:out value="${query4[0]}"></c:out>
		</p>
		<p>Langauge:
			<c:out value="${query4[1]}"></c:out>
		</p>
		<p>---------------------------------------------------</p>


		

	</c:forEach>
	           -->
	</div>

	<div>

		<h1>Fifth Query</h1>
		<!--  

		<c:forEach items="${query5}" var="query5">


			<p>
				Country Name:
				<c:out value="${query5[0]}"></c:out>
			</p>
			<p>
				Population:
				<c:out value="${query5[1]}"></c:out>
			</p>
			<p>
				Surface Area:
				<c:out value="${query5[2]}"></c:out>
			</p>
			<p>---------------------------------------------------</p>




		</c:forEach>
		-->

	</div>

	<div>

		<h1>6th Query</h1>
	
<!-- 
		<c:forEach items="${query6}" var="query6">


			<p>
				Country Name:
				<c:out value="${query6[0]}"></c:out>
			</p>
			<p>
				Government:
				<c:out value="${query6[1]}"></c:out>
			</p>
			<p>
				Surface Area:
				<c:out value="${query6[2]}"></c:out>
			</p>
			<p>
				Life Expectancy:
				<c:out value="${query6[3]}"></c:out>
			</p>
			<p>---------------------------------------------------</p>




		</c:forEach>
 -->
	</div>


	<div>

		<h1>7th Query</h1>
	<!--  
		<c:forEach items="${query7}" var="query7">


			<p>
				Country Name:
				<c:out value="${query7[0]}"></c:out>
			</p>
			<p>
				City Name:
				<c:out value="${query7[1]}"></c:out>
			</p>
			<p>
				District:
				<c:out value="${query7[2]}"></c:out>
			</p>
			<p>
				Population:
				<c:out value="${query7[3]}"></c:out>
			</p>
			<p>---------------------------------------------------</p>




		</c:forEach>
-->
	</div>

	<div>

		<h1>8th Query</h1>
  
		<c:forEach items="${query8}" var="query8">


			<p>
				Region:
				<c:out value="${query8[0]}"></c:out>
			</p>
			<p>
				Number of Countries:
				<c:out value="${query8[1]}"></c:out>
			</p>
			<p>---------------------------------------------------</p>




		</c:forEach>

	</div>

</body>
</html>