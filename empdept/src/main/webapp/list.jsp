<%@page import="dto.DeptDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<body>
<table>
<tr>
<td>사번</td>
<td>이름</td>
<td>직무</td>
<td>상사번호</td>
<td>입사일</td>
<td>월급</td>
<td>수당</td>
<td>부서번호</td>
<td>부서이름</td>
<td>부서지</td>
</tr>
<c:forEach var="dto" items="${list}">

	<tr>
	<td><a href="updateForm?empno=${dto.empno }">${dto.empno}</a></td>
	<td>${dto.ename}</td>
	<td>${dto.job}</td>
	<td>${dto.mgr}</td>
	<td>${dto.hiredate}</td>
	<td>${dto.sal}</td>
	<td>${dto.comm}</td>
	<td>${dto.deptno}</td>
	<td>${dto.dname}</td>
	<td>${dto.loc}</td>
	<td><button type="button" 
	onclick="location.href='delete?empno=${dto.empno}'">삭제</button></td>
	</tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='insertForm' ">사원 추가하기</button>
<button type="button" onclick="location.href='list2' ">부서 페이지</button>
</body>
</html>


