package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TinyDTO;

public class TinyDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
		return conn;
	}
	
	public List<TinyDTO> selectList() {  // tiny 테이블의 모든 자료를 가져옴
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<TinyDTO> list = new ArrayList<TinyDTO>();
		try {
		    conn = getConnection();
//		    stmt = conn.createStatement();
//		    rs = stmt.executeQuery("SELECT * FROM tiny");
		    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tiny");
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		        int num = rs.getInt("num");
		        String content = rs.getString("content");
		        list.add(new TinyDTO(num,content));
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

	
	public void insertOne(TinyDTO dto) {  
		Connection conn = null;
		Statement stmt = null;
		
		try {
		    conn = getConnection();
//		    stmt = conn.createStatement();
//		    
//		    stmt.executeUpdate(String.format("insert into tiny (num, content) values (tiny_seq.nextval,'%s')", dto.getContent()));
		    PreparedStatement pstmt = conn.prepareStatement("insert into tiny (num, content) values (tiny_seq.nextval, ?)");
		    pstmt.setString(1, dto.getContent());
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}

		return;

	}
	
	public void updateOne(String content, int num) {  
		Connection conn = null;
		Statement stmt = null;
		
		try {
		    conn = getConnection();
//		    stmt = conn.createStatement();
//		    String sql = String.format("update tiny set content = '%s' where num = %d",
//		    		content, num);
//		    stmt.executeUpdate(sql);
		    PreparedStatement pstmt = conn.prepareStatement("update tiny set content = ? where num = ?");
		    pstmt.setString(1, content);
		    pstmt.setInt(2, num);
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}

		return;

	}
	
	public List<TinyDTO> selectListOne(int num) {  // tiny 테이블의 모든 자료를 가져옴
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<TinyDTO> list = new ArrayList<TinyDTO>();
		try {
		    conn = getConnection();
//		    stmt = conn.createStatement();
//		    rs = stmt.executeQuery("SELECT * FROM tiny where num = " + num);
		    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tiny where num = ?");
		    pstmt.setInt(1, num);
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		        String content = rs.getString("content");
		        list.add(new TinyDTO(num,content));
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
	
	public void deleteOne(int num) {  
		Connection conn = null;
		Statement stmt = null;
		
		try {
		    conn = getConnection();
//		    stmt = conn.createStatement();
//		    String sql = String.format("delete from tiny where num = %d", num
//		    		);
		    PreparedStatement pstmt = conn.prepareStatement("delete from tiny where num = ?");
		    pstmt.setInt(1, num);
		    pstmt.executeUpdate();
//		    stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
		} finally {
		    try {
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		    	System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
		    }
		}

		return;

	}
	
	
}
