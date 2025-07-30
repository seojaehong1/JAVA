package sec01.exam01;

public class TryCatchEx2 {

	public static void main(String[] args) {
		String[] arr = {"홍길동","김자바"};
		
		try {
			Integer.parseInt("1");
			System.out.println(arr[2]);
		
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

