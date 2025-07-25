package _20250722;

public class SumCalculator {
	public static void main(String[] args) {
	
	int n = 10*11/2;
	System.out.printf("합계: %d\n",n);
	
	int i = 0;
	int sum = 0;
	
	do {
		sum += i;
		i++;
	}  while(i<=10);
	
	System.out.printf("합계: %d\n", sum);
}
}
