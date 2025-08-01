package sec02.verify.exam04;

interface AA{
	abstract void method();
}

class B implements AA{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("인터페이스 상속");
	}
	
	
	
}

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B a = new B();
		a.method();
	}

}
