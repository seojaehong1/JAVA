package thread;

public class ThreadEx2 {

	public static void main(String[] args) { //메인스레드
		Thread th = new Thread(new BeepTask());
		th.start(); //새로운 스레드
		
		for(int i=0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
