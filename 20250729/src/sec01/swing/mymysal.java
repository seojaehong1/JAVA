package sec01.swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class mymysal extends JFrame{
	String id = "root";
	String pw = "1234";
	String url = "jdbc:mysql://localhost:3305/DoItSQL";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "select * from myorder";
	JLabel lb1 = new JLabel("이름");
	JLabel lb2 = new JLabel("사원번호");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JButton btn1 = new JButton("시작");
	JButton btn2 = new JButton("종료");
	JButton btn3 = new JButton("로그");
	JButton btn4 = new JButton("로그인");
	JTextArea ta = new JTextArea();
	String stime;
	public mymysal() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공!");
			stmt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.add(lb1);
		lb1.setBounds(30, 10, 80, 40);
		con.add(lb2);
		lb2.setBounds(120, 10, 80, 40);
		
		
		con.add(tf1);
		tf1.setBounds(30, 50, 80, 40);
		con.add(tf2);
		tf2.setBounds(120, 50, 80, 40);
		
		
		
		con.add(btn1);
		btn1.setBounds(30, 100, 80, 40);
		
		con.add(btn2);
		btn2.setBounds(120, 100, 90, 40);
		
		con.add(btn3);
		btn3.setBounds(220, 100, 90, 40);
		
		con.add(btn4);
		btn4.setBounds(210, 50, 80, 40);
		
		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(30, 150, 250, 70);
		con.add(sp);
		
		this.setSize(400, 300);
		this.setLocation(800, 400);
		this.setTitle("주문 입력 시스템 v1.0");
		this.setVisible(true);
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ename = tf1.getText();
				String empno = tf2.getText();
				String[] i = new String[2];
				i[0] = "select * from emp where ename = ";
				i[1] = "'"+ename+"'"+" AND empno ="+empno;
				sql = String.format(i[0]+i[1]);
				 
				System.out.println(sql);
				try {
					stmt.execute(sql);
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "select * from myorder";
				try {
					rs = stmt.executeQuery(sql);
					String str = "";
					while (rs.next()) {
						String orderId = rs.getString("order_id");
						String product = rs.getString("product");
						int quantity = rs.getInt("quantity");
						str += String.format("%s\t%s\t%d\n", orderId, product);
//						System.out.println(orderId + ", " + product + ", " + quantity);
					}
					ta.setText(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}

	public static void main(String[] args) {
		new mymysal();

	}

}




