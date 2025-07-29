package _20250728;

import java.util.Scanner;

public class OrderService {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 주문 입력 | 2. 주문 저장 | 3. 주문 불러오기 | 4. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("입력>");
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				run = false;
				break;
			}
		}
		System.out.println("종료");
	}

}
