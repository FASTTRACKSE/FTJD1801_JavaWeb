<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
img {
	width: 50px;
	height: 60px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QUẢN LÝ SINH VIÊN</title>
</head>
<body>
	<center>
		<div style="width: 1200px;">
			<form action="/StudentManagement_HibernateMVC/search" method="post">
				<div style="width: 300px; float: left;">
					<div class="input-group mb-3">
						<input type="text" name="searchName" class="form-control"
							placeholder="input name...">
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
				<c:forEach var="tempStudent" items="${students}">
					<tr>
						<td>${tempStudent.maSV}</td>
						<td>${tempStudent.tenSV}</td>
						<td>${tempStudent.namSinh}</td>
						<c:if test="${empty tempStudent.avatar}">
							<td>...</td>
						</c:if>
						<c:if test="${not empty tempStudent.avatar}">
							<td><img
								src="/StudentManagement_HibernateMVC/images/${tempStudent.avatar}"></td>
						</c:if>
						<td><a
							href="<c:url value='/edit-${tempStudent.maSV}-student' />"><i
								class="fas fa-edit"></i></a> <a
							href="<c:url value='/delete-${tempStudent.maSV}-student' />"><i
								class="fas fa-trash"></i></a></td>
					</tr>
				</c:forEach>
				<thead>
					<tr style="color: #005500; background-color: #99FFCC;">
						<td><i class="fas fa-sort-numeric-up"></i></td>
						<td>Họ tên</td>
						<td>Năm sinh</td>
						<td>Avatar</td>
						<td>Tác vụ</td>
					</tr>
				</thead>
			</table>
			<ul class="pagination">
				<c:if test="${crPage != 1}">
					<li class="page-item"><a class="page-link"
						href="/StudentManagement_HibernateMVC/list/1">Trang đầu</a></li>
					<li class="page-item"><a class="page-link"
						href="/StudentManagement_HibernateMVC/list/${crPage-1}">Trang
							trước</a></li>
				</c:if>

				<c:choose>
					<c:when test="${crPage eq 1}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item active"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage+1}">${crPage+1}</a></li>
								<li class="page-item"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage+2}">${crPage+2}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage+1}">${crPage+1}</a></li>
							</c:when>
							<c:when test="${totalPage gt 0}">
								<li class="page-item active"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a></li>
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${crPage eq totalPage}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage-2}">${crPage-2}</a></li>
								<li class="page-item"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a>
							</c:when>
						</c:choose>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="/StudentManagement_HibernateMVC/list/${crPage-1}">${crPage-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/StudentManagement_HibernateMVC/list/${crPage}">${crPage}</a></li>
						<li class="page-item"><a class="page-link"
							href="/StudentManagement_HibernateMVC/list/${crPage+1}">${crPage+1}</a></li>
					</c:otherwise>
				</c:choose>

				<c:if test="${crPage lt totalPage}">
					<li class="page-item"><a class="page-link"
						href="/StudentManagement_HibernateMVC/list/${crPage+1}">Trang
							sau</a></li>
					<li class="page-item"><a class="page-link"
						href="/StudentManagement_HibernateMVC/list/${totalPage}">Trang
							cuối</a></li>
				</c:if>
			</ul>

			<h3 style='float: left;'>
				<a href='<c:url value='/new' />'
					class="btn btn-primary btn-lg active">Add Student</a>
			</h3>
		</div>
	</center>
</body>
</html>