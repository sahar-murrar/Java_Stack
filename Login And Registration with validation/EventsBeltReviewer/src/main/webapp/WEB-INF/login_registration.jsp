<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<div style="display: flex; justify-content:space-between;">

		<div>
			<h1>Register!</h1>

			<p>
				<form:errors path="user.*" />
			</p>

			<form:form method="POST" action="/registration" modelAttribute="user">
				<p>
					<form:label path="firstname">First Name:</form:label>
					<form:input type="firstname" path="firstname" />
				</p>
				<p>
					<form:label path="lastname">Last Name:</form:label>
					<form:input type="lastname" path="lastname" />
				</p>
				<p>
					<form:label path="email">Email:</form:label>
					<form:input type="email" path="email" />
				</p>
				<div style="display: flex">
					<p>
						<form:label path="location">Location:</form:label>
						<form:input type="location" path="location" />
					</p>
					<p>
						<form:select name="state" id="state" path="state">
							<form:option value="CA">CA</form:option>
							<form:option value="WA">WA</form:option>
							<form:option value="AZ">AZ</form:option>
							<form:option value="KW">KW</form:option>
							<form:option value="JR">JR</form:option>
							<form:option value="PS">PS</form:option>
							<!-- 
				<c:forEach items="${states}" var="state">
						<option value="${state.state}">${state.state}</option>
					</c:forEach>
				 -->
						</form:select>
					</p>

				</div>
				<p>
					<form:label path="password">Password:</form:label>
					<form:password path="password" />
				</p>
				<p>
					<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					<form:password path="passwordConfirmation" />
				</p>
				<input type="submit" value="Register!" />
			</form:form>

		</div>

		<div>
			<h1>Login</h1>
			<p>
				<c:out value="${error}" />
			</p>
			<form method="post" action="/login">
				<p>
					<label for="email">Email</label> <input type="text" id="email"
						name="email" />
				</p>
				<p>
					<label for="password">Password</label> <input type="password"
						id="password" name="password" />
				</p>
				<input type="submit" value="Login!" />
			</form>


		</div>

	</div>
</body>
</html>