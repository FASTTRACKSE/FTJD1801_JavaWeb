<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="fasttrackse.multilingualproject.resources.languagepack" />
<!DOCTYPE html>
<html lang="${language}">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title><fmt:message key="label.studentinfo.title" /></title>
</head>
<body>
	<form>
		<select id="language" name="language" onchange="submit()">
			<option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
			<option value="vi_VN" ${language == 'vi_VN' ? 'selected' : ''}>Tiếng Việt</option>
			<option value="ja_JP" ${language == 'ja_JP' ? 'selected' : ''}>日本語</option>
		</select>
		<a href="StudentInfo?language=fr_FR">Tiếng Pháp</a>
		<a href="StudentInfo?language=it_IT">Tiếng Ý</a>
	</form>
	<hr />
	<h2><fmt:message key="label.studentinfo.title" /></h2>
	<form action="" method="post" class="form-group">
		<table>
			<tr>
				<td><fmt:message key="label.studentinfo.id" />:</td>
				<td><input type="text" name="idDelete" value="${student.ID}"
					readonly></td>
			</tr>
			<tr>
				<td><fmt:message key="label.studentinfo.name" />:</td>
				<td><input type="text" name="name" value="${student.hoTen}"
					readonly></td>
			</tr>
			<tr>
				<td><fmt:message key="label.studentinfo.age" />:</td>
				<td><input type="text" name="birthday"
					value="${2018 - student.namSinh}" readonly></td>
			</tr>
		</table>
	</form>
</body>
</html>