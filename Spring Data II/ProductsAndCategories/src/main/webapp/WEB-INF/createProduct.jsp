<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Product</title>
</head>
<body>
<h1>New Product</h1>
<form:form action="/products/new/create" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<p>
			<form:label path="price">Price:</form:label>
			<form:errors path="price" />
			<form:input type="number" path="price" />
		</p>
		
		<input type="submit" value="Create" />
	</form:form>

</body>
</html>