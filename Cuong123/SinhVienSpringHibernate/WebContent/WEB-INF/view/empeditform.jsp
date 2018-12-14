<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/SinhVienSpringHibernate/editsave" enctype="multipart/form-data">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Tuoi	 :</td>    
          <td><form:input path="tuoi" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>
           <tr>    
          <td>Gioi tinh :</td>    
          <td><form:input path="gioiTinh" /></td>  
         </tr>  
           <tr>    
          <td>Dia Chi :</td>    
          <td><form:input path="diaChi" /></td>  
         </tr>  
           <tr>    
          <td>Lop Hoc :</td>    
          <td><form:input path="lopHoc" /></td>  
         </tr>  
           <tr>    
          <td>Anh the</td>    
          <td><img src="/SinhVienSpringHibernate/images/${command.anhThe}" /></td>
          <td><form:input type ="hidden" path="anhThe" /></td>  
          <td>Select File: <input type="file" name="file"/></td>  
         </tr>     
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    