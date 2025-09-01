package thread;

import java.util.stream.IntStream;

public class ThreadEx4 {

	public static void main(String[] args) {
		Thread th = new Thread(()-> {
			IntStream.rangeClosed(1, 5).forEach((i)->{
				System.out.println("띵" + i);
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			});
			
		});
		th.start();
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
