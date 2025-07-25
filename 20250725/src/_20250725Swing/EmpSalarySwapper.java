package _20250725Swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Emp {
	String empno;
	String ename;
	String sal;
	public Emp(String empno, String ename, String sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}
	
	
}

public class EmpSalarySwapper {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Emp emp[] = new Emp[2]; 
		String id = "spring5";
		String pw = "spring5";
		String url = "jdbc:mysql://localhost:3305/spring5fs";
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		String sql ="SELECT empno, ename, sal FROM emp WHERE ename IN ('KING', 'SMITH')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
		con = DriverManager.getConnection(url, id, pw);
		
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("\n사번\t이름\t월급");
		System.out.println("-------------------");
		
		int i =0;

		while (rs.next()) {
	
		String empno = rs.getString("empno");
		String ename = rs.getString("ename");
		String sal = rs.getString("sal");
		
		emp[i++] = new Emp(empno, ename, sal);
		
//		chars = sal.toCharArray();
		
//		
//		System.out.print(empno+"\t"+ename+"\t");


//		for(int j = chars.length-1; i>=j; i--) {
//			
//			System.out.print(chars[i]);
//		}
//		System.out.println();
		}
		String temp = null;
		temp = emp[0].sal;
		emp[0].sal = emp[1].sal;
		emp[1].sal = temp;
		
		for (int j=0; j < emp.length; j++) {
			System.out.println(emp[j].empno+"\t"+emp[j].ename+"\t"+emp[j].sal);
		}

		
		
		
		
	
		
		
		
		rs.close();
		stmt.close();
		con.close();
		
		/*	try {
			Class.forName("com.mysql.cj.jdbc");
			System.out.println("클래스 있다.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 없다.");
		} */
		
	}

}
