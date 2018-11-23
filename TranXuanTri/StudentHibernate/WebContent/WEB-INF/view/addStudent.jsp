<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Add Student</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<h2>Add New Student</h2>
	<form:form method="POST" modelAttribute="student"
		enctype="multipart/form-data">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="dateOfBirth">Date of birth: </label></td>
				<td><form:input path="dateOfBirth" id="dateOfBirth" /></td>
				<td><form:errors path="dateOfBirth" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="email">Email: </label></td>
				<td><form:input path="email" id="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="gender">Gender: </label></td>
				<td><form:input path="gender" id="gender" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="address">Address: </label></td>
				<td><form:input path="address" id="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="stuClass">Class: </label></td>
				<td><form:input path="stuClass" id="stuClass" /></td>
				<td><form:errors path="stuClass" cssClass="error" /></td>
			</tr>
		</table>
		<label for="avatar"> Avatar:  </label>
		<input type="file" name="file" id="stuClass"/>
		<form:errors path="avatar" cssClass="error" />
		<br>
		<c:choose>
			<c:when test="${edit}">
				<input type="submit" value="Update" />
			</c:when>
			<c:otherwise>
				<input type="submit" value="Register" />
			</c:otherwise>
		</c:choose>
	</form:form>
	<a href="<c:url value='/list' />">Cancel</a>
</body>
</html>