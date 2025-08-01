<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*, javax.sql.*" %>

<% String str = request.getParameter("val1"); %>

<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/spring5fs", "root", "1234");
    stmt = conn.createStatement();
    String checkSql = String.format("SELECT * FROM dept where deptno =%s", str);
    rs = stmt.executeQuery(checkSql);
%>   
<table>
<tr>부서번호</th/><th>부서 이름</th><th>부서 위치</th>

<%  
	  

    while (rs.next()) { 	
%> 	
<tr>
<td><%=rs.getString("deptno")%></td>
<td><%=rs.getString("dname")%></td>
<td><%=rs.getString("loc")%></td>
</tr>
 
<% 
    }
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
</table>
</body>
</html>