package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DeptDTO;
import dto.EmpDTO;

public class DeptDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<DeptDTO> selectList2() {  // tiny 테이블의 모든 자료를 가져옴
		List<DeptDTO> list2 = new ArrayList<DeptDTO>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("SELECT * FROM dept");
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		        int deptno = rs.getInt("deptno");
		        String dname = rs.getString("dname");
		        String loc = rs.getString("loc");
		        list2.add(new DeptDTO(deptno, dname, loc));
		    }
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (pstmt != null) pstmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
		return list2;
	}
	
	public DeptDTO selectOne2(int deptno) {  // tiny 테이블의 모든 자료를 가져옴
		DeptDTO dto = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("SELECT * FROM dept where deptno = ?");
		    pstmt.setInt(1, deptno);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	int deptno1 = rs.getInt("deptno");
		        String dname = rs.getString("dname");
		        String loc = rs.getString("loc");
		        dto = new DeptDTO(deptno1, dname, loc);
		    }
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (pstmt != null) pstmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
		return dto;
	}
	
	
	public void insertOne2(DeptDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("insert into dept(deptno, dname, loc) values (?, ?, ?)");
		    pstmt.setInt(1, dto.getDeptno());
		    pstmt.setString(2, dto.getDname());
		    pstmt.setString(3, dto.getLoc());
		    pstmt.executeUpdate(); 
		  
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (pstmt != null) pstmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
	}
	
	public void updateOne2(int deptno, DeptDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("update dept set  dname = ?, loc = ? where deptno = ?");
		    pstmt.setString(1, dto.getDname());
		    pstmt.setString(2, dto.getLoc());
		    pstmt.setInt(3, deptno);
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (pstmt != null) pstmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
	}
	
	public void deleteOne2(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("delete from dept where deptno = ?");
		    pstmt.setInt(1, deptno);
		    pstmt.executeUpdate();
		  
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (pstmt != null) pstmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}
	}
}
