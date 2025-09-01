package spring;

public class GreeterEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter gt = new Greeter();
		gt.setFormat("%s");
		
		System.out.println(gt.greet("나온다"));
	}

}
