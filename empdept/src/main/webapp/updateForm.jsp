<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<table>
<tr>
<td>사번</td><td><input type="hidden" name="empno" value="${dto.empno }"/><td>
</tr>
<tr>
<td>이름</td><td><input type="text" name="ename" value="${dto.ename }"/></td>
</tr>
<tr>
<td>직무</td><td><input type="text" name="job" value="${dto.job }"/></td>
</tr>
<tr>
<td>상사번호</td><td><input type="text" name="mgr" value="${dto.mgr }"/></td>
</tr>
<tr>
<td>월급</td><td><input type="text" name="sal" value="${dto.sal }"/></td>
</tr>
<tr>
<td>수당</td><td><input type="text" name="comm" value="${dto.comm }"/></td>
</tr>
<tr>
<td>부서번호</td><td><input type="text" name="deptno" value="${dto.deptno }"/></td>
</tr>
</table>
<input type="submit" />
</form>
</body>
</html>