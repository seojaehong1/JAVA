<%@page import="dto.TinyDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.TinyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<form method="get" action="update.jsp">
<body>
<table>
<%

String num = request.getParameter("num");
String content = request.getParameter("content");
TinyDAO dao = new TinyDAO();
List<TinyDTO> list = dao.selectListOne(Integer.parseInt(num));
for (TinyDTO dto : list) {
%>

	<tr>
	<td><input type='text' name = num value = '<%=dto.getNum() %>'> </td>
	<td><input type='text' name = content value = '<%=dto.getContent() %>'></td>
	</tr>
<%
}
%>
</table>
<input type="submit" value="수정하기">
</body>
</form>
</html>