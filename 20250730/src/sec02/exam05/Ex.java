package sec02.exam05;

class Parent{}

class Child extends Parent{}

public class Ex {
	public static void method1 (Parent parent) {
		if(parent instanceof Child) {
			
		}
	}
	
	public static void method2 (Parent parent) {
		Child c1 = (Child)parent;
		System.out.println("출력");
	}
	public static void main(String[] args) {
		Parent p1 = new Child();
		Parent p2 = new Parent();
//		p2 = p1;
		Child c2 = new Child();
		
		method2(p2);
	}
}
