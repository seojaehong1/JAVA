<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name1 = request.getParameter("name1");
String address = request.getParameter("address");
String email = request.getParameter("email");
String phone = request.getParameter("phone");



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*, javax.sql.*" %>

<%

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String sql = "";


try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/du08", "root", "1234");

    stmt = conn.createStatement();

    sql = String.format("insert into member(name1, address, email, phone) values ('%s', '%s', '%s', '%s')", 

			name1, address, email, phone);

    stmt.executeUpdate(sql);
%>
새로운 회원 등록을 했습니다
<%

    

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
<br/>
<%=name1 %><br/>
<%=address %><br/>
<%=email %><br/>
<%=phone %><br/>
</body>
</html>