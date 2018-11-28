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
		
	<c:choose>
		<c:when test="${edit}">
			<h2>Update</h2>
		</c:when>
		<c:when test="${delete}">
			<h2>Delete</h2>
		</c:when>
		<c:otherwise>
			<h2>Add New</h2>
		</c:otherwise>
	</c:choose>
	<form:form method="POST" modelAttribute="student"
		enctype="multipart/form-data" class="form-group">
		<form:input type="text" path="maSV" id="maSV" />
		<table>
			<tr>
				<td><label for="tenSV">Name: </label></td>
				<td><form:input path="tenSV" id="tenSV" class="form-control"/></td>
				<td><form:errors path="tenSV" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="namSinh">Date of birth: </label></td>
				<td><form:input path="namSinh" id="namSinh" class="form-control"/></td>
				<td><form:errors path="namSinh" cssClass="error" /></td>
			</tr>
		</table>
		<c:choose>
			<c:when test="${edit}">
				<label for="avatar" > Avatar: </label>
				<input type="file" name="file" id="stuClass" class="btn btn-primary"/>
				<form:errors path="avatar" cssClass="error" />
				<br>
				<br>
				<form:input type="hidden" path="avatar" id="avatar" class="btn btn-primary"/>
				<input class="btn btn-primary" type="submit" value="Update" />
				<a href="<c:url value='/list' />" class="btn btn-primary">Cancel</a>
			</c:when>
			<c:when test="${delete}">
				Avatar: <img src="/StudentManagement_HibernateMVC/images/${student.avatar}"
					class="rounded" width="100" height="100" />
				<br>
				<br>
				<input class="btn btn-primary" type="submit" value="Delete" />
				<a href="<c:url value='/list' />" class="btn btn-primary">Cancel</a>
			</c:when>
			<c:otherwise>
				<label for="avatar"> Avatar: </label>
				<input type="file" name="file" id="stuClass" class="btn btn-primary"/>
				<form:errors path="avatar" cssClass="error" />
				<br>
				<br>
				<input  type="submit" value="Register" class="btn btn-primary"/>
				<a href="<c:url value='/list' />"  class="btn btn-primary">Cancel</a>
			</c:otherwise>
		</c:choose>
	</form:form>
	</div>
</body>
</html>