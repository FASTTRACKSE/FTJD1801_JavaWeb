 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Tuoi</th><th>Email</th><th>Gioi tinh</th><th>Dia chi</th><th>Lop Hoc</th><th>Anh The</th>th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.tuoi}</td>  
   <td>${emp.email}</td> 
   <td>${emp.gioiTinh}</td>
   <td>${emp.diaChi}</td>
   <td>${emp.lopHoc}</td>
   <td>${emp.anhThe}</td> 
   <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>  