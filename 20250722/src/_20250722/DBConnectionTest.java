package _20250722;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {

	public static void main(String[] args) {
		Connection con=null;
		
		try {
			String id="spring5";
			String pw="spring5";
			String url="jdbc:mysql://localhost:3305/spring5fs";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,id,pw);

			System.out.println("데이터베이스에 연결됐다");
		}
		catch(Exception e) {
			System.out.println("로딩실패");
		}

	}

}