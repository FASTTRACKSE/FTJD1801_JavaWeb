<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang JSP Đầu tiên của tôi</title>
</head>
<body>
<h1>Hello World by JSP!!!</h1>
<%!
int soA, soB;
public int tinhTong(int a, int b) {
	return (a + b);
}
%>

<% 
if (request.getParameter("a") != null) {
	soA = Integer.parseInt(request.getParameter("a"));
}

if (request.getParameter("b") != null) {
	soB = Integer.parseInt(request.getParameter("b"));
}
%>

<h2>Chương trình tính tổng hai số A và B</h2>
<h2>-------------------------------------------</h2>
<h3>Số A = <%=soA %></h3>
<h3>Số B = <%=soB %></h3>
<h3>Tổng A + B = <%=tinhTong(soA, soB) %></h3>
<h2>-------------------------------------------</h2>

</body>
</html>