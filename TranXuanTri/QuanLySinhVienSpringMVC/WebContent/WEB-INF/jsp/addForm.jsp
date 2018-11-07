<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Thêm sinh viên</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Họ tên: </td>   
          <td><form:input path="hoTen"  /></td>  
         </tr>    
         <tr>    
          <td>Năm sinh:</td>    
          <td><form:input path="namSinh" /></td>  
         </tr>   
         <tr>    
          <td>Email:</td>    
          <td><form:input path="email" /></td>  
         </tr>
         <tr>    
          <td>Giới tính:</td>    
          <td><form:input path="gioiTinh" /></td>  
         </tr>
         <tr>    
          <td>Địa chỉ:</td>    
          <td><form:input path="diaChi" /></td>  
         </tr>
         <tr>    
          <td>Lớp học:</td>    
          <td><form:input path="lopHoc" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
       <a href="viewAll">Cancel</a>
</body>
</html>