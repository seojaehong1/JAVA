package ramda;

public class Main {
	public static void main(String[] args) {
//		MyFunctionalInterface fi = () -> System.out.println("메소드");
//		fi.method();
//		MyFunctionalInterface fi;
//		fi = (x,y) -> {
//			System.out.println(x+y);
//		};
//		
//		fi.method(100,"가나");
		
		MyFunctionalInterface fi = (x,y) ->{
		return x + y;
		};
		String str = fi.method(100, "홍길동");
		System.out.println(str);
	}
}
