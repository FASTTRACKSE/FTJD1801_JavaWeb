<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thêm sinh viên</h1>
	<form:form method="POST" action="save" enctype="multipart/form-data">
		Họ tên:<form:input path="hoTen" />
		<br>
		Năm sinh:<form:input path="namSinh" />
		<br>
		Email:<form:input path="email" />
		<br>
		Giới tính:<form:input path="gioiTinh" />
		<br>
		Địa chỉ:<form:input path="diaChi" />
		<br>
		Lớp học:<form:input path="lopHoc" />
		<br>
		Chọn ảnh: <input type="file" name="file">
		<br>
		<input class="btn btn-info" type="submit" value="Save" />
	</form:form>
	<a class="btn btn-info" href="viewAll/1">Cancel</a>
</body>
</html>