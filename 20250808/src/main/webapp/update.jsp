<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String num = request.getParameter("num");
System.out.println(num);
Connection conn = null;
Statement stmt = null;

String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String curTime = LocalDate.now() + " " + LocalTime.now().toString().substring(0,8);

if(content != null)
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/du08", "root", "1234");
    stmt = conn.createStatement();
    String sql = String.format("update board set writer = '%s', title = '%s', content = '%s', regtime = '%s', where num= %s", writer, title,
    		content, curTime, num); 
    stmt.executeUpdate(sql);
} catch (SQLException e) {
    out.println("데이터베이스 오류: " + e.getMessage());
} catch (ClassNotFoundException e) {
    out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
} finally {
    try {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
    }
}
response.sendRedirect("view.jsp?num=" + num);
%>
</body>
</html>