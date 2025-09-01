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

public class EmpDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<EmpDTO> selectList() {  // tiny 테이블의 모든 자료를 가져옴
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("SELECT empno, ename, job, mgr, hiredate, sal, comm, emp.deptno as deptno, dname, loc FROM emp INNER JOIN dept on emp.deptno = dept.deptno");
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		        int empno = rs.getInt("empno");
		        String ename = rs.getString("ename");
		        String job = rs.getString("job");
		        int mgr = rs.getInt("mgr");
		        String hiredate = rs.getString("hiredate");
		        int sal = rs.getInt("sal");
		        int comm = rs.getInt("comm");
		        int deptno = rs.getInt("deptno");
		        String dname = rs.getString("dname");
		        String loc = rs.getString("loc");
		        list.add(new EmpDTO(empno, ename, job, mgr, 
		        		hiredate, sal, comm, deptno, dname, loc));
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
		return list;
	}
	
	public EmpDTO selectOne(int empno) {  // tiny 테이블의 모든 자료를 가져옴
		EmpDTO dto = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("SELECT * FROM emp where empno = ?");
		    pstmt.setInt(1, empno);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	int empno1 = rs.getInt("empno");
		        String ename = rs.getString("ename");
		        String job = rs.getString("job");
		        int mgr = rs.getInt("mgr");
		        int sal = rs.getInt("sal");
		        int comm = rs.getInt("comm");
		        int deptno = rs.getInt("deptno");
		        dto = new EmpDTO(empno1, ename, job, mgr, sal, comm, deptno);
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
	
	
	public void insertOne(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ?, ?, ?, ?, ?)");
		    pstmt.setInt(1, dto.getEmpno());
		    pstmt.setString(2, dto.getEname());
		    pstmt.setString(3, dto.getJob());
		    pstmt.setInt(4, dto.getMgr());
		    pstmt.setString(5, dto.getHiredate());
		    pstmt.setInt(6, dto.getSal());
		    pstmt.setInt(7, dto.getComm());
		    pstmt.setInt(8, dto.getDeptno());

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
	
	public void updateOne(int empno, EmpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("update emp set ename = ?, job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?");
		    
		    pstmt.setString(1, dto.getEname());
		    pstmt.setString(2, dto.getJob());
		    pstmt.setInt(3, dto.getMgr());
		    pstmt.setInt(4, dto.getSal());
		    pstmt.setInt(5, dto.getComm());
		    pstmt.setInt(6, dto.getDeptno());
		    pstmt.setInt(7, dto.getEmpno());
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
	
	public void deleteOne(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		    conn = getConnection();
		    pstmt = conn.prepareStatement("delete from emp where empno = ?");
		    pstmt.setInt(1, empno);
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
