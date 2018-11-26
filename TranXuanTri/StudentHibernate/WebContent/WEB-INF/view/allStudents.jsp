<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Manager</title>
</head>
<body>

	<h1>List Students</h1>
	<a class="btn btn-info" href="<c:url value='/new' />">Add new
		student</a>

	<form action="/StudentHibernate/search" method="POST">
		<input type="text" name="searchName" placeholder="Search...">
		<button class="btn btn-default" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date of birth</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Class</th>
			<th>Avatar</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${listStudents}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.dateOfBirth}</td>
				<td>${student.email}</td>
				<td>${student.gender}</td>
				<td>${student.address}</td>
				<td>${student.stuClass}</td>
				<td><img src="/StudentHibernate/images/${student.avatar}"
					class="rounded" width="50" height="50" /></td>
				<td><a href="<c:url value='/edit-${student.id}-student' />">edit</a></td>
				<td><a href="<c:url value='/delete-${student.id}-student' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination" style="margin-left: 65%;">
		<c:if test="${pageid != 1}">
			<li class="page-item"><a class="page-link"
				href="/StudentHibernate/list/1">Fisrt page</a></li>
			<li class="page-item"><a class="page-link"
				href="/StudentHibernate/list/${pageid -1 }">Previous page</a></li>
		</c:if>
		<c:choose>
			<c:when test="${noOfPages eq 1}">
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
			</c:when>
			<c:when test="${noOfPages eq 2}">
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/StudentHibernate/list/${pageid}">1</a></li>
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid+1}">2</a></li>
					</c:when>
					<c:when test="${pageid eq 2}">
						<li class="page-item "><a class="page-link"
							href="/StudentHibernate/list/${pageid-1}">1</a></li>
						<li class="page-item active"><a class="page-link"
							href="/StudentHibernate/list/${pageid} ">2</a></li>
					</c:when>
				</c:choose>

			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/StudentHibernate/list/${pageid} ">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid+1} ">${pageid+1}</a></li>
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid+2} ">${pageid+2}</a>
					</c:when>
					<c:when test="${pageid eq noOfPages}">
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid-2} ">${pageid-2}</a></li>
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid-1} ">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/StudentHibernate/list/${pageid} ">${pageid}</a>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid-1} ">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/StudentHibernate/list/${pageid} ">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/StudentHibernate/list/${pageid+1} ">${pageid+1}</a></li>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<c:if test="${pageid lt noOfPages}">
			<li class="page-item"><a class="page-link"
				href="/StudentHibernate/list/${pageid+1}">Next page</a></li>
			<li class="page-item"><a class="page-link"
				href="/StudentHibernate/list/${noOfPages} ">Last page</a></li>
		</c:if>
	</ul>
</body>
</html>