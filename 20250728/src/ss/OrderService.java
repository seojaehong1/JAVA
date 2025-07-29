package ss;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OrderService {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		Order order = null;
		
		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 주문 입력 | 2. 주문 저장 | 3. 주문 불러오기 | 4. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("입력>");
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1:
				System.out.print("주문 ID 입력>");
				String orderId = scan.nextLine();
				System.out.print("상품명 입력>");
				String product = scan.nextLine();
				System.out.print("상품수량 입력>");
				int quantity = Integer.parseInt(scan.nextLine());
				order = new Order(orderId, product, quantity); 
				break;
			case 2:
				if (order != null) {
					try (ObjectOutputStream oos 
			        		= new ObjectOutputStream(new FileOutputStream("c:/dat/order.dat"))) {
			            oos.writeObject(order);
			            System.out.println("주문 객체가 파일에 저장되었습니다.");
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				} else {
					System.out.println("주문 입력을 먼저 하세요.");
				}
				break;
			case 3:
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/dat/order.dat"))) {
		            order = (Order) ois.readObject();
		            System.out.println("파일에서 주문 객체를 읽어왔습니다:");
		            order.print();
		        } catch (IOException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }
				break;
			case 4:
				run = false;
				break;
			}
		}
		System.out.println("종료");
	}

}
