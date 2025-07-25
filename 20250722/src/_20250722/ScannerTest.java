package _20250722;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력>");
		String inputData = sc.nextLine();
		int num =Integer.parseInt(inputData);
		float value = FloatparseFloat("10");
		
		
		
		switch(num/10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("F");
			break;
		}
		
		
		/*
		if (num<0) {
			System.out.println("음수입니다.");
		} else if(num>0) {
			System.out.println("양수입니다.");
		} else {
			System.out.println("0입니다.");
		}
		*/
	}

	private static float FloatparseFloat(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static byte ByteparseByte(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}

