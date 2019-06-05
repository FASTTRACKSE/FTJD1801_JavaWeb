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
<title>GIỎ HÀNG</title>
</head>
<body>
	
	<center>
		<div style="width: 1200px;">
			<table class="table table-hover">
				<c:forEach var="tempStudent" items="${cart}">
					<tr>
						<td>${tempStudent.maHang}</td>
						<td>${tempStudent.tenHang}</td>
						<td>${tempStudent.donGia}</td>
						<td>${tempStudent.soLuong}</td>
						<c:if test="${empty tempStudent.file}">
							<td>...</td>
						</c:if>
						<c:if test="${not empty tempStudent.file}">
							<td><img src="/DoAn/images/${tempStudent.file}"></td>
						</c:if>
						<td><a href="/DoAn/removeCart/${tempStudent.maHang}"><i class="fas fa-trash-alt"></i></a></td>
					</tr>
				</c:forEach>
				<thead>
					<tr style="color: #005500; background-color: #99FFCC;">
						<td><i class="fas fa-sort-numeric-up"></i></td>
						<td>Tên Hàng</td>
						<td>Đơn Giá</td>
						<td>Số lượng</td>
						<td>Hình ảnh</td>
						<td>Tác vụ</td>
					</tr>
				</thead>
			</table>
			

			<h3 style='float: left;'>
				<a href='/DoAn/datHang'
					class="btn btn-primary btn-lg active">Đặt hàng</a>
			</h3>
			<h3 style='float: left;'>
				<a href='/DoAn/paging/1'
					class="btn btn-primary btn-lg active">Tiếp tục mua hàng</a>
			</h3>
		</div>
	</center>
</body>
</html>