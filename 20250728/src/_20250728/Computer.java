package _20250728;

public class Computer {
	
	int sum(int ... val) {
		int sum =0;
		for (int v : val) {
			sum += v;
		}
		return sum;
	}
	public static void main(String[] args) {
		Computer computer = new Computer();
		int ret=computer.sum(1,2,4,3,5,6,7,8,9,10);
		System.out.println(ret);
		System.out.println(10*(10+1)/2);
	}
}
