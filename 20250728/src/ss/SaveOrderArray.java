package ss;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SaveOrderArray {
    public static void main(String[] args) {
        Order[] orders = new Order[] {
            new Order("ORD001", "Notebook", 2),
            new Order("ORD002", "Mouse", 10),
            new Order("ORD003", "Keyboard", 5)
        };

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/dat/orders.dat"))) {
            oos.writeObject(orders);
            System.out.println("주문 배열이 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

