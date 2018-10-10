<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Danh sách sinh viên</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<form action="sv" method="post">
				<div style="width: 300px; float: left;">
					<div class="input-group mb-3">
						<input type="text" name="search" class="form-control"
							placeholder="Tìm kiếm...">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit"
								id="button-addon2">
								<i class="fas fa-search"></i>Search
							</button>
						</div>
					</div>
				</div>
			</form>
	<table class="table">
		<tr>
				
				<td>Mã SV</td>
				<td>Họ và tên</td>
				<td>Năm sinh</td>
			</tr>
		<c:forEach var="tempStudent" items="${student_list}">

			<tr>
				
				<td>${tempStudent.iD}</td>
				<td>${tempStudent.hoTen}</td>
				<td>${tempStudent.date}</td>
				<td><h4><a href='update?iDUD=${tempStudent.iD}'>Edit </a><a href='remove?iDUD=${tempStudent.iD}' onclick="return confirm('Are you sure you want to delete this item?');"> Xóa</a> </h4></td>
			</tr>

		</c:forEach>
		
	</table>
	<a href="add">Thêm sinh viên</a>
	<ul class="pagination">
				<c:if test="${crPage != 1}">
					<li class="page-item"><a class="page-link" href="sv?page=1">Trang
							đầu</a></li>
					<li class="page-item"><a class="page-link"
						href="sv?page=${crPage-1}">Trang trước</a></li>
				</c:if>

				<c:choose>
					<c:when test="${crPage eq 1}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item active"><a class="page-link"
									href="sv?page=${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="sv?page=${crPage+1}">${crPage+1}</a></li>
								<li class="page-item"><a class="page-link"
									href="sv?page=${crPage+2}">${crPage+2}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="sv?page=${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="sv?page=${crPage+1}">${crPage+1}</a></li>
							</c:when>
							<c:when test="${totalPage gt 0}">
								<li class="page-item active"><a class="page-link"
									href="sv?page=${crPage}">${crPage}</a></li>
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${crPage eq totalPage}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item"><a class="page-link"
									href="sv?page=${crPage-2}">${crPage-2}</a></li>
								<li class="page-item"><a class="page-link"
									href="sv?page=${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="sv?page=${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item"><a class="page-link"
									href="sv?page=${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="sv?page=${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="sv?page=${crPage}">${crPage}</a>
							</c:when>
						</c:choose>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="sv?page=${crPage-1}">${crPage-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="sv?page=${crPage}">${crPage}</a></li>
						<li class="page-item"><a class="page-link"
							href="sv?page=${crPage+1}">${crPage+1}</a></li>
					</c:otherwise>
				</c:choose>

				<c:if test="${crPage lt totalPage}">
					<li class="page-item"><a class="page-link"
						href="sv?page=${crPage+1}">Trang kế</a></li>
					<li class="page-item"><a class="page-link"
						href="sv?page=${totalPage}">Trang cuối</a></li>
				</c:if>
			</ul>
			
</body>
</html>