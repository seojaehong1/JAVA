<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>


<form action="logout.jsp" method="post">  
<c:choose>
<c:when test="${userId==null }">
${param.Id }님 로그인1
</c:when>
</c:choose> 
<input type="submit" value="로그아웃">
</form>

<form action="login1.jsp" method="post"> 
    아이디:   <input type="text"     name="id">&nbsp;&nbsp;
    비밀번호: <input type="password" name="pw">
            <input type="submit" value="로그인">
</form>


</body>
</html>