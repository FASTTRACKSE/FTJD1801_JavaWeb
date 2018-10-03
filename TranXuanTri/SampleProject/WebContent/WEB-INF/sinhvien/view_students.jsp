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
	<h2 align="center">Danh sách sinh viên</h2>
	<a href="/SampleProject/formAdd" class="btn btn-info"
		style="margin-left: 10px; margin-bottom: 10px;"> Thêm sinh viên </a>
	<form action="/SampleProject/list">
		<input type="search" name="nameSearch"
			placeholder="Nhập tên sinh viên cần tìm">
		<button class="btn btn-default" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
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
				<td><a href="/SampleProject/formUpdate?id=${sinhVien.id}"
					class="far fa-edit"></a> <a
					href="/SampleProject/formDelete?id=${sinhVien.id}"
					class="far fa-trash-alt"></a></td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination" style="margin-left: 65%;">
		<c:if test="${pageid != 1}">
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${1}&nameSearch=${nameSearch}">Trang
					đầu</a></li>
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">Previous</a></li>
		</c:if>
		<c:choose>
			<c:when test="${noOfPages eq 1}">
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
			</c:when>
			<c:when test="${noOfPages eq 2}">
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">1</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">2</a></li>
					</c:when>
					<c:when test="${pageid eq 2}">
						<li class="page-item "><a class="page-link"
							href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">1</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">2</a></li>
					</c:when>
				</c:choose>

			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">${pageid+1}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+2}&nameSearch=${nameSearch}">${pageid+2}</a>
					</c:when>
					<c:when test="${pageid eq noOfPages}">
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid-2}&nameSearch=${nameSearch}">${pageid-2}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">${pageid}</a>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">${pageid+1}</a></li>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<c:if test="${pageid lt noOfPages}">
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">Next</a></li>
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${noOfPages}&nameSearch=${nameSearch}">Trang
					cuối</a></li>
		</c:if>
	</ul>
</body>
</html>