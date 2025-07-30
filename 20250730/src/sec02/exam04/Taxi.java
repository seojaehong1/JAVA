package sec02.exam04;

public class Taxi extends Vehicle{

	@Override
	public void run() {
		System.out.println("택시 달림");
		super.run();
	}
	
}
