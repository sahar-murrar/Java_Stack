<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<h1>
		<c:out value="${category.name}" />
	</h1>
	<div style="display: flex; justify-content: space-between">
		<div>
			<h3>Products:</h3>
			<ul>
				<c:forEach items="${categoryProducts}" var="product">
					<li><c:out value="${product.name}" /></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<form action="/categories/addProduct" method="POST">
				<label for="product">Product:</label> <select name="product">
					<c:forEach items="${remainedProducts}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
					
				</select>
				<input type="hidden" name="category" value="${category.id}">
				 <input type="submit" value="Add" />
			</form>
		</div>



	</div>

</body>
</html>