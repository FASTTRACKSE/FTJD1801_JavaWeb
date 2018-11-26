<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous" />
<meta charset="UTF-8">
<title>Quản lý sinh viên</title>
</head>
<body>
	<h1>Danh sách sinh viên</h1>
	<a class="btn btn-info" href="/QuanLySinhVienSpringMVC/addForm">Thêm sinh viên mới</a>
	<form action="/QuanLySinhVienSpringMVC/search" method = "POST"> 
		<input type="text" name="searchTerm"
			placeholder="Tìm kiếm...">
		<button class="btn btn-default" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>
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
			<th>Sửa</th>
			<th>Xóa</th>
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
					class="rounded" width="50" height="50" /></td>
				<td><a href="/QuanLySinhVienSpringMVC/updateForm/${sv.id}">Sửa</a></td>
				<td><a href="/QuanLySinhVienSpringMVC/deleteForm/${sv.id}">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<ul class="pagination" style="margin-left: 65%;">
		<c:if test="${pageid != 1}">
			<li class="page-item"><a class="page-link"
				href="/QuanLySinhVienSpringMVC/viewAll/1">Trang đầu</a></li>
			<li class="page-item"><a class="page-link"
				href="/QuanLySinhVienSpringMVC/viewAll/${pageid -1 }">Trang
					trước</a></li>
		</c:if>
		<c:choose>
			<c:when test="${noOfPages eq 1}">
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
			</c:when>
			<c:when test="${noOfPages eq 2}">
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid}">1</a></li>
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid+1}">2</a></li>
					</c:when>
					<c:when test="${pageid eq 2}">
						<li class="page-item "><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid-1}">1</a></li>
						<li class="page-item active"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid} ">2</a></li>
					</c:when>
				</c:choose>

			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid} ">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid+1} ">${pageid+1}</a></li>
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid+2} ">${pageid+2}</a>
					</c:when>
					<c:when test="${pageid eq noOfPages}">
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid-2} ">${pageid-2}</a></li>
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid-1} ">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid} ">${pageid}</a>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid-1} ">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid} ">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/QuanLySinhVienSpringMVC/viewAll/${pageid+1} ">${pageid+1}</a></li>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<c:if test="${pageid lt noOfPages}">
			<li class="page-item"><a class="page-link"
				href="/QuanLySinhVienSpringMVC/viewAll/${pageid+1}">Trang sau</a></li>
			<li class="page-item"><a class="page-link"
				href="/QuanLySinhVienSpringMVC/viewAll/${noOfPages} ">Trang cuối</a></li>
		</c:if>
	</ul>

</body>
</html>