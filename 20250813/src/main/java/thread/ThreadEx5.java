package thread;

import java.util.stream.IntStream;

public class ThreadEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				IntStream.rangeClosed(1,5).forEach((i)-> {
					System.out.println("띵");
				try {
					
					Thread.sleep(1000);
				}catch(Exception e) {
					
				}
			});
			}});
		
		th.start();
		
		Thread th1 = new Thread(()-> {
				
			IntStream.rangeClosed(1, 5).forEach((i)->{
				System.out.println("딩가딩가");
				try {
					Thread.sleep(10000);
				}catch(Exception e){
					
				}
			
			
				
			});
		});
		th1.start();
	}
}
		



