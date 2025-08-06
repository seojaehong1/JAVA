package nested;

public class A {
	class B{}
	static class C{}
	void method(){
		class D{}
		D d1 = new D();
	}
	public static void main(String[] args) {
//		A a1 = new A();
//		B b1 = a1.new B();
		C c1 = new C();
//		B b2 = new A().new B();
	}
}
