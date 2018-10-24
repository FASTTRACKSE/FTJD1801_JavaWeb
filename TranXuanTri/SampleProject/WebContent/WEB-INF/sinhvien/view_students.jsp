<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="sampleproject.resource.text" />
<!DOCTYPE html>
<html lang="${language}">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Quản lý Sinh viên</title>
</head>
<body>
	<form>
		<select id="language" name="language" onchange="submit()">
			<option value="en_GB" ${language == 'en_GB' ? 'selected' : ''}>English</option>
			<option value="vi_VN" ${language == 'vi_VN' ? 'selected' : ''}>Tiếng
				Việt</option>
		</select>
	</form>
	<h2 align="center">
		<label for="title"><fmt:message key="login.title.list" /></label>
	</h2>
	<fmt:message key="login.button.add" var="buttonAdd" />
	<a href="/SampleProject/formAdd" class="btn btn-info"
		style="margin-left: 10px; margin-bottom: 10px;"> ${buttonAdd} </a>
	
	<form action="/SampleProject/list">
	<fmt:message key="login.label.search" var="search" />
		<input type="search" name="nameSearch"
			placeholder="${search }">
		<button class="btn btn-default" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>

	<table class="table table-striped">
		<thead>
			<tr>
				<th><fmt:message key="login.label.id" /></th>
				<th><fmt:message key="login.label.name" /></th>
				<th><fmt:message key="login.label.age" /></th>
				<th><fmt:message key="login.label.avatar" /></th>
				<th><fmt:message key="login.label.edit" /></th>
			</tr>
		</thead>
		<c:forEach var="sinhVien" items="${students_list}">
			<tr>
				<td>${sinhVien.id}</td>
				<td>${sinhVien.hoTen}</td>
				<td>${2018 - sinhVien.namSinh}</td>
				<td><img src="getimage/${sinhVien.fileName}" class="rounded"
					alt="Ảnh thẻ" width="150"></td>
				<td><a href="/SampleProject/formUpdate?id=${sinhVien.id}"
					class="far fa-edit"></a> <a
					href="/SampleProject/formDelete?id=${sinhVien.id}"
					class="far fa-trash-alt"></a></td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination" style="margin-left: 65%;">
		<c:if test="${pageid != 1}">
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${1}&nameSearch=${nameSearch}"><fmt:message key="login.pagination.firstPage" /></a></li>
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}"><fmt:message key="login.pagination.previous" /></a></li>
		</c:if>
		<c:choose>
			<c:when test="${noOfPages eq 1}">
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
			</c:when>
			<c:when test="${noOfPages eq 2}">
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">1</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">2</a></li>
					</c:when>
					<c:when test="${pageid eq 2}">
						<li class="page-item "><a class="page-link"
							href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">1</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">2</a></li>
					</c:when>
				</c:choose>

			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${pageid eq 1}">
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">${pageid+1}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+2}&nameSearch=${nameSearch}">${pageid+2}</a>
					</c:when>
					<c:when test="${pageid eq noOfPages}">
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid-2}&nameSearch=${nameSearch}">${pageid-2}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">${pageid}</a>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid-1}&nameSearch=${nameSearch}">${pageid-1}</a></li>
						<li class="page-item active"><a class="page-link"
							href="/SampleProject/list?page=${pageid}&nameSearch=${nameSearch}">${pageid}</a></li>
						<li class="page-item"><a class="page-link"
							href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}">${pageid+1}</a></li>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<c:if test="${pageid lt noOfPages}">
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${pageid+1}&nameSearch=${nameSearch}"><fmt:message key="login.pagination.next" /></a></li>
			<li class="page-item"><a class="page-link"
				href="/SampleProject/list?page=${noOfPages}&nameSearch=${nameSearch}"><fmt:message key="login.pagination.lastPage" /></a></li>
		</c:if>
	</ul>
</body>
</html>