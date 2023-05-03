package cys.foodOrder.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cys.foodOrder.dao.CustomerImpl;
import cys.foodOrder.model.Customer;

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
				if (id > 0) {
					customer.setId(id);
					System.out.print("Enter Email ID: ");
					String email = sc.next();
					Pattern p = Pattern.compile("^(.+)@(.+)$");
					Matcher m = p.matcher(email);
					boolean b = m.matches();
					if (b) {
						customer.setEmail(email);
						System.out.print("Enter Phone No: ");
						Long phoneNo = sc.nextLong();
						if (id > 0) {
							customer.setPhoneNo(phoneNo);
							System.out.print("Enter Customer First Name: ");
							String Fname = sc.next();
							Pattern p1 = Pattern.compile("[a-zA-Z]+");
							Matcher m1 = p1.matcher(Fname);
							boolean b1 = m1.matches();
							if (b1 && Fname != null) {
								customer.setFname(Fname);
								System.out.print("Enter Customer Last Name: ");
								String Lname = sc.next();
								Pattern p2 = Pattern.compile("[a-zA-Z]+");
								Matcher m2 = p2.matcher(Lname);
								boolean b2 = m2.matches();
								if (b2 && Lname != null) {
									customer.setLname(Lname);
									System.out.println(cus.insertCustomerDetails(customer) + " Inserted successfully");
									System.out.println("\n");
								} else
									System.out.println("Invalid Last Name");
							} else
								System.out.println("Invalid First Name");
						} else
							System.out.println("Invalid Phone No");
					} else
						System.out.println("Invalid Email ID");
				} else
					System.out.println("Invalid Customer ID");
			}
				break;
			case 2: {
				System.out.print("Enter Customer ID to delete: ");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(cus.deleteCustomerDetails(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid Customer ID");
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
