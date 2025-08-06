package sec01.exam04;

public class Exception2 {
	
	public static void check(){ //실행예외
	try {
		System.out.println("내부 메소드");
		int div = 5 / 0;
	} catch(ArithmeticException e) {
		System.out.println("0으로 나누지마세요");
	}
	}
	
	public static void main(String[] args) {	
		check();
	
}
}
