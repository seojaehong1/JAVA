package sec01.exam01;

class Parents{
	void method1() {
		System.out.println("안녕");
	}
}
//class Child extends Parents{}


public class A {
	Parents field = new Parents() {
		int childField;
		void childMethod() {}
		@Override
		void method1() {
			
		}
		
	};
	Parents field2 = new Parents() {};
	
	void method() {
		field.method1();
		
		Parents field3 = new Parents();
		method2(new Parents() {
		});
	}
	
	void method2(Parents p) {
		
	}
}
