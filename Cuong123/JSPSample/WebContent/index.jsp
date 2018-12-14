<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tinh tong</title>
</head>
<body>
<%! int soA, soB;
int tinhTong (int a, int b) { 
	return a + b;
} 
%> 
<% if(request.getParameter("soA") == null ){
	
	response.sendRedirect("form-nhap.jsp");
}else {
	
	soA = Integer.parseInt(request.getParameter("soA"));
}
soB = Integer.parseInt(request.getParameter("soB"));
%>
 
Tổng So A + So B =<%=soA%> + <%=soB%> = <%= tinhTong(soA, soB) %>

</body>
</html>