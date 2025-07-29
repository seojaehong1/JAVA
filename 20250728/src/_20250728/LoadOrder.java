package _20250728;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadOrder {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/tmp/order.dat"))) {
            Order1 order = (Order1) ois.readObject();
            System.out.println("파일에서 주문 객체를 읽어왔습니다:");
            order.print();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
