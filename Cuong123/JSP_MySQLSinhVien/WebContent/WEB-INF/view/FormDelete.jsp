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
<title>FormDelete.jsp</title>
</head>
<body>
<form action="Delete" method="POST">
<br><fmt:message key="label.studentinfo.id" />: <input type="text" name="id3" value ="${sinhvien.iD}" readonly/>
<br><fmt:message key="label.studentinfo.name" /> : ${sinhvien.hoTen}
<br><fmt:message key="label.studentinfo.tuoi" /> : ${sinhvien.namSinh}
<br><fmt:message key="label.studentinfo.avatar" /><img src="upload/${sinhvien.avatar}" width="100px">
<br><input type="submit" value="<fmt:message key="label.studentinfo.delete" />" />
<a href="DanhSachSinhVien3?page=${pageUpdate}" onclick="return confirm('Are you sure you want to return');"><fmt:message key="label.studentinfo.cancel" /></a>
</form>
</body>
</html>