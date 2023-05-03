package cys.foodOrder.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.foodOrder.dao.OrderImpl;
import cys.foodOrder.model.Order;

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
				if (id > 0) {
					order.setId(id);
					System.out.print("Enter order Date (yyyy/mm/dd): ");
					String date = sc.next();
					if (date != null) {
						order.setDate(date);
						System.out.print("Enter Customer Id: ");
						int customerId = sc.nextInt();
						if (customerId > 0) {
							order.setCustomerId(customerId);
							System.out.print("Enter Food Id: ");
							int foodId = sc.nextInt();
							if (foodId > 0) {
								order.setFoodId(foodId);
								System.out.print("Enter Food Quantity: ");
								int quantity = sc.nextInt();
								if (quantity > 0) {
									order.setQuantity(quantity);
									System.out.println(or.insertOrder(order)+" Inserted successfully");
									System.out.println("\n");
								} else
									System.out.println("Invalid Quantity");
							} else
								System.out.println("Invalid Food Id");
						} else
							System.out.println("Invalid Customer Id");
					} else
						System.out.println("Invalid Date");
				} else
					System.out.println("Invalid order ID");
			}
				break;
			case 2: {
				System.out.print("Enter order ID to update:");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.print("Enter New Quantity: ");
					int quantity = sc.nextInt();
					if (quantity > 0) {
						or.updateOrderQuantity(id, quantity);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 3: {
				System.out.print("Enter order ID to delete: ");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(or.deleteOrder(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid menu ID");
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