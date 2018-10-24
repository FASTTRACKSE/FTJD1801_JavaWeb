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
<title>label.studentinfo.title</title>
</head>
<body>
<h1> label.studentinfo.listFind </h1>

<form action="Search" method="POST">
label.studentinfo.search <input type="text" id="search" placeholder="Search..." name="search"/>
<select name="index">
<option value="id" selected>label.studentinfo.id</option>
<option value="hoTen">label.studentinfo.name</option>
<option value="namSinh">label.studentinfo.age</option>
</select>
<input type="submit" value="label.studentinfo.search" />
</form>
<a href="FormInsert">label.studentinfo.add</a> 
<table border="1" cellpadding="4" width="60%">
<tr>
<th >label.studentinfo.id</th> 
<th >label.studentinfo.name</th>
<th >label.studentinfo.age</th>
<th >label.studentinfo.action</th> 
</tr>
<c:forEach var="sv" items="${searchList}">
<tr>
<td >${sv.iD}</td>
<td >${sv.hoTen}</td>
<td >${sv.namSinh}</td>
<td ><a href= "FormUpdate?id=${sv.iD}">Sửa</a><a href="FormDelete?id=${sv.iD}">Xóa</a> </td>
</tr>
</c:forEach>
</table>

<a href= "DanhSachSinhVien3?page=${pageFind}">label.studentinfo.back</a>
</body>
</html>