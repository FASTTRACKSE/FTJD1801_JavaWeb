<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1 >Cập nhật sinh viên</h1>
	<form action="doUpdate" method="post" enctype="multipart/form-data">
		<label>ID SV: </label><br>
		<input type="text" name="iDUD" placeholder="Nhập id......" value="${student.iD}"><br>
		<label>họ tên SV: </label><br>
		<input type="text" name="hoTenUD" placeholder="Nhập họ tên......" value="${student.hoTen}"><br>
		<label>năm sinh: </label><br>
		<input type="text" name="dateUD" placeholder="Nhập năm sinh...." value="${student.date}"><br>
		<input type="hidden" id="oldFile" name="oldFile" value="${student.image}">
		<label>Ảnh thờ: </label><br>
		<img alt="null" src="uploads/${student.image}" width="100px" height="120px;"><br><br>
		<label>tải file lên</label>
				<input type="file" name="fileName" class="btn btn-primary" > <br><br>
		<input type="submit" value="Cập nhật">
	</form>
	</div>
</body>
</html>