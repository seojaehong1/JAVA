<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 화면</title>
</head>
<body>

<h2>회원 가입</h2>
<table>
<form action="regMem.jsp" method="post">
<tr><td>이름:<td/><td><input type ="text" name ="name1"/></td></tr>
<tr><td>주소:<td/><td><input type ="text" name ="address"/></td></tr>
<tr><td>이메일:<td/><td><input type ="text" name ="email"/></td></tr>
<tr><td>전화번호:<td/><td><input type ="text" name = "phone"/></td></tr>
<tr><td><input type = "submit"/></td></tr>
<tr><td><input type = "reset"/></td></tr>
</form>
</table>
</body>
</html>