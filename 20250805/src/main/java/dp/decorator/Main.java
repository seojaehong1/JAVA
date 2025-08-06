package dp.decorator;

public class Main {
	long fac2(long num) {  
		if (num == 0) {
			return 1;
		} else {
			return num * fac2(num - 1); // 재귀 호출
		}
	}
	
	long fac(long num) {
		long res = 1;
		for (long i=1; i <= num; i++) {
			res *= i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.fac(5));
		System.out.println(main.fac2(5));
	}

}
