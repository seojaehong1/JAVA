package _20250729;

public class Calculator {
	
	int x,y;
	double z,k;
	public Calculator() {}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double plus(double z, double k) {
		double result = z + k;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x, y);
		double result = sum/2;
		return result;
	}
	
	
	void execute(int x, int y) {
		double result = avg(x,y);
		println("실행결과" +result);
		
	}
	
	
	void println(String message) {
		System.out.println(message);
	}
}
