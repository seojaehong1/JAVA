<%@page import="study.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Student stu = new Student("서재홍","하남","3030");
request.setAttribute("hong", stu);

%>

<jsp:forward page="to.jsp"/>

</body>
</html>