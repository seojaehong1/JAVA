package nested;

public class A1 {
	int field1;
	void method1() {}
	
	static class B {
		void method() {
			
			
		}
		
	}
	
	class C{}
	public static void main(String[] args) {
		A1.B b1 = new A1.B();
		A1.C c1 = new A1().new C();
	}
}
