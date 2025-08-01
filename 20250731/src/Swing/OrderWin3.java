package Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class OrderWin3 extends JFrame {
	String id = "root";
	String pw = "1234";
	String url = "jdbc:mysql://localhost:3305/DoItSQL";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "select * from order0729";
	JLabel lb1 = new JLabel("주문상품");
	JLabel lb2 = new JLabel("주문수량");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JButton btn1 = new JButton("주문");
	JButton btn2 = new JButton("주문현황");
	JButton btn3 = new JButton("주문취소");
	JTextArea ta = new JTextArea();
	int i =0;
	public OrderWin3() {
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
		btn1.setBounds(210, 10, 80, 40);
		
		con.add(btn2);
		btn2.setBounds(90, 100, 110, 40);
		
		con.add(btn3);
		btn3.setBounds(210, 80, 80, 40);
		
		
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(30, 150, 250, 70);
		con.add(sp);
		
		this.setSize(400, 300);
		this.setLocation(800, 400);
		this.setTitle("주문 입력 시스템 v1.0");
		showOrders();
		this.setVisible(true);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String product = tf1.getText();
				String quantity = tf2.getText();
				Timecom t1 = new Timecom();
				String times = t1.timecheck();

				try {
					String checkSql = String.format("SELECT ID FROM doit_dml WHERE product = '%s'", product);
					rs = stmt.executeQuery(checkSql);

					if (rs.next()) {
						String updateSql = String.format(
							"UPDATE doit_dml SET quantity = '%s', times = '%s' WHERE product = '%s'",
							quantity, times, product
						);
						stmt.executeUpdate(updateSql);
						System.out.println(updateSql);
					} else {
						String insertSql = String.format(
							"INSERT INTO doit_dml (product, quantity, times) VALUES ('%s', '%s', '%s')",
							product, quantity, times
						);
						stmt.executeUpdate(insertSql);
						System.out.println(insertSql);
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				tf1.setText("");
				tf2.setText("");
				showOrders();
			}
		});


		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showOrders();
				
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String product = tf1.getText();

				try {
					
					String checkSql = String.format("select ID from doit_dml where product = '%s'", product);
					rs = stmt.executeQuery(checkSql);

					if (rs.next()) {
						
						String deleteSql = String.format("delete from doit_dml where product = '%s'", product);
						stmt.executeUpdate(deleteSql);
						System.out.println(deleteSql);
					} else {
						System.out.println("해당 상품이 존재하지 않습니다.");
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				tf1.setText("");
				tf2.setText("");
				showOrders();
			}
		});

		
		
	}
	
	public void showOrders() {
		sql = "select * from doit_dml";
		try {
			rs = stmt.executeQuery(sql);
			String str = "";
			while (rs.next()) {
				String Id = rs.getString("ID");
				String product = rs.getString("product");
				String quantity = rs.getString("quantity");
				String times  = rs.getString("times");
				str += String.format("%s\t%s\t%s\t%s\n", Id, product, quantity, times);
//				System.out.println(orderId + ", " + product + ", " + quantity);
			}
			ta.setText(str);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new OrderWin3();

	}

}




