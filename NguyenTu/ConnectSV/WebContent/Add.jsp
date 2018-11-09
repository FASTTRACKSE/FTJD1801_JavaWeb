<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>Quản lí sinh viên</title>
</head>
<body>
<div align="center">
	<h1 >Add sinh viên</h1>
	<form action="doAdd" method="post" enctype="multipart/form-data">
		<label>Nhập id SV: </label><br>
		<input type="text" name="iD" placeholder="Nhập id ......"><br>
		<label>Nhập họ tên SV: </label><br>
		<input type="text" name="hoTen" placeholder="Nhập họ tên......"><br>
		<label>Nhập năm sinh: </label><br>
		<input type="text" name="date" placeholder="Nhập năm sinh...."><br>
		<label>Images: </label><br>
		<input type="text" name="image" placeholder="Image......"><br>
		<input type="submit" value="Add">
	</form>
	</div>
</body>
</html>