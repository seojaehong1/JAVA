<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logout" method="post">
<c:choose>
<c:when test="${userId==null }">
${param.Id }님 로그인1
</c:when>
<c:when test="${userId!=null }">
 ${userId }님 로그인2
</c:when>
</c:choose> 
<input type="submit" value="로그아웃"> 
        </form>
</body>
</html>