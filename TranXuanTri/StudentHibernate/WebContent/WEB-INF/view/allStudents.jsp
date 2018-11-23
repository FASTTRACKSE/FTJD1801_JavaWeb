<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Manager</title>
</head>
<body>
	<h1>List Students</h1>
	<a class="btn btn-info" href="<c:url value='/new' />">Add new student</a>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date of birth</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Class</th>
			<th>Avatar</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${listStudents}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.dateOfBirth}</td>
				<td>${student.email}</td>
				<td>${student.gender}</td>
				<td>${student.address}</td>
				<td>${student.stuClass}</td>
				<td><img src="/StudentHibernate/images/${student.avatar}"
					class="rounded" width="50" height="50" /></td>
				<td><a href="<c:url value='/edit-${student.id}-student' />">edit</a></td>
				<td><a href="<c:url value='/delete-${student.id}-student' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>