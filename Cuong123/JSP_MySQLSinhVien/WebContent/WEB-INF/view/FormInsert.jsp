<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="sinhvien.resources.languagepack" />
<!DOCTYPE html>
<html lang="${language}">
<head>
<meta charset="UTF-8">
<title>FormInsert</title>
</head>
<body>
<form action="Insert" method="POST" enctype="multipart/form-data">
<fmt:message key="label.studentinfo.id" /> : <input type="text" name="id"/>
<br><fmt:message key="label.studentinfo.name" /> : <input type="text" name="hoTen" />
<br><fmt:message key="label.studentinfo.age" /> : <input type="text" name="namSinh" />
<br><fmt:message key="label.studentinfo.avatar" />:<input type="file" name="fileName">
<br><input type="submit" value="<fmt:message key="label.studentinfo.accept" /> ">
<a href="DanhSachSinhVien3" onclick="return confirm('Are you sure you want to return');"><fmt:message key="label.studentinfo.cancel" /></a>
</form>
</body>
</html>