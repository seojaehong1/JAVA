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
<form action="regMember.jsp" method="post">
<tr><td>이름:</td><td><input type="text" name="kname" /></td></tr>
<tr><td>주소:</td><td><input type="text" name="addr" /></td></tr>
<tr><td>email:</td><td><input type="text" name="email" /></td></tr>
<tr><td>전화번호:</td><td><input type="text" name="phone" /></td></tr>
<tr><td><input type="submit" /></td><td><input type="reset" /></td></tr>
</form>
</table>
</body>
</html>