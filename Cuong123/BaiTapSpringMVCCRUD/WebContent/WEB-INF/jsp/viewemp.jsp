 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1> 
 <a href="/BaiTapSpringMVCCRUD/empform">Add New Employee</a>   
<form action="/BaiTapSpringMVCCRUD/search" method="POST">

Tìm kiếm <input type="text" name="searchTerm">
<input type="submit" value="Tim" />
</form>
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
   <td><img src="/BaiTapSpringMVCCRUD/images/${emp.anhThe}" /></td> 
   <td><a href="/BaiTapSpringMVCCRUD/editemp/${emp.id}">Edit</a></td>  
   <td><a href="/BaiTapSpringMVCCRUD/deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>
<c:choose>
	<c:when test="${currentPage==1}">
		<a href= "/BaiTapSpringMVCCRUD/viewemp/1"> 1 </a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage + 1}"> ${currentPage + 1} </a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage + 1}"> &rsaquo; </a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${totalPage}"> &rsaquo;&rsaquo;  </a>
	</c:when>
	<c:when test="${currentPage==totalPage}">
		<a href= "/BaiTapSpringMVCCRUD/viewemp/1">&lsaquo;&lsaquo; </a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage - 1}"> &lsaquo; </a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage - 1}"> ${currentPage - 1}</a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${totalPage}"> ${totalPage}</a>
	</c:when>
	<c:otherwise>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/1"> &lsaquo;&lsaquo;</a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage - 1}"> &lsaquo;</a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage - 1}"> ${currentPage - 1}</a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage}"> ${currentPage}</a> 
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage + 1}"> ${currentPage + 1}</a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${currentPage + 1}"> &rsaquo;</a>
		<a href= "/BaiTapSpringMVCCRUD/viewemp/${totalPage}"> &rsaquo;&rsaquo; </a>
	</c:otherwise>    
</c:choose>    
  
 