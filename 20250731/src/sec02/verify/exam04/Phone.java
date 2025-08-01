package sec02.verify.exam04;

abstract class A{ 
	abstract void method();
}

class Bb extends A{
	void method() {
		System.out.println("안녕");
	}
}
public class Phone {
	public static void main(String[] args) {
		Bb b = new Bb();
		b.method();
	}
}
