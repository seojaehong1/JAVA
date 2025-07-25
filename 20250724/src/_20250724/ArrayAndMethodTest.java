package _20250724;

public class ArrayAndMethodTest {
	
	
	static int method1(String name) {
		System.out.println(name);
		return 100;
	}
	
	public static void main(String[] args) {
		int y = method1("홍길동");
		int[] x = new int[] {100,200,300};
		String names[] = new String[5];
		
		for(int i=0; i<x.length; i++) {
			System.out.println(names[i]);
			System.out.println(x[i]);
		}
		
	}

}
