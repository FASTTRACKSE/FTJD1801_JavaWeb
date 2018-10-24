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
<title><fmt:message key="label.studentinfo.title" /></title>

</head>
<body>
 <form>
            <select id="language" name="language" onchange="submit()">
                <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
                <option value="vi_VN" ${language == 'vi_VN' ? 'selected' : ''}>Vietnamese</option>
                <option value="ja_JP" ${language == 'ja_JP' ? 'selected' : ''}>Japanese</option>
            </select>
        </form>
<h1> <fmt:message key="label.studentinfo.title" /> Page No: ${currentPage}</h1>

<form action="Search?page=${currentPage}" method="POST">
Tìm kiếm <input type="text" id="search" placeholder="Search..." name="search"/>
<select name="index">
<option value="id" selected><fmt:message key="label.studentinfo.id" /></option>
<option value="hoTen"><fmt:message key="label.studentinfo.name" /></option>
<option value="namSinh"><fmt:message key="label.studentinfo.age" /></option>
</select>
<input type="submit" value="<fmt:message key="label.studentinfo.search" />" />
</form>
<a href="FormInsert"><fmt:message key="label.studentinfo.add" /></a> 
<table border="1" cellpadding="4" width="60%">
<tr>
<th ><fmt:message key="label.studentinfo.id" /></th> 
<th ><fmt:message key="label.studentinfo.name" /></th>
<th ><fmt:message key="label.studentinfo.age" /></th>
<th ><fmt:message key="label.studentinfo.avatar" /></th>
<th ><fmt:message key="label.studentinfo.action" /></th>
</tr>
<c:forEach var="sv" items="${student_list}">
<tr>
<td >${sv.iD}</td>
<td >${sv.hoTen}</td>
<td >${sv.namSinh}</td>
<td ><img src="upload/${sv.avatar}" width="50px">
<td ><a href= "FormUpdate?id=${sv.iD}&page=${currentPage}">Sửa</a><a href="FormDelete?id=${sv.iD}&page=${currentPage}">Xóa</a> </td>
</tr>
</c:forEach>
</table>
<c:choose>
	<c:when test="${currentPage==1}">
		<a href= "DanhSachSinhVien3?page=1"> 1 </a>
		<a href= "DanhSachSinhVien3?page=${currentPage + 1}"> ${currentPage + 1} </a>
		<a href= "DanhSachSinhVien3?page=${currentPage + 1}"> &rsaquo; </a>
		<a href= "DanhSachSinhVien3?page=${totalPage}"> &rsaquo;&rsaquo;  </a>
	</c:when>
	<c:when test="${currentPage==totalPage}">
		<a href= "DanhSachSinhVien3?page=1">&lsaquo;&lsaquo; </a>
		<a href= "DanhSachSinhVien3?page=${currentPage - 1}"> &lsaquo; </a>
		<a href= "DanhSachSinhVien3?page=${currentPage - 1}"> ${currentPage - 1}</a>
		<a href= "DanhSachSinhVien3?page=${totalPage}"> ${totalPage}</a>
	</c:when>
	<c:otherwise>
		<a href= "DanhSachSinhVien3?page=1"> &lsaquo;&lsaquo;</a>
		<a href= "DanhSachSinhVien3?page=${currentPage - 1}"> &lsaquo;</a>
		<a href= "DanhSachSinhVien3?page=${currentPage - 1}"> ${currentPage - 1}</a>
		<a href= "DanhSachSinhVien3?page=${currentPage}"> ${currentPage}</a> 
		<a href= "DanhSachSinhVien3?page=${currentPage + 1}"> ${currentPage + 1}</a>
		<a href= "DanhSachSinhVien3?page=${currentPage + 1}"> &rsaquo;</a>
		<a href= "DanhSachSinhVien3?page=${totalPage}"> &rsaquo;&rsaquo; </a>
	</c:otherwise>    
</c:choose>
</body>
</html>
