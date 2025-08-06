package dp.factoryMethod;

public class Main{
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("서재홍");
		card1.use();
	}

}
