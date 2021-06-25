<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<h1>
		<c:out value="${product.name}" />
	</h1>
	<div style="display: flex; justify-content: space-between">
		<div>
			<h3>Categories:</h3>
			<ul>
				<c:forEach items="${productCategories}" var="category">
					<li><c:out value="${category.name}" /></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<form action="/products/addCategory" method="POST">
				<label for="category">Category:</label> <select name="category">
					<c:forEach items="${remainedCategories}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
					
				</select>
				<input type="hidden" name="product" value="${product.id}">
				 <input type="submit" value="Add" />
			</form>
		</div>



	</div>

</body>
</html>