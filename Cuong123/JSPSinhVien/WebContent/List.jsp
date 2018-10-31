<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
<title>Thông tin sinh viên</title>
</head>
<body>
<br><a href="FormInsert.jsp">Thêm Sinh Viên</a> <table border="1">
<tr>
<td width="50px">id</td> 
<td width="200px">Họ tên</td>
<td width="50px">Tuổi</td>
<td width="100px">Ảnh</td>

<td width="100px">Action</td>
</tr>
<c:forEach var="sv" items="${student_list}">

<tr>
<td width="50px">${sv.iD}</td>
<td width="200px">${sv.hoTen}</td>
<td width="50px">${sv.namSinh}</td>
<td ><img src="${sv.avatar}" width="100px">
<td width="100px"><a href= "FormUpdate?id=${sv.iD}">Sửa</a><a href="FormDelete?id=${sv.iD}">Xóa</a> </td>

</tr>

</c:forEach>
</table>
</body>
</html>