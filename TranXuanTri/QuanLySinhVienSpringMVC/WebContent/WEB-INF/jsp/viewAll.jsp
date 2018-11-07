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
	<a class="btn btn-info" href="/QuanLySinhVienSpringMVC/addForm">Thêm sinh viên mới</a>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Họ tên</th>
			<th>Năm sinh</th>
			<th>Email</th>
			<th>Giới tính</th>
			<th>Địa chỉ</th>
			<th>Lớp học</th>
			<th>Ảnh thẻ</th>
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
				<td><img src="/QuanLySinhVienSpringMVC/images/${sv.anhThe}"
					class="rounded" width="150" /></td>
				<td><a href="/QuanLySinhVienSpringMVC/updateForm/${sv.id}">Edit</a></td>
				<td><a href="/QuanLySinhVienSpringMVC/delete/${sv.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<ul class="pagination" style="margin-left: 65%;">
		<li class="page-item"><a class="page-link"
			href="/QuanLySinhVienSpringMVC/viewAll/1">1</a></li>
		<li class="page-item"><a class="page-link"
			href="/QuanLySinhVienSpringMVC/viewAll/2">2</a></li>
		<li class="page-item"><a class="page-link"
			href="/QuanLySinhVienSpringMVC/viewAll/3">3</a></li>
	</ul>


</body>
</html>