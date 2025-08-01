package sec03.exam3;

public class Cat implements Animal {

	public String kind = "포유류";
	
	public void breath() {
		System.out.println("숨을 쉽니다.");
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");
		// TODO Auto-generated method stub
		
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
