package _20250722;

public class GugudanPrinter {
	public static void main(String[] args) {
			
		for(int i=2; i<10; i++) {
			System.out.printf("%d단:\t\n", i);
			for (int j =1; j<10; j++) {	
				System.out.printf("%d X %d = %d\t", i, j, i*j);
			}
			System.out.println();
	
		}
	}

}
