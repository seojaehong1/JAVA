<%@ page import="java.sql.*, javax.sql.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>회원가입</title>

</head>







<body>

<form>



<label>이름<br>

<input type = "text" name = "name1" />

</label></br>



<label>주소<br>

<input type = "text" name = "address" />

</label></br>



<label>email<br>

<input type = "text" name = "email" />

</label></br>



<label>전화번호<br>

<input type = "text" name = "phone" />

</label></br>



<input type = "submit" value = "확인" />



<%

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;

String name = request.getParameter("name1");

String address = request.getParameter("address");

String email = request.getParameter("email");

String phone = request.getParameter("phone");

String sql = "";



try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/DoItSQL", "root", "1234");

    stmt = conn.createStatement();

    sql = String.format("insert into login(name1, address, email, phone) values ('%s', '%s', '%s', '%s')", 

			name, address, email, phone);

    stmt.executeUpdate(sql);

    

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



</form>

</body>

</html>