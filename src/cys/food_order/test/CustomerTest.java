package cys.food_order.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cys.food_order.dao.CustomerImpl;
import cys.food_order.model.Customer;

public class CustomerTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CustomerImpl cus = new CustomerImpl();
		Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Customer details" + "\n 2.delete Customer details"
					+ "\n 3.show Customers List" + "\n 4.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Customer ID: ");
				int id = sc.nextInt();
				customer.setId(id);
				System.out.print("Enter Email ID: ");
				String email = sc.next();
				customer.setEmail(email);
				System.out.print("Enter Phone No: ");
				Long phoneNumber = sc.nextLong();
				customer.setPhoneNumber(phoneNumber);
				System.out.print("Enter Customer First Name: ");
				String firstName = sc.next();
				customer.setFirstName(firstName);
				System.out.print("Enter Customer Last Name: ");
				String lastName = sc.next();
				customer.setLastName(lastName);
				cus.insertCustomerDetails(customer);
				System.out.println("\n");
			}
				break;
			case 2: {
				System.out.print("Enter Customer ID to delete: ");
				int id = sc.nextInt();

				System.out.println(cus.deleteCustomerDetails(id) + " Deleted successfully");
				System.out.println("\n");

			}
				break;
			case 3: {
				System.out.println(cus.customerList());
				System.out.println("\n");
			}
				break;
			case 4: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}
		} while (loop == 1);
	}
}
