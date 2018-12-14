<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Tuoi</th><th>Email</th><th>Gioi tinh</th><th>Dia chi</th><th>Lop Hoc</th><th>Anh The</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.tuoi}</td>  
   <td>${emp.email}</td> 
   <td>${emp.gioiTinh}</td>
   <td>${emp.diaChi}</td>
   <td>${emp.lopHoc}</td>
   <td><img src="/SinhVienSpringHibernate/images/${emp.anhThe}" /></td> 
   <td><a href="/SinhVienSpringHibernate/editemp/${emp.id}">Edit</a></td>  
   <td><a href="/SinhVienSpringHibernate/deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
</body>
</html>