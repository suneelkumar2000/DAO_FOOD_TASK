package cys.foodOrder.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cys.foodOrder.dao.PaymentImpl;
import cys.foodOrder.model.Payment;

public class PaymentTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PaymentImpl pay = new PaymentImpl();
		Payment payment = new Payment();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Payment details"+ "\n 2.show Payment List" + "\n 3.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Payment ID: ");
				int id = sc.nextInt();
				if (id > 0) {
					payment.setId(id);
					System.out.print("Enter Date (yyyy/mm/dd): ");
					String date = sc.next();
					if (date != null) {
						payment.setDate(date);
						System.out.print("Enter order Id: ");
						int orderId = sc.nextInt();
						if (orderId > 0) {
							payment.setOrderId(orderId);
							System.out.print("Enter customer Id: ");
							int customerId = sc.nextInt();
							if (customerId > 0) {
								payment.setCustomerId(customerId);
									System.out.println(pay.insertPayment(payment) + " Inserted successfully");
									System.out.println("\n");
							} else
								System.out.println("Invalid customer Id");
						} else
							System.out.println("Invalid order Id");
					} else
						System.out.println("Invalid Date");
				} else
					System.out.println("Invalid Payment ID");
			}
				break;
			case 2: {
				System.out.println(pay.paymentList());
				System.out.println("\n");
			}
				break;
			case 3: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}
		} while (loop == 1);
	}
}
