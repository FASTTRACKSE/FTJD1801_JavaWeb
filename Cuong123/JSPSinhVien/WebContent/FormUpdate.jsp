<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormUpdate.jsp</title>
</head>
<body>

<form action="Update" method="POST">
ID: <input type="text" name="id2" value ="${sinhvien.iD}" readonly />
<br>Họ tên: <input type="text" name="firstName2" value = "${sinhvien.hoTen}" />
<br>Năm Sinh: <input type="text" name="age2" value ="${sinhvien.namSinh}" />
<br><input type="submit" value="Submit" />
<a href="DanhSachSinhVien2" onclick="return confirm('Are you sure you want to return');">Cancel</a>
</form>


</body>
</html>