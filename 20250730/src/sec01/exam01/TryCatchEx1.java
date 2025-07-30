package sec01.exam01;

public class TryCatchEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Class.forName("sdfdsaf");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("언제나 실행!");
		}
	}

}
