package test1;

import java.util.HashMap;
import java.util.Map;

class Users{
	String name;
	String phone;
	public Users(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	
}

public class HashEx {

	public static void main(String[] args) {
		Map<String , Users> map = new HashMap<>();
		map.put("100", new Users("홍길일","1"));
		map.put("200", new Users("홍길이","2"));
		map.put("300", new Users("홍길삼","3"));
		System.out.println(map.get("100").name);
		System.out.println(map.get("100").phone);
	}

}
