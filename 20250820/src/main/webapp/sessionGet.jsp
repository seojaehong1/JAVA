<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${sessionScope.userId }</p> 
<p>${sessionScope.aaa }</p> 
<%
String str = (String)session.getAttribute("userId");

%>
<%=str %>
</body>
</html>