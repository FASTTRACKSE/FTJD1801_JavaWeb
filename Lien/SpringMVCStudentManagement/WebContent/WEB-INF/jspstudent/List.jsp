<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>THÔNG TIN SINH VIÊN</h1>
	

	<form action="/StudentManagement_SpringMVC/viewSearch" method="post">
		<div style="width: 300px; float: left;">
			<div class="input-group mb-3">
				<input type="text" name="searchValue" class="form-control"
					value="${nameValue}" placeholder="input name...">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="submit"
						id="button-addon2">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</div>
	</form>
	<table class="table table-hover table-dark">
		<tr>
			<th>Mã sinh viên</th>
			<th>Tên sinh viên</th>
			<th>Năm sinh</th>
			<th>Tác vụ</th>
		</tr>
		<c:forEach var="sinhvien" items="${list}">
			<tr>
				<td>${sinhvien.maSV}</td>
				<td>${sinhvien.tenSV}</td>
				<td>${sinhvien.namSinh}</td>
				<td><img
					src="/SpringMVCStudentManagement/images/${sinhvien.avatar}"
					width="100px" height="100px" /></td>

			</tr>
		</c:forEach>
	</table>
	<ul class="pagination">
		<c:if test="${crPage != 1}">
			<li class="page-item"><a class="page-link"
				href="/SpringMVCStudentManagement/List/1">Trang đầu</a></li>
			<li class="page-item"><a class="page-link"
				href="/SpringMVCStudentManagement/List/${crPage-1}">Trang trước</a></li>
		</c:if>

		<c:choose>
			<c:when test="${crPage eq 1}">
				<c:choose>
					<c:when test="${totalPage gt 2}">
						<li class="page-item active"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage+1}">${crPage+1}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage+2}">${crPage+2}</a>
					</c:when>
					<c:when test="${totalPage gt 1}">
						<li class="page-item active"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage+1}">${crPage+1}</a></li>
					</c:when>
					<c:when test="${totalPage gt 0}">
						<li class="page-item active"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a></li>
					</c:when>
				</c:choose>
			</c:when>
			<c:when test="${crPage eq totalPage}">
				<c:choose>
					<c:when test="${totalPage gt 2}">
						<li class="page-item"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage-2}">${crPage-2}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage-1}">${crPage-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a>
					</c:when>
					<c:when test="${totalPage gt 1}">
						<li class="page-item"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage-1}">${crPage-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a>
					</c:when>
					<c:when test="${totalPage gt 1}">
						<li class="page-item active"><a class="page-link"
							href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a>
					</c:when>
				</c:choose>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="/SpringMVCStudentManagement/List/${crPage-1}">${crPage-1}</a></li>
				<li class="page-item active"><a class="page-link"
					href="/SpringMVCStudentManagement/List/${crPage}">${crPage}</a></li>
				<li class="page-item"><a class="page-link"
					href="/SpringMVCStudentManagement/List/${crPage+1}">${crPage+1}</a></li>
			</c:otherwise>
		</c:choose>

		<c:if test="${crPage lt totalPage}">
			<li class="page-item"><a class="page-link"
				href="/SpringMVCStudentManagement/List/${crPage+1}">Trang sau</a></li>
			<li class="page-item"><a class="page-link"
				href="/SpringMVCStudentManagement/List/${totalPage}">Trang cuối</a></li>
		</c:if>
	</ul>
	<br />
	<a href="/SpringMVCStudentManagement/List/1">1</a> <a
		href="/SpringMVCStudentManagement/List/2">2</a> <a
		href="/SpringMVCStudentManagement/List/3">3</a> <a
		href="/SpringMVCStudentManagement/empform">Thêm sinh viên</a>
</body>
</html>