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
	width: 100px;
	height: 80px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CỬA HÀNG RAU CỦ QUẢ ONLINE</title>
</head>
<body>
	<center>
		<div style="width: 1200px;">
			<form action="/DoAn/viewSearch" method="post">
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
			<table class="table table-hover">
				<c:forEach var="tempStudent" items="${list}">
					<tr>
						<td>${tempStudent.maHang}</td>
						<td>${tempStudent.tenHang}</td>
						<td>${tempStudent.donGia}</td>
						<td>${tempStudent.soLuong}</td>
						<td>${tempStudent.donViTinh}</td>
						<c:if test="${empty tempStudent.file}">
							<td>...</td>
						</c:if>
						<c:if test="${not empty tempStudent.file}">
							<td><img src="/DoAn/images/${tempStudent.file}"></td>
						</c:if>
						<td><a href="/DoAn/addCart/${tempStudent.maHang}"><i
								class="fas fa-cart-arrow-down"></i></a></td>
					</tr>
				</c:forEach>
				<thead>
					<tr style="color: #005500; background-color: #99FFCC;">
						<td><i class="fas fa-sort-numeric-up"></i></td>
						<td>Tên hàng</td>
						<td>Đơn giá</td>
						<td>Số lượng</td>
						<td>Đơn vị tính</td>
						<td>Hình ảnh</td>						
						<td>Tác vụ</td>
					</tr>
				</thead>
			</table>
			<ul class="pagination">
				<c:if test="${crPage != 1}">
					<li class="page-item"><a class="page-link"
						href="/DoAn/paging/1">Trang đầu</a></li>
					<li class="page-item"><a class="page-link"
						href="/DoAn/paging/${crPage-1}">Trang trước</a></li>
				</c:if>

				<c:choose>
					<c:when test="${crPage eq 1}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item active"><a class="page-link"
									href="/DoAn/paging/${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="/DoAn/paging/${crPage+1}">${crPage+1}</a></li>
								<li class="page-item"><a class="page-link"
									href="/DoAn/paging/${crPage+2}">${crPage+2}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="/DoAn/paging/${crPage}">${crPage}</a></li>
								<li class="page-item"><a class="page-link"
									href="/DoAn/paging/${crPage+1}">${crPage+1}</a></li>
							</c:when>
							<c:when test="${totalPage gt 0}">
								<li class="page-item active"><a class="page-link"
									href="/DoAn/paging/${crPage}">${crPage}</a></li>
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${crPage eq totalPage}">
						<c:choose>
							<c:when test="${totalPage gt 2}">
								<li class="page-item"><a class="page-link"
									href="/DoAn/paging/${crPage-2}">${crPage-2}</a></li>
								<li class="page-item"><a class="page-link"
									href="/DoAn/paging/${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="/DoAn/paging/${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item"><a class="page-link"
									href="/DoAn/paging/${crPage-1}">${crPage-1}</a></li>
								<li class="page-item active"><a class="page-link"
									href="/DoAn/paging/${crPage}">${crPage}</a>
							</c:when>
							<c:when test="${totalPage gt 1}">
								<li class="page-item active"><a class="page-link"
									href="/DoAn/paging/${crPage}">${crPage}</a>
							</c:when>
						</c:choose>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="/DoAn/paging/${crPage-1}">${crPage-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/DoAn/paging/${crPage}">${crPage}</a></li>
						<li class="page-item"><a class="page-link"
							href="/DoAn/paging/${crPage+1}">${crPage+1}</a></li>
					</c:otherwise>
				</c:choose>

				<c:if test="${crPage lt totalPage}">
					<li class="page-item"><a class="page-link"
						href="/DoAn/paging/${crPage+1}">Trang sau</a></li>
					<li class="page-item"><a class="page-link"
						href="/DoAn/paging/${totalPage}">Trang cuối</a></li>
				</c:if>
			</ul>
			<h2 style='float: left;'>
				<a href='/DoAn/cart'
					class="btn btn-primary btn-lg active"><i class="fas fa-shopping-cart"></i>${soLuongHang}</a>
			</h2>
		</div>
	</center>
</body>
</html>