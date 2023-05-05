package cys.food_order.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cys.food_order.dao.PaymentImpl;
import cys.food_order.model.Payment;

public class PaymentTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PaymentImpl pay = new PaymentImpl();
		Payment payment = new Payment();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Payment details" + "\n 2.show Payment List" + "\n 3.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				
				System.out.print("Enter order Id: ");
				int orderId = sc.nextInt();
				payment.setOrderId(orderId);
				
				System.out.print("Enter customer Id: ");
				int customerId = sc.nextInt();
				payment.setCustomerId(customerId);
				
				pay.insertPayment(payment);
				System.out.println("\n");
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
