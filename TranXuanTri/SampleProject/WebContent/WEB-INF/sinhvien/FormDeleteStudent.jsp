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
<title><fmt:message key="login.title.delete" /></title>
</head>
<body>
	<h2 ><fmt:message key="login.title.delete" /></h2>
	<form action="/SampleProject/delete" method="post"
		class="form-group">
		
		<fmt:message key="login.label.id" />: <input type="text" name="idDelete" value ="${student_delete.id}" readonly><br>
		<fmt:message key="login.label.name" />: <input type="text" name="name" value ="${student_delete.hoTen}" readonly><br>
		<fmt:message key="login.label.year" />: <input type="text" name="birthday" value ="${student_delete.namSinh}" readonly><br>
		<fmt:message key="login.label.avatar" />: <img src="getimage/${student_delete.fileName}" class="rounded" alt="Ảnh thẻ"> <br>
		<fmt:message key="login.button.delete" var="buttonDelete"/>
		<input type="submit" class="btn btn-info" value="${buttonDelete}"> 
		<fmt:message key="login.button.cancel" var="buttonCancel"/>
		<a href="/SampleProject/list" class="btn btn-info"> ${buttonCancel} </a>
	</form>
</body>
</html>