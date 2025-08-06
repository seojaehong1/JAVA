package sec01.exam01;

public class A {
	
	A(){
		System.out.println("A객체가 생성됨");
		}
	class B {
		B(){System.out.println("B 객체가 생성됨");}
		int field1;
		static int field2 = 3;
		void method1() {}
		static void method2() {
			System.out.println("method2");
		}
		
		public void setfield1() {
			System.out.println(field2);
		}
	}
	
	public static void main(String[] args) {
		A a1 = new A();
		B b1 = a1.new B();
		b1.method1();
		A.B.method2();
		b1.setfield1();
		
//		b1.field1;
//		b1.field2;
	} 
}
