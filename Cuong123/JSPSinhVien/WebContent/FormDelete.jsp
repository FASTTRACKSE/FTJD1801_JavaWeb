<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormDelete.jsp</title>
</head>
<body>
<form action="Delete" method="POST">
<br>ID: <input type="text" name="id3" value ="${sinhvien.iD}" readonly/>
<br>Họ tên : ${sinhvien.hoTen}
<br>Tuoi : ${sinhvien.namSinh}
<br><input type="submit" value="Submit" />
<a href="DanhSachSinhVien2" onclick="return confirm('Are you sure you want to return');">Cancel</a>
</form>
</body>
</html>