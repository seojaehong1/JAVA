package _20250728;

import java.util.Scanner;

public class SS {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		
		char[] b = a.toCharArray();
		
		char j[] = new char[b.length];
		for (int i = 0; i<b.length; i++) {
			j[i]= b[i];
			
			
			System.out.println("arr1["+i+"]"+j[i]+"\n");
		}
		
		
		
		
	}
}
