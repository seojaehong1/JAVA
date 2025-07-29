package _20250728;



public class Desdafu {
	int field1;
	void method1() {
		field1 =100;
	}
	
	static int field2;
	static void method2() {}

	public static void main(String[] args) {
		Desdafu a = new Desdafu();
		a.field1 = 100;
		field2 = 100;
	}
}
