package _20250725;

import java.util.Arrays;
import java.util.Scanner;

public class EndToStartGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String firstword[] = new String[5];
		System.out.print("단어입력>");
		String inputData = sc.nextLine();
		char[] charArr = inputData.toCharArray();
		//System.out.println(charArr);
		System.out.println(Arrays.toString(charArr));
		boolean same = true;
		while(same) {
			System.out.println("다음 단어를 입력하세요");
			String inputData2 = sc.nextLine();
			char[] charArr2 = inputData2.toCharArray();
			int a = charArr.length;
			int i =0;
			if(charArr[charArr.length-1]==charArr2[i]) {
				charArr = charArr2;
				
				
			} else {
				same = false;
			}
			
			
			
				
			
		}
		
		System.out.println("게임 종료");
	}
}
