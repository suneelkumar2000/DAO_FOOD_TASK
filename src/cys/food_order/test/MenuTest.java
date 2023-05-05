package cys.food_order.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.food_order.dao.MenuImpl;
import cys.food_order.model.Menu;

public class MenuTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		MenuImpl mi = new MenuImpl();
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter : ");

		int loop = 1;

		System.out.println("select the option" + "\n 1.Customer Login" + "\n 2.Admin login");
		int login = sc.nextInt();
		switch (login) {
		case 1: {
			System.out.println("enter your Customer id:");
			int customerId = sc.nextInt();
			boolean customerLogin = mi.customerLogin(customerId);
			if (customerLogin == true) {
				System.out.println("your menu :");
				mi.display();
			} else
				System.out.println("Invalid Customer Id");
		}
			break;
		case 2: {
			System.out.println("Enter admin User name:");
			String userName = sc.next();
			System.out.println("Enter admin password:");
			String password = sc.next();
			boolean adminLogin = mi.adminLogin(userName,password);
			if (adminLogin == true) {
				do {
					System.out.println("select the option" + "\n 1.insert menu details" + "\n 2.delete menu"
							+ "\n 3.Find menu" + "\n 4.show menu List" + "\n 5.exit");
					int option = sc.nextInt();
					switch (option) {
					case 1: {

						System.out.print("Enter Food Id: ");
						int foodId = sc.nextInt();
						menu.setFoodId(foodId);
						mi.insertMenuDetails(menu);
						System.out.println("\n");
					}
						break;
					case 2: {
						System.out.print("Enter menu ID to delete: ");
						int id = sc.nextInt();
						System.out.println(mi.delete(id) + " Deleted successfully");
						System.out.println("\n");
					}
						break;
					case 3: {
						System.out.println("select the option" + "\n 1.Find by Menu ID" + "\n 2.Find by Food Id");
						int option2 = sc.nextInt();
						switch (option2) {
						case 1: {
							System.out.print("Enter Menu ID to find:");
							int id = sc.nextInt();
							if (id > 0) {
								mi.findById(id);
								System.out.println("\n");
							} else
								System.out.println("Invalid input");
						}
							break;
						case 2: {
							System.out.print("Enter Food Id to find:");
							int foodId = sc.nextInt();
							if (foodId > 0) {
								mi.findByFoodId(foodId);
								System.out.println("\n");
							} else
								System.out.println("Invalid input");
						}
							break;
						}
					}
						break;
					case 4: {
						System.out.println(mi.menuList());
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
			} else
				System.out.println("Invalid User name and password");
		}
			break;

		}
	}

}
