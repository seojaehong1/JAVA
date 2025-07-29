package _20250728;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car mycar = new Car();
		
		mycar.setGas(5);
		
		boolean gasStatus = mycar.isLeftGas();
		if(gasStatus) {
			System.out.println("출발");
			mycar.run();
		}
		if(mycar.isLeftGas()) {
			System.out.println("가스를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요");
		}
		
	}

}
