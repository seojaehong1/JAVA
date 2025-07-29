package _20250728;



public class san {
	String name;
	String phone;
	String address;
	int sal;
	
	san(){
		this("사용자", "1010", "경기", 50);
	}
	
	
	
	

	public san(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public san(String name, String phone, String address, int sal) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.sal = sal;
	
	}

	
	public static void main(String[] args) {
		san s = new san();
		
	}
}
