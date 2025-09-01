package com.du.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.du.dto.Emp;



public class EmpDao {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<Emp> selectList(){
		List<Emp> list = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select empno, ename, job, mgr, to_char(hiredate, 'YYYY-MM-DD') as hiredate, sal, comm, deptno from emp");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				list.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
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
		return list;
	}
	
	public List<Emp> selectList2(){
		List<Emp> list2 = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select empno, ename, job, mgr, to_char(hiredate, 'YYYY-MM-DD') as hiredate, sal, comm, emp.deptno, dname, loc from emp INNER JOIN dept on emp.deptno = dept.deptno");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("emp.deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				list2.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc));
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
		return list2;
	}
		
		
	
	
	public Emp selectOne(int empno1) {
		Emp emp = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select empno, ename, job, mgr, to_char(hiredate, 'YYYY-MM-DD') as hiredate, sal, comm, deptno from emp where empno = ?");
			pstmt.setInt(1, empno1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
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
		return emp;
	}
	
	public void updateOne(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno = ?");
				pstmt.setString(1, emp.getEname());
				pstmt.setString(2, emp.getJob());
				pstmt.setInt(3, emp.getMgr());
				pstmt.setString(4, emp.getHiredate());
				pstmt.setInt(5, emp.getSal());
				pstmt.setInt(6, emp.getComm());
				pstmt.setInt(7, emp.getDeptno());
				pstmt.setInt(8, emp.getEmpno());
//				stmt = conn.createStatement();
//				stmt.executeUpdate(sql);
				
//				String result = String.format("부서번호 %d 부서이름 '%s' 부서위치 '%s' 업데이트성공", dept.getDeptno(),dept.getDname(), dept.getLoc());
//				System.out.println(result);
				pstmt.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("리소스 닫는중 오류발생");
				}
				
			}
		}
	
	public void insertOne(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//			String result = String.format("부서번호 %d 부서이름 '%s' 부서위치 '%s' 추가성공", dept.getDeptno(),dept.getDname(), dept.getLoc());
//			System.out.println(result);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("리소스 닫는중 오류발생");
			}
		}
		
	}
	
	public Emp deleteOne(int empno) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from emp where empno = ?");
			pstmt.setInt(1, empno);
			pstmt.executeUpdate();
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//			System.out.println("부서번호" + deptno + "삭제 성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
