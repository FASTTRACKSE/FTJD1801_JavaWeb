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
<title>SỬA TOÀN BỘ</title>
</head>
<body>

	<div style="width: 300px; margin: 10px;">
		<h1>Cập nhật thông tin</h1>
		<form:form method="POST"
			action="/StudentManagement_SpringMVC/editsave">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="maSV" class="form-control" /></td>
				</tr>
				<tr>
					<td>Họ tên :</td>
					<td><form:input path="tenSV" class="form-control" /></td>
				</tr>
				<tr>
					<td>Năm sinh :</td>
					<td><form:input path="namSinh" class="form-control" /></td>
				</tr>
				<tr>
					<td>Avatar :</td>
					<td><form:input path="avatar" class="form-control" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Cập nhật"
						class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>