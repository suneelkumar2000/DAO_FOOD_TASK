package cys.foodOrder.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.foodOrder.dao.MenuImpl;
import cys.foodOrder.model.Menu;

public class MenuTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		MenuImpl mi = new MenuImpl();
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert menu details" + "\n 2.Udate Date" + "\n 3.delete menu"
					+ "\n 4.Find menu" + "\n 5.show menu List" + "\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter menu ID: ");
				int id = sc.nextInt();
				if (id > 0) {
					menu.setId(id);
					System.out.print("Enter Start Date (yyyy/mm/dd): ");
					String startDate = sc.next();
					if (startDate != null) {
						menu.setStartDate(startDate);
						System.out.print("Enter End Date (yyyy/mm/dd): ");
						String endDate = sc.next();
						if (endDate != null) {
							menu.setEndDate(endDate);
							System.out.print("Enter Food Id: ");
							int foodId = sc.nextInt();
							if (foodId > 0) {
								menu.setFoodId(foodId);
								System.out.println(mi.insertMenuDetails(menu) + " Inserted successfully");
								System.out.println("\n");
							} else
								System.out.println("Invalid Food Id");
						} else
							System.out.println("Invalid End Date");
					} else
						System.out.println("Invalid Start Date");
				} else
					System.out.println("Invalid menu ID");
			}
				break;
			case 2: {
				System.out.println("select the option" + "\n 1.Update Start Date" + "\n 2.Update End Date");
				int option1 = sc.nextInt();
				switch (option1) {
				case 1: {
					System.out.print("Enter Menu ID to update:");
					int id = sc.nextInt();
					if (id > 0) {
						System.out.print("Enter New Start Date: ");
						String startDate = sc.next();
						if (startDate != null) {
							mi.updateStartDate(id,startDate);
							System.out.println("\n");
						} else
							System.out.println("Invalid input");
					} else
						System.out.println("Invalid input");
				}
					break;
				case 2: {
					System.out.print("Enter Menu ID to update:");
					int id = sc.nextInt();
					if (id > 0) {
						System.out.print("Enter New End Date: ");
						String endDate = sc.next();
						if (endDate != null) {
							mi.updateStartDate(id,endDate);
							System.out.println("\n");
						} else
							System.out.println("Invalid input");
					} else
						System.out.println("Invalid input");
				}
					break;
				}
			}
				break;
			case 3: {
				System.out.print("Enter menu ID to delete: ");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(mi.delete(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid menu ID");
			}
				break;
			case 4: {
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
			case 5: {
				System.out.println(mi.menuList()); 
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
