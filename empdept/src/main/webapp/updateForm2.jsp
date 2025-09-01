<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="update2">
<table>
<tr><td>부서번호</td><td>부서이름</td><td>부서지</td>
</tr>
<tr>
<td><input type="text" name="deptno" value="${dto.deptno }"/></td>
<td><input type="text" name="dname" value="${dto.dname }"/></td>
<td><input type="text" name="loc" value="${dto.loc }"/></td>
<td><input type="submit" /></td>
</tr>
</table>
</form>
</body>
</html>