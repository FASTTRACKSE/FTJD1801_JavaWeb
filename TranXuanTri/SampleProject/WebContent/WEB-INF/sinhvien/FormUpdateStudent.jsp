<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Update student</title>
</head>
<body>
<h2 >Form update student</h2>
	<form action="/SampleProject/update" method="POST" class="form-group" enctype="multipart/form-data">
		ID: <input type="text" name="idUpdate" value ="${student_update.id}" readonly><br>
		Name: <input type="text" name="nameUpdate" value ="${student_update.hoTen}"><br>
		BirthDay: <input type="text" name="birthdayUpdate" value ="${student_update.namSinh}"><br>
		Image: <input type="file" name="imageUpdate" value ="${student_update.fileName}"><br>
		<input type="submit" class="btn btn-info" value="Update"> 
		<a href="/SampleProject/list" class="btn btn-info"> Cancel </a>
	</form>
</body>
</html>