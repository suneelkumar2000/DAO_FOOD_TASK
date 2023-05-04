package cys.food_order.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.food_order.dao.OrderImpl;
import cys.food_order.model.Order;

public class OrderTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OrderImpl or = new OrderImpl();
		Order order = new Order();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert order details" + "\n 2.Udate Quantity"
					+ "\n 3.delete order" + "\n 4.Find order" + "\n 5.show order List" + "\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter order ID: ");
				int id = sc.nextInt();
				order.setId(id);

				System.out.print("Enter Customer Id: ");
				int customerId = sc.nextInt();
				order.setCustomerId(customerId);

				System.out.print("Enter Food Id: ");
				int foodId = sc.nextInt();
				order.setFoodId(foodId);

				System.out.print("Enter Food Quantity: ");
				int quantity = sc.nextInt();
				order.setQuantity(quantity);

				or.insertOrder(order);
				System.out.println("\n");
			}
				break;
			case 2: {
				System.out.print("Enter order ID to update:");
				int id = sc.nextInt();

				System.out.print("Enter New Quantity: ");
				int quantity = sc.nextInt();

				or.updateOrderQuantity(id, quantity);
				System.out.println("\n");
			}
				break;
			case 3: {
				System.out.print("Enter order ID to delete: ");
				int id = sc.nextInt();

				System.out.println(or.deleteOrder(id) + " Deleted successfully");
				System.out.println("\n");

			}
				break;
			case 4: {

				System.out.print("Enter order ID to find:");
				int id = sc.nextInt();
				if (id > 0) {
					or.findById(id);
					System.out.println("\n");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 5: {
				System.out.println(or.orderList());
				System.out.println("\n");
			}
				break;
			case 6: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}
		} while (loop == 1);
	}
}