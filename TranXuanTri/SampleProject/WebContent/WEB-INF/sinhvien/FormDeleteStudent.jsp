<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Form delete</title>
</head>
<body>
	<h2>Form delete student</h2>
	<form action="/SampleProject/delete" method="post"
		class="form-group">
		ID: <input type="text" name="idDelete" value ="${student_delete.id}" readonly><br>
		Name: <input type="text" name="name" value ="${student_delete.hoTen}" readonly><br>
		BirthDay: <input type="text" name="birthday" value ="${student_delete.namSinh}" readonly><br>
		<input type="submit" class="btn btn-info" value="Delete"> 
		<a href="/SampleProject/list" class="btn btn-info"> Cancel </a>
	</form>
</body>
</html>