<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str ="가나다";
request.setAttribute("str", str);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start</title>
</head>
<body>
${greaterThen = (a,b) -> a > b ? true : false ;''}
${greaterThen(10,30) }
${str }
</body>
</html>