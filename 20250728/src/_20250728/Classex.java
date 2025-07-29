package _20250728;

class G{
	void method() {
		
	}
}
class H{
	void method1() {
		G g = new G();
		g.method();
	}
}
interface D{}

class E implements D{}
class F implements D{}

class A{
	D d = new E();
	D d1 = new F();
}

class B{
	A a;
}
class C extends A{
	
}

public class Classex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
