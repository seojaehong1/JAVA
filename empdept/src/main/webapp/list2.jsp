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
<c:forEach var="dto" items="${list2}">
	<tr>
	<td><a href="updateForm2?deptno=${dto.deptno }">${dto.deptno}</a></td>
	<td>${dto.dname}</td>
	<td>${dto.loc}</td>
	<td><button type="button" 
	onclick="location.href='delete2?deptno=${dto.deptno}'">삭제</button></td>
	</tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='insertForm2' ">부서 추가하기</button>
</body>
</html>


