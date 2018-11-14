<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Sinh Viên</title>
</head>
<body>
	<h1>Edit Sinh Viên</h1>
	<form:form method="POST" action="/editsave">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Mã sinh viên :</td>
				<td><form:input path="maSv" /></td>
			</tr>
			<tr>
				<td>Tên sinh viên :</td>
				<td><form:input path="tenSv" /></td>
			</tr>
			<tr>
				<td>Năm sinh :</td>
				<td><form:input path="namSinh" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Giới tính :</td>
				<td><form:input path="gioiTinh" /></td>
			</tr>
			<tr>
				<td>Địa chỉ :</td>
				<td><form:input path="diaChi" /></td>
			</tr>
			<tr>
				<td>Lớp học :</td>
				<td><form:input path="lop" /></td>
			</tr>
			<tr>
				<td>Ảnh thẻ :</td>
				<td><form:input path="image" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
