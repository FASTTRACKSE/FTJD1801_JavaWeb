<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Student Information</title>
</head>
<body>
	<h2>Student Information</h2>
	<form action="" method="post" class="form-group">
		<table>
			<tr>
				<td><fmt:message key="label.studentinfo.id" />:</td>
				<td><input type="text" name="idDelete" value="${student.ID}"
					readonly></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${student.hoTen}"
					readonly></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="birthday"
					value="${2018 - student.namSinh}" readonly></td>
			</tr>
		</table>
	</form>
</body>
</html>