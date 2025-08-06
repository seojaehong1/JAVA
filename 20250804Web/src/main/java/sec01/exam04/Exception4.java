package sec01.exam04;

public class Exception4 {

	public static void check(int weight) throws MyException {
		if(weight > 100) {
			throw new MyException("과체중입니다.");
		}
	}
	
	public static void main(String[] args) {
	try {
		check(150);
	} catch (MyException e){
		System.out.println(e.getMessage());
	}
	}

}
