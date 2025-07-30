package sec02.exam04;

public class DriverEx {

	public static void main(String[] args) {
		Driver d1 = new Driver();
		
		Bus b1 = new Bus();
		Taxi t1 = new Taxi();
		
		d1.driver(b1);
		d1.driver(t1);

	}

}
