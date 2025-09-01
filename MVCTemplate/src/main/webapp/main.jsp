<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="b?val=홍길동">명령어 연습</a>


<form action = "c">
<input type = "text" name ="nn" value="${val }"/><br/>
<input type = "submit"/><br/>
<input type = "text" name = "n2" value="${res }"/>

</form>
</body>
</html>