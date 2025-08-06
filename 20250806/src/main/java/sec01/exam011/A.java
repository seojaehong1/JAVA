package sec01.exam011;

public class A {
	int z = 100;
	A(){
		System.out.println("A객체가 생성됨");
		}
	static class B {
		B(){System.out.println("B 객체가 생성됨");}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {
			System.out.println("method2");
		}
		
	}
	
	public static void main(String[] args) {
		B b1 = new B();
		b1.method2();
		A.B.method2();

	} 
}
