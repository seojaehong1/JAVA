<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form>
버튼을 누르시면 다음 페이지로 이동됩니다. 그후 다음페이지의 버튼을
다시 눌러주세요.
<input type="submit" value="버튼" /> </br>
<%
LocalDateTime now = LocalDateTime.now();
String formattedTime = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
request.setAttribute("currentTime", formattedTime);
request.getRequestDispatcher("game1.jsp").forward(request, response);
%>
</body>
</html>