

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%
String kname = request.getParameter("kname");


String id = "root";
String pw = "1234";
String url = "jdbc:mysql://localhost:3305/DoItSQL";
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String sql = "select * from order0729";

	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("드라이버 로딩!");
	con = DriverManager.getConnection(url, id, pw);
	System.out.println("접속 성공!");
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type ="text/css">
table, th, td{
border:1px solid #ccc;
border-collapse:collapse;
}
th, td{padding:10px, 20px;}
</style>
</head>
<body>
<h1><%= kname %>님, 환영합니다</h1>
<table>
<caption>주문 목록표</caption>
<% 
	while (rs.next()) {

		String orderId = rs.getString("order_id");
		String product = rs.getString("product");
		int quantity = rs.getInt("quantity");
%>


	<tr>
<td><%=orderId %></td>
<td><%=product %></td>
<td><%=quantity %></td>
	</tr>
	
<%
		
	System.out.println(orderId + ", " + product + ", " + quantity);	
}
%>
</table>
</body>
</html>