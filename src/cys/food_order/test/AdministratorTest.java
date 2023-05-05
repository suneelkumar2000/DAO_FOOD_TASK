package cys.food_order.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.food_order.dao.AdministratorImpl;
import cys.food_order.model.Administrator;

public class AdministratorTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		AdministratorImpl admin = new AdministratorImpl();
		Administrator administrator = new Administrator();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert admin details" + "\n 2.delete admin details"
					+ "\n 3.show admin List" + "\n 4.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter admin Name: ");
				String name = sc.next();
				administrator.setName(name);
				System.out.print("Enter userName: ");
				String userName = sc.next();
				administrator.setUserName(userName);
				System.out.print("Enter Password: ");
				String password = sc.next();
				administrator.setPassword(password);
				admin.insertAdministratorDetails(administrator);
				System.out.println("\n");
			}
				break;
			case 2: {
				System.out.print("Enter Customer ID to delete: ");
				int id = sc.nextInt();

				System.out.println(admin.deleteAdministratorDetails(id) + " Deleted successfully");
				System.out.println("\n");

			}
				break;
			case 3: {
				System.out.println(admin.administratorList());
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
