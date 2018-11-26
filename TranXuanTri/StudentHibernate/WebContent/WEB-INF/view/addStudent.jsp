<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Add Student</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${edit}">
			<h2>Update Student</h2>
		</c:when>
		<c:when test="${delete}">
			<h2>Delete Student</h2>
		</c:when>
		<c:otherwise>
			<h2>Add New Student</h2>
		</c:otherwise>
	</c:choose>
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
		<c:choose>
			<c:when test="${edit}">
				<label for="avatar"> Avatar: </label>
				<input type="file" name="file" id="stuClass" />
				<form:errors path="avatar" cssClass="error" />
				<br>
				<form:input type="hidden" path="avatar" id="avatar" />
				<input class="btn btn-info" type="submit" value="Update" />
				<a href="<c:url value='/list' />" class="btn btn-info">Cancel</a>
			</c:when>
			<c:when test="${delete}">
				Avatar: <img src="/StudentHibernate/images/${student.avatar}"
					class="rounded" width="100" height="100" />
				<br>
				<input class="btn btn-info" type="submit" value="Delete" />
				<a href="<c:url value='/list' />" class="btn btn-info">Cancel</a>
			</c:when>
			<c:otherwise>
				<label for="avatar"> Avatar: </label>
				<input type="file" name="file" id="stuClass" />
				<form:errors path="avatar" cssClass="error" />
				<br>
				<input class="btn btn-info" type="submit" value="Register" />
				<a href="<c:url value='/list' />" class="btn btn-info">Cancel</a>
			</c:otherwise>
		</c:choose>
	</form:form>
</body>
</html>