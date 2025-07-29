package _20250728;

public class SingletonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Singleton obj1 = new Singleton();
		
		Singleton sg = Singleton.getInstance();
		Singleton sg1 = Singleton.getInstance();
		if(sg==sg1) {
			System.out.println("같다");
		}
		
	}

}
