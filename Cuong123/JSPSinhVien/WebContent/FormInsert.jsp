<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormInsert</title>
</head>
<body>
<form action="Insert" method="POST" enctype="multipart/form-data">
ID: <input type="text" name="id"/>
<br>Họ tên: <input type="text" name="hoTen" />
<br>Năm sinh : <input type="text" name="namSinh" />
<br>Select File to Upload:
<br><input type="file" name="fileName">
<br><input type="submit" value="Upload">
<a href="DanhSachSinhVien3" onclick="return confirm('Are you sure you want to return');">Cancel</a>
</form>
</body>
</html>