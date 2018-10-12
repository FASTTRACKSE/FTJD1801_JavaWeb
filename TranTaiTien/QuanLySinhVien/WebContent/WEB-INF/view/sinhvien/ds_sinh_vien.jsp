<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<style type="text/css">
	img{
		width: 45px;
		height: 60px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sinh viên</title>
</head>
<body>
	<center>
		<div style="width: 1200px;">
			<h1>Danh sách sinh viên</h1>
			<form action="list" method="post">
				<div style="width: 300px; float: left;">
					<div class="input-group mb-3">
						<input type="text" name="search" class="form-control"
							placeholder="Tìm kiếm...">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit"
								id="button-addon2">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
			<table class="table table-hover">
				<c:forEach var="tempStudent" items="${student_list}">
					<tr>
						<td>${tempStudent.maSV}</td>
						<td>${tempStudent.hoTen}</td>
						<td>${tempStudent.namSinh}</td>
						<td><img alt="null" src="uploads/${tempStudent.avatar}"></td>
						<td><a href="call_update?id=${tempStudent.maSV}"><i
								class="fas fa-edit"></i></a> <a
							href="call_remove?id=${tempStudent.maSV}"><i
								class="fas fa-trash"></i></a></td>
					</tr>
				</c:forEach>
				<thead>
					<tr style="color: #005500; background-color: #99FFCC;">
						<td><i class="fas fa-sort-numeric-up"></i></td>
						<td>Họ tên</td>
						<td>Tuổi</td>
						<td>Hình ảnh</td>
						<td>Tác vụ</td>
					</tr>
				</thead>
			</table>
			<ul class="pagination">
				<c:if test="${crPage != 1}">
					<li class="page-item"><a class="page-link" href="list?page=1">Trang
							đầu</a></li>
					<li class="page-item"><a class="page-link"
						href="list?page=${crPage-1}">Trang trước</a></li>
				</c:if>

				<c:choose>
					<c:when test="${crPage eq 1}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item active"><a class="page-link"
									href="list?page=${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="list?page=${crPage+1}">${crPage+1}</a></li>
								<li class="page-item"><a class="page-link"
									href="list?page=${crPage+2}">${crPage+2}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="list?page=${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="list?page=${crPage+1}">${crPage+1}</a></li>
							</c:when>
							<c:when test="${totalPage gt 0}">
								<li class="page-item active"><a class="page-link"
									href="list?page=${crPage}">${crPage}</a></li>
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${crPage eq totalPage}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item"><a class="page-link"
									href="list?page=${crPage-2}">${crPage-2}</a></li>
								<li class="page-item"><a class="page-link"
									href="list?page=${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="list?page=${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item"><a class="page-link"
									href="list?page=${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="list?page=${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="list?page=${crPage}">${crPage}</a>
							</c:when>
						</c:choose>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="list?page=${crPage-1}">${crPage-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="list?page=${crPage}">${crPage}</a></li>
						<li class="page-item"><a class="page-link"
							href="list?page=${crPage+1}">${crPage+1}</a></li>
					</c:otherwise>
				</c:choose>

				<c:if test="${crPage lt totalPage}">
					<li class="page-item"><a class="page-link"
						href="list?page=${crPage+1}">Trang kế</a></li>
					<li class="page-item"><a class="page-link"
						href="list?page=${totalPage}">Trang cuối</a></li>
				</c:if>
			</ul>
			<h3 style='float: left;'>
				<a href='call_insert' class="btn btn-primary btn-lg active">Thêm</a>
			</h3>
		</div>
	</center>
</body>
</html>