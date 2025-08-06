package sec01.exam04;

import java.util.Scanner;

public class Exception1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		try {
		int arr[] = new int[5];
		arr[num] = 10/num;
	}
		catch (ArrayIndexOutOfBoundsException | ArithmeticException e){
		 System.out.println(e.getMessage());
	} 
}
}
