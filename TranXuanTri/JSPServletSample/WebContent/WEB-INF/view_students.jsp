<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Quản lý Sinh viên</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<a href="/JSPServletSample/formAdd" class="btn btn-info"> Thêm sinh viên </a>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>STT</th>
				<th>Họ tên</th>
				<th>Tuổi</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<c:forEach var="sinhVien" items="${students_list}">
			<tr>
				<td>${sinhVien.id}</td>
				<td>${sinhVien.hoTen}</td>
				<td>${2018 - sinhVien.namSinh}</td>
				<td>
				<a href="/JSPServletSample/formUpdate?id=${sinhVien.id}" class="far fa-edit"></a> 
				<a href="/JSPServletSample/formDelete?id=${sinhVien.id}" class="far fa-trash-alt"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>