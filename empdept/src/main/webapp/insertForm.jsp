<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert">
<table>
<tr>
<td>사번</td><td><input type="text" name="empno" /></td>
</tr>
<tr>
<td>이름</td><td><input type="text" name="ename" /></td>
</tr>
<tr>
<td>직무</td><td><input type="text" name="job" /></td>
</tr>
<tr>
<td>상사번호</td><td><input type="text" name="mgr" /></td>
</tr>
<tr>
<td>입사일</td><td><input type="text" name="hiredate" /></td>
</tr>
<tr>
<td>월급</td><td><input type="text" name="sal" /></td>
</tr>
<tr>
<td>수당</td><td><input type="text" name="comm" /></td>
</tr>
<tr>
<td>부서번호</td><td><input type="text" name="deptno" /></td>
</tr>
</table>
<input type="submit" />
</form>
</body>
</html>