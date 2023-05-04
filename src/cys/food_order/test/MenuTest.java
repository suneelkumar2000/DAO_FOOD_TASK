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
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert menu details" + "\n 2.delete menu" + "\n 3.Find menu"
					+ "\n 4.show menu List" + "\n 5.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter menu ID: ");
				int id = sc.nextInt();
				menu.setId(id);
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
	}
}
