package _20250728;

import java.io.Serializable;

public class Order1 implements Serializable {

    private String orderId;
    private String product;
    private int quantity;

    public Order1(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public void print() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product : " + product);
        System.out.println("Quantity: " + quantity);
    }
}
