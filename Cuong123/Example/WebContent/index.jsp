<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="uploadForm" action="upload.jsp" enctype="multipart/form-data" method="post">
              <input type="file" name="file"/>
              <input TYPE=Button name='Upload' Value='Upload' onClick="uploadForm.Upload.value='Uploading...';document.uploadForm.action='upload.jsp';document.uploadForm.submit()">
          </form>

</body>
</html>