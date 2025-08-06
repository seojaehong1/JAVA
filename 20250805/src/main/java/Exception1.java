import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception1 {
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		boolean a = true;

		while(a)
		try {
			System.out.println("입력");
			int x = sc.nextInt();
			System.out.println(x);
			
		}catch(InputMismatchException e) {
			
			System.out.println("잘못된 입력 형식입니다.");
			return;
		}
	}
}


