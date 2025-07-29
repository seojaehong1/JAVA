package ss;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrderWin extends JFrame {
	JLabel lb1 = new JLabel("주문 ID");
	JLabel lb2 = new JLabel("주문 상품");
	JLabel lb3 = new JLabel("주문 수량");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JButton btn1 = new JButton("저장");
	JButton btn2 = new JButton("불러오기");
	JTextArea ta = new JTextArea();
	Order order;
	public OrderWin() {
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.add(lb1);
		lb1.setBounds(30, 10, 80, 40);
		con.add(lb2);
		lb2.setBounds(120, 10, 80, 40);
		con.add(lb3);
		lb3.setBounds(210, 10, 80, 40);
		
		con.add(tf1);
		tf1.setBounds(30, 50, 80, 40);
		con.add(tf2);
		tf2.setBounds(120, 50, 80, 40);
		con.add(tf3);
		tf3.setBounds(210, 50, 80, 40);
		
		con.add(btn1);
		btn1.setBounds(30, 100, 80, 40);
		
		con.add(btn2);
		btn2.setBounds(120, 100, 90, 40);
		
		ta.setBounds(30,150,320,50);
		con.add(ta);
		ta.setText("Order ID: " + order.getOrderId() +
		           "\nProduct: " + order.getProduct() +
		           "\nQuantity: " + order.getQuantity());
	
		this.setSize(400, 300);
		this.setLocation(800, 400);
		this.setTitle("주문 입력 시스템 v1.0");
		this.setVisible(true);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderId = tf1.getText();
				String product = tf2.getText();
				int quantity = Integer.parseInt(tf3.getText());
				order = new Order(orderId, product, quantity);
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				
				try (ObjectOutputStream oos 
		        		= new ObjectOutputStream(new FileOutputStream("c:/dat/order.dat"))) {
		            oos.writeObject(order);
		            System.out.println("주문 객체가 파일에 저장되었습니다.");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try (ObjectInputStream ois =
						new ObjectInputStream(new FileInputStream("c:/dat/order.dat"))) {
					order = (Order) ois.readObject();
					tf1.setText(order.getOrderId());
					tf2.setText(order.getProduct());
					tf3.setText(String.valueOf(order.getQuantity()));

					System.out.println("파일에서 주문 객체를 읽어왔습니다:");
					order.print();

					ta.setText("Order ID: " + order.getOrderId() +
					           "\nProduct: " + order.getProduct() +
					           "\nQuantity: " + order.getQuantity());
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
					ta.setText("파일에서 주문 정보를 불러올 수 없습니다.");
				}
			}
		});
		
	}

	public static void main(String[] args) {
		new OrderWin();

	}

}




