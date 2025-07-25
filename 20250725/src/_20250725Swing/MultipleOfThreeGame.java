package _20250725Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MultipleOfThreeGame extends JFrame implements ActionListener{
	
	int count = 1;
	JButton jb1 = new JButton("확인");
	JButton jb2 = new JButton("다음");
	JLabel lab2 = new JLabel("숫자: " + count);
	
	public MultipleOfThreeGame() {
		
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(1000,300);
		this.setSize(500,300);
		
		jb1.setBounds(10,20,90,40);
		con.add(jb1);
		
		jb2.setBounds(100,20,90,40);
		con.add(jb2);
		
		lab2.setBounds(200, 50, 100, 30);
		con.add(lab2);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);

	}
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb1) {
				if (count%3==0) {
					JOptionPane.showMessageDialog(this, count+"정답입니다.");
					count++;
					lab2.setText("숫자: " + count);
					
				} else {
					JOptionPane.showMessageDialog(this, count+"는 3의배수가 아닙니다.");
				} 
				
				
		} 
			if (e.getSource() == jb2) {
				if(count%3==0) {
					JOptionPane.showMessageDialog(this, "3의배수를 건너뛰셨습니다.");
					count++;
				} else
				count++;
				lab2.setText("숫자: " + count);
				
			}
	} 

	public static void main(String[] args) {
		
		new MultipleOfThreeGame();
		
	}

}
