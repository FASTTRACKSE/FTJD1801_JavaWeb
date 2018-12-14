<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
        <h1>Add New Employee</h1>  
       <form:form method="post" action="save"  enctype="multipart/form-data">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Tuoi</td>    
          <td><form:input path="tuoi" /></td>  
         </tr>   
         <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
         <tr>    
          <td>Gioi tinh :</td>    
          <td><form:input path="gioiTinh" /></td>  
         </tr>   
         <tr> 
         <tr>    
          <td>Dia chi :</td>    
          <td><form:input path="diaChi" /></td>  
         </tr>   
         <tr> 
         <tr>    
          <td>Lop hoc :</td>    
          <td><form:input path="lopHoc" /></td>  
         </tr>   
         <tr> 
         <tr>    
          <td>Anh the :</td>    
          <td>Select File: <input type="file" name="file"/>  </td>  
         </tr>   
         <tr> 
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>   