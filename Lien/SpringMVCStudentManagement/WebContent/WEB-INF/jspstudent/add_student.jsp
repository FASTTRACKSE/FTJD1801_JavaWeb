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
    
  
        <h1>THÊM SINH VIÊN</h1>  
       <form:form method="post" action="save" enctype="multipart/form-data">    
        <table >    
         <tr>    
          <td>TenSV : </td>   
          <td><form:input path="tenSV"  /></td>  
         </tr>    
         <tr>    
          <td>NamSinh :</td>    
          <td><form:input path="namSinh" /></td>  
         </tr>   
         <tr>    
          <td>Avatar :</td>    
          <td>Select File: <input type="file" name="file"/> </td>  
          
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
</body>
</html>