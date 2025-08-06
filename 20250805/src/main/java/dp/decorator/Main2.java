package dp.decorator;

public class Main2 {

	public static void main(String[] args) {
		
		ExeTimeCalulator cal1 = new ExeTimeCalulator(new ImpeCalculator());
		System.out.println(cal1.factorial(500));
		System.out.println("-------------------------------------------");
		ExeTimeCalulator cal2 = new ExeTimeCalulator(new RecCalcurator());
		System.out.println(cal2.factorial(500));
		
	
	}

}
