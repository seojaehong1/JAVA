package dp.decorator;

public class RecCalcurator implements Calculator {

	@Override
	public long factorial(long num) {
		if (num == 0) {
			return 1;
		} else {
			return num * factorial(num - 1); // 재귀 호출
		}
	}

}
