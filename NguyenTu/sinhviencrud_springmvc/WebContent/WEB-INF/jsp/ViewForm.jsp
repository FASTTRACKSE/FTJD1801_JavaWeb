<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sinh Viên List</title>
</head>
<body>
	<h1>Sinh Viên List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Mã SV</th>
			<th>Tên SV</th>
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
				<td>${sv.maSv}</td>
				<td>${sv.tenSv}</td>
				<td>${sv.namSinh}</td>
				<td>${sv.email}</td>
				<td>${sv.gioiTinh}</td>
				<td>${sv.diaChi}</td>
				<td>${sv.lop}</td>
				<td>${sv.image}</td>
				<td><a href="editsv/${sv.id}">Edit</a></td>
				<td><a href="deletesv/${sv.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="svform">Add Sinh Viên</a>
</body>
</html>


