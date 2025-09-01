package test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileEx {

	public static void main(String[] args) {
		Properties props = new Properties();
		
		try (FileInputStream fis = new FileInputStream("C:\\_dev\\workspace\\20250828MVC\\src\\main\\java\\test1\\example.properties")){
			props.load(fis);
			System.out.println("Loaded from file:");
			System.out.println("DB Host: " + props.getProperty("db.host"));
			System.out.println("DB Port: " + props.getProperty("dp.port"));
		
		} catch (IOException e){
			e.printStackTrace();
		}

}
}
