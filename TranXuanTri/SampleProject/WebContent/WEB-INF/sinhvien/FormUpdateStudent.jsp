<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="sampleproject.resource.text" />
<!DOCTYPE html>
<html lang="${language}">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Update student</title>
</head>
<body>

<h2><fmt:message key="login.title.update" /></h2>
	<form action="/SampleProject/update" method="POST" class="form-group" enctype="multipart/form-data">
		<fmt:message key="login.label.id" />: <input type="text" name="idUpdate" value ="${student_update.id}" readonly><br>
		<fmt:message key="login.label.name" />: <input type="text" name="nameUpdate" value ="${student_update.hoTen}"><br>
		<fmt:message key="login.label.year" />: <input type="text" name="birthdayUpdate" value ="${student_update.namSinh}"><br>
		<fmt:message key="login.label.avatar" />: <input type="file" name="imageUpdate" ><br>
		<input type="hidden" name="image" value="${student_update.fileName}">
		<fmt:message key="login.button.update" var="buttonUpdate" />
		<input type="submit" class="btn btn-info" value="${buttonUpdate}"> 
		<fmt:message key="login.button.cancel" var="buttonCancel" />
		<a href="/SampleProject/list" class="btn btn-info"> ${buttonCancel} </a>
	</form>
</body>
</html>