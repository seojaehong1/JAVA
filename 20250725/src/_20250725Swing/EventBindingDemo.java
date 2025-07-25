package _20250725Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventBindingDemo extends JFrame {
	
	JButton jb1 = new JButton("확인");
	
	public EventBindingDemo() {
		
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(1000,300);
		this.setSize(500,300);
		
		jb1.setBounds(10,20,90,40);
		con.add(jb1);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public static void main(String[] args) {
		
		new EventBindingDemo();
		
	}

}
