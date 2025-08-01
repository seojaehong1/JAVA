package sec02.verify.exam03;

class A{}
class B extends A{}
class D extends B{}
class E extends B{}

class C extends A{}


public class Ex3 {
	public static void method(B b) {
		
	}
	
	public static void main(String[] args) {
		method(new E());

	}

}
