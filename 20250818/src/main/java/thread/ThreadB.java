package thread;

public class ThreadB extends Thread{
	
	public ThreadB(){
	}

	@Override
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(this.getName());
		}
	}
	
}
