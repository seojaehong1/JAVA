package _20250730;

class A{
	
}
class B extends A{}
class C extends A{}
class D extends B{}
class E extends C{}
public class ss {
	public static void main(String[] args) {
		B b = new B();
		A a1 = b;
		
		E e = new E();
		A a2 = e;
		
		
//		C c = new C();
//		D d = new D();
//		E e = new E();
//		
//		A a1 = b;
//		A a2 = c;
//		A a3 = d;
	}
}






