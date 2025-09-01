package com.du;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MemberDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/Maven", "root", "1234");
		return conn;
	}
	
	public List<MemberDto> selectAll(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String str = "[";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("select json_object('id', id, 'pw', pw, 'name', name) as user_info from member");
		    while (rs.next()) {
		    	MemberDto member = new MemberDto(rs.getString("user_info"));
		    	list.add(member);
		    }
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
		return list;
		
	}
}
