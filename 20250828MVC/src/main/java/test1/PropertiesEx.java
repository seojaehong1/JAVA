package test1;

import java.util.Properties;

public class PropertiesEx {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		
		props.setProperty("db.driver", "com.mysql.cj.jdbc.Driver");
		props.setProperty("db.url", "jdbc:mysql://localhost:3306/mydb");
		props.setProperty("db.username", "user");
		props.setProperty("db.password", "password");
		
		String driver = props.getProperty("db.driver");
		String url = props.getProperty("db.url");
		
		System.out.println("DB Driver: " + driver);
		System.out.println("DB URL: " + url);
		
	}

}
