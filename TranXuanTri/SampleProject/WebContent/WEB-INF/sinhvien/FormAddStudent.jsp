<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title><fmt:message key="login.title.add" /></title>
</head>
<body>
	<h2 ><fmt:message key="login.title.add" /></h2>
	<form action="/SampleProject/insert" method="POST" class="form-group" enctype="multipart/form-data">
		<fmt:message key="login.label.id" />: <input type="text" name="id" ><br> 
		<fmt:message key="login.label.name" />: <input type="text" name="name"><br>
		<fmt:message key="login.label.year" />: <input type="text" name="birthday"><br>
		<fmt:message key="login.label.avatar" />:<input type="file" name="fileName"><br>
		<fmt:message key="login.button.add" var="buttonAdd"/>
		<input type="submit" class="btn btn-info" value="${buttonAdd }">
		<fmt:message key="login.button.cancel"  var="buttonCancel"/>
		<a href="/SampleProject/list" class="btn btn-info"> ${buttonCancel}</a>
	</form>
</body>
</html>