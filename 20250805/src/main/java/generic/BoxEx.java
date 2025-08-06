package generic;

class Apple<A> {
	
	private A a;
	
	
	public void set(A a) {
		this.a = a;
	}
	
	public A get() {
		return a;
	}
	
}

public class BoxEx {

	public static void main(String[] args) {
//		Box<String> box = new Box<String>();
//		box.set("홍길동");
//		String name = box.get();
//		System.out.println(name);
		
		Apple<Double> box2 = new Apple<Double>();
		box2.set(30.0);
		double b = box2.get();
		System.out.println(b);
		
		Box box = new Box();
		box.set("홍길동");
		String name = (String)box.get();
		System.out.println(name);
	}

}
