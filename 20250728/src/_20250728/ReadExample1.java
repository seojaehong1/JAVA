package _20250728;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Reader reader = new FileReader("C:/Temp/test7.txt");
		
		char[] buffer = new char[100];
		
		while(true) {
			int readCharNum = reader.read(buffer);
			if(readCharNum == -1) break;
			for(int i=0; i<readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			
			reader.close();
		}
	}

}
