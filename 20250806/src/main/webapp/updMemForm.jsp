<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
    
<%
	String mid = request.getParameter("mid");
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

String kname = "";
String addr = "";
String email = "";
String phone = "";




try {

    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/du08", "root", "1234");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("select * from member where mid = " + mid);
    if (rs.next()) {
		kname = rs.getString("kname");
		addr = rs.getString("addr");
		email = rs.getString("email");
		phone = rs.getString("phone");
	} 
    
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
session.setAttribute("mid", mid);
%>

<h2>회원 정보 수정</h2>
<table>
<form action = "updMember.jsp" method ="get">
<tr><td>이름:</td><td><input type="text" name="kname" value="<%=kname%>"/></td></tr>
<tr><td>주소:</td><td><input type="text" name="addr" value = "<%=addr%>" /></td></tr>
<tr><td>email:</td><td><input type="text" name="email" value = "<%=email%>"/></td></tr>
<tr><td>전화번호:</td><td><input type="text" name="phone" value = "<%=phone%>"/></td></tr>
<tr><td><input type="submit"/></td><td><input type="reset" /></td></tr>
</form>
</table>
</body>
</html>