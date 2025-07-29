package ss;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
    private String orderId;
    private String product;
    private int quantity;

    public Order(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void print() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product : " + product);
        System.out.println("Quantity: " + quantity);
    }
}
