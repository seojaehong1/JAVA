package sec01.exam04;

public class Exception3 {

	public static void method1() throws ClassNotFoundException{
		Class.forName("dfsdfd");
	}
	
	public static void main(String[] args) {
		try {
			method1();
		} catch (ClassNotFoundException e) {
			System.out.println("뭐해요!");
		}
	}

}
