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
  
  
        <h1>CẬP NHẬT THÔNG TIN</h1>  
       <form:form method="POST" action="/SpringMVCStudentManagement/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="maSV" /></td>  
         </tr>   
         <tr>    
          <td>Tên sinh viên : </td>   
          <td><form:input path="tenSV"  /></td>  
         </tr>    
         <tr>    
          <td>Năm sinh :</td>    
          <td><form:input path="namSinh" /></td>  
         </tr>   
         <tr>    
          <td>Avatar :</td>    
          <td><form:input path="avatar" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>
</html>