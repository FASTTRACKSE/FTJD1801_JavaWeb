<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>THÊM MỘT CHÚT</title>
</head>
<body>
	<div style="width: 300px; margin: 10px;">
		<h1>Thêm sinh viên</h1>
		<form:form method="post" action="/sinhviencrud_springmvc/add"
			enctype="multipart/form-data">
			<table>
				
				<tr>
					<td>Họ tên :</td>
					<td><form:input path="tenSv" class="form-control" /></td>
				</tr>
				<tr>
					<td>Năm sinh :</td>
					<td><form:input path="namSinh" class="form-control" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" class="form-control" /></td>
				</tr>
				<tr>
					<td>Địa chỉ :</td>
					<td><form:input path="diaChi" class="form-control" /></td>
				</tr>
				<tr>
					<td>Lớp :</td>
					<td><form:input path="lop" class="form-control" /></td>
				</tr>
				<tr>
					<td>Images :</td>
					<td><input type="file" name="file" class="btn btn-primary"></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Lưu" class="btn btn-primary" /></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>