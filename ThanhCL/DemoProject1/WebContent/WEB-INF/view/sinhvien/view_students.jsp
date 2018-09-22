<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách sinh viên khoá 18 thân yêu</title>
</head>
<body>

<body> 
<table>
<c:forEach var="tempStudent" items="${student_list}">
<tr>
<td>${tempStudent.ID}</td>
<td>${tempStudent.hoTen}</td>
<td>${tempStudent.namSinh}</td>
</tr> 
</c:forEach>
</table>
</body> 

</body>
</html>