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
<title>FormUpdate.jsp</title>
</head>
<body>

<form action="Update" method="POST"enctype="multipart/form-data" >
label.studentinfo.id: <input type="text" name="id" value ="${sinhvien.iD}" readonly />
<br>label.studentinfo.name: <input type="text" name="hoTen" value ="${sinhvien.hoTen}" />
<br>label.studentinfo.age: <input type="text" name="namSinh" value ="${sinhvien.namSinh}" />
<br><img src="upload/${sinhvien.avatar}" width="100px">
<br><input type="hidden" name="image"  value ="${sinhvien.avatar}" />
<br>label.studentinfo.changeAvatar:<input type="file" name="fileName">
<br><input type="submit" value="label.studentinfo.accept" />
<a href="DanhSachSinhVien3?page=${currentPage}" onclick="return confirm('Are you sure you want to return');">label.studentinfo.cancel</a>
</form>
</body>
</html>