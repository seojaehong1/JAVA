package thread;
class Task2 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			System.out.println("빵");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Task1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadEx1 {

	public static void main(String[] args) {
//		Thread th1 = new Thread(new Task2());
//		th1.start();
//		Thread th = new Thread(new Task1());
//		th.start();
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("띵");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		Thread th1 = new Thread("ANON-THREAD") {
            @Override
            public void run() {
                for (int i=0; i<4; i++) {
                    System.out.println(getName() + ": 띵(익명 자식)");
                    try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }
        };
        th.start();
    }
		
//		for(int i=0; i<5; i++) {
//			System.out.println("띵");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		
	}


