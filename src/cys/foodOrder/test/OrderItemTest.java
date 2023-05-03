package cys.foodOrder.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.foodOrder.dao.OrderItemImpl;
import cys.foodOrder.model.OrderItem;

public class OrderItemTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		OrderItemImpl or = new OrderItemImpl();
		OrderItem order = new OrderItem();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert order details"+ "\n 2.delete order" + "\n 3.Find order" + "\n 4.show order List" + "\n 5.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter order ID: ");
				int id = sc.nextInt();
				if (id > 0) {
					order.setId(id);
					System.out.println(or.insertOrder(order) + " Inserted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid order ID");
			}
				break;
			case 2: {
				System.out.print("Enter order ID to delete: ");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(or.deleteOrder(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid menu ID");
			}
				break;
			case 3: {

				System.out.print("Enter order ID to find:");
				int id = sc.nextInt();
				if (id > 0) {
					or.findById(id);
					System.out.println("\n");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 4: {
				System.out.println(or.orderList());
				System.out.println("\n");
			}
				break;
			case 5: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}
		} while (loop == 1);
	}

}
