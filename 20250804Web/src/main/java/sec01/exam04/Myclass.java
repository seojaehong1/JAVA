package sec01.exam04;

 public class Myclass {
	 
	 Myclass(){}
	 RemoteControl rc = new Television();

	 public Myclass(RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	 }
	 
	 void methodA() {
		 RemoteControl rc = new Audio();
		 rc.turnOn();
		 rc.setVolume(5);
	 }
	 
	 void methodB(RemoteControl rc) {
		 rc.turnOn();
		 rc.setVolume(5);
	 }
	 
	 
}
