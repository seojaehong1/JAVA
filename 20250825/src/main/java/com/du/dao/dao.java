package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.du.dto.dto;


public class dao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	
	
	
	
	
	public String selectAll() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String result = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select json_object('id', id, 'title', name) as users from member;");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				
				result = rs.getString("usres");
				System.out.println(result);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(rs != null) pstmt.close();
				if(rs != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("리소스 닫는중 오류발생");
			}
			
		}
		return result;
	}
	
//	public void updateOne(Dept dept) {
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//
//			try {
//				conn = getConnection();
//				pstmt = conn.prepareStatement("update dept set dname=?, loc=? where deptno = ?");
//				pstmt.setString(1, dept.getDname());
//				pstmt.setString(2, dept.getLoc());
//				pstmt.setInt(3, dept.getDeptno());
////				stmt = conn.createStatement();
////				stmt.executeUpdate(sql);
//				
////				String result = String.format("부서번호 %d 부서이름 '%s' 부서위치 '%s' 업데이트성공", dept.getDeptno(),dept.getDname(), dept.getLoc());
////				System.out.println(result);
//				pstmt.executeUpdate();
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				try {
//					if(pstmt != null) pstmt.close();
//					if(conn != null) conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					System.out.println("리소스 닫는중 오류발생");
//				}
//				
//			}
//		}
//	
//	public void insertOne(Dept dept) {
//		String sql = String.format("insert into dept (deptno, dname, loc) values (%d, '%s', '%s')", dept.getDeptno(), dept.getDname(), dept.getLoc());
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			conn = getConnection();
//			pstmt = conn.prepareStatement("insert into dept (deptno, dname, loc) values (?, ?, ?)");
//			pstmt.setInt(1, dept.getDeptno());
//			pstmt.setString(2, dept.getDname());
//			pstmt.setString(3, dept.getLoc());
//			pstmt.executeUpdate();
////			stmt = conn.createStatement();
////			stmt.executeUpdate(sql);
////			String result = String.format("부서번호 %d 부서이름 '%s' 부서위치 '%s' 추가성공", dept.getDeptno(),dept.getDname(), dept.getLoc());
////			System.out.println(result);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("리소스 닫는중 오류발생");
//			}
//		}
//		
//	}
//	
//	public Dept deleteOne(int deptno) {
//		String sql = String.format("delete from dept where deptno = %d", deptno);
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = getConnection();
//			pstmt = conn.prepareStatement("delete from dept where deptno = ?");
//			pstmt.setInt(1, deptno);
//			pstmt.executeUpdate();
////			stmt = conn.createStatement();
////			stmt.executeUpdate(sql);
////			System.out.println("부서번호" + deptno + "삭제 성공");
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
