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
<table>
<c:forEach var="board" items="${list}">
    <tr>
        <th>제목</th>
        <td>${board.title }</td>
    </tr>
    <tr>
        <th>작성자</th>
        <td>${board.writer }</td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td>${board.regtime }</td>
    </tr>
    <tr>
        <th>조회수</th>
        <td>${board.hits }</td>
    </tr>
    <tr>
        <th>내용</th>
        <td>${board.content }</td>
    </tr>
    </c:forEach>
</table>


<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='updateForm.jsp'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp'">
</body>
</html>