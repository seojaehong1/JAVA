package _20250728;

import java.io.OutputStream;
import java.io.FileOutputStream;

public class WriteExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		OutputStream os = new FileOutputStream("C:/Temp/test1.db");
		
//		byte a = 10;
//		byte b = 20;
//		byte c = 30;
		
		byte[] array = {10,20,40,80,90};
//		os.write(a);
//		os.write(b);
//		os.write(c);
		os.write(array, 1, 4);
		
		os.flush();
		os.close();
	}

}
