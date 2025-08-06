<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
    
<%
	String mid1 = (String)session.getAttribute("mid");
	String kname1 = request.getParameter("kname");
	String addr1 = request.getParameter("addr");
	String email1 = request.getParameter("email");
	String phone1 = request.getParameter("phone");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;
String sql ="";




try {

    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/du08", "root", "1234");
    stmt = conn.createStatement();
    sql = String.format("update member set kname = '%s', addr = '%s', email = '%s', phone = '%s' where mid = '%s'", 
			kname1, addr1, email1, phone1, mid1);
    stmt.executeUpdate(sql);
    
    
    } catch (SQLException e) {
 
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
<h2>회원 정보 수정</h2>
<table>
<form>
<tr><td>이름:</td><td><%=kname1 %></td></tr>
<tr><td>주소:</td><td><%=addr1 %></td></tr>
<tr><td>email:</td><td><%=email1%></td></tr>
<tr><td>전화번호:</td><td><%=phone1%></td></tr>
</form>
</table>
</body>
</html>