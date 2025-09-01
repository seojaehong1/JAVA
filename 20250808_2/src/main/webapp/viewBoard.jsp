<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>

<%
String num = request.getParameter("num");
String writer = "";
String title = "";
String content = "";
String regtime = "";
String hits = "";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/du08", "root", "1234");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("SELECT * FROM board where num = " + num);
    if (rs.next()) {
        writer = rs.getString("writer");
        title = rs.getString("title");
        content = rs.getString("content");
        regtime = rs.getString("regtime");
        hits = rs.getString("hits");
    }
    stmt.executeUpdate("update board set hits = hits + 1 where num = " + num);
    
} catch (SQLException e) {
    out.println("데이터베이스 오류: " + e.getMessage());
} catch (ClassNotFoundException e) {
    out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
} finally {
    try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
    }
}
%>
<jsp:forward page="viewselectBoard.jsp"></jsp:forward>