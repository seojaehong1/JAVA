package _20250728;

public class Enum1 {
	public static void main(String[] args) {
	Day today = Day.MONDAY;
	
	switch(today) {
	case MONDAY:
		System.out.println("월요일");
		break;
	case SUNDAY:
		System.out.println("화욜");
		break;
	default:
		System.out.println("평일");
	}
}
}
