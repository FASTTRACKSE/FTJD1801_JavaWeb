<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Quản lý sinh viên</title>
</head>
<body>
	<h1>Danh sách sinh viên</h1>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Họ tên</th>
			<th>Năm sinh</th>
			<th>Email</th>
			<th>Giới tính</th>
			<th>Địa chỉ</th>
			<th>Lớp học</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.hoTen}</td>
				<td>${sv.namSinh}</td>
				<td>${sv.email}</td>
				<td>${sv.gioiTinh}</td>
				<td>${sv.diaChi}</td>
				<td>${sv.lopHoc}</td>
				<td><a href="updateForm/${sv.id}">Edit</a></td>
				<td><a href="delete/${sv.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addForm">Thêm sinh viên mới</a>
</body>
</html>