package thread;

public class ThreadEx3 {

	public static void main(String[] args) {
		Thread th = new Thread(new BeepTask2());
		th.start();
	
		for(int i=0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}}
}
