package sec01.exam04;

public class MyClassExample {

	public static void main(String[] args) {
		System.out.println("(1)---------------");
		
		Myclass myclass1 = new Myclass();
		myclass1.rc.turnOn();
		myclass1.rc.setVolume(5);
		
		System.out.println("(2)---------------");
		
		Myclass myclass2 = new Myclass(new Audio());
		
		System.out.println("(3)---------------");
		
		Myclass myclass3 = new Myclass();
		myclass3.methodA();
		
		System.out.println("(4)---------------");
		
		Myclass myclass4 = new Myclass();
		myclass4.methodB(new Television());
		
	}

}
