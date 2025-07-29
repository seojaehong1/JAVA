package _20250728;

public class Order {
	private OrderStatus status;
	
	public Order() {
		status = OrderStatus.PENDING;
	}
	public void nextStatus() {
		switch(status) {
		case PENDING:
			status = OrderStatus.PROCESSING;
			break;
		case PROCESSING:
			status = OrderStatus.PROCESSING;
			break;
		case SHIPPED:
			status = OrderStatus.SHIPPED;
			break;
		case DELIBERED:
			status = OrderStatus.DELIBERED;
			System.out.println("이미 배송완료 주문");
			break;
		}
	}
	public void printStatus() {
		System.out.println("현재주문 상태" + status);
	}
}
