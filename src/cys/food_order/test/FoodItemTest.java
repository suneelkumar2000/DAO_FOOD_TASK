package cys.food_order.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cys.food_order.dao.FoodItemImpl;
import cys.food_order.model.FoodItem;

public class FoodItemTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		FoodItemImpl fi = new FoodItemImpl();
		FoodItem food = new FoodItem();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Food details" + "\n 2.Udate quantity"
					+ "\n 3.delete Food Item" + "\n 4.Find Food Item" + "\n 5.show Food List" + "\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Food ID: ");
				int id = sc.nextInt();
				food.setId(id);
				System.out.print("Enter Food Name: ");
				String name = sc.next();
				food.setName(name);
				System.out.print("Enter Quantity : ");
				int quantity = sc.nextInt();
				food.setQuantity(quantity);
				System.out.print("Enter Unit Price: ");
				int unitPrice = sc.nextInt();
				food.setUnitPrice(unitPrice);
				System.out.print("Enter Food Item Category: ");
				String itemCategory = sc.next();
				food.setItemCategory(itemCategory);
				
				fi.insertFoodDetails(food);
				System.out.println("\n");
			}
				break;
			case 2: {
				System.out.print("Enter Food ID:");
				int id = sc.nextInt();
				System.out.print("Enter Quantity :");
				int quantity = sc.nextInt();
				System.out.println(fi.updateQuantity(id, quantity) + " Updated successfully ");
				System.out.println("\n");
			}
				break;

			case 3: {
				System.out.print("Enter Food ID to delete: ");
				int id = sc.nextInt();
				System.out.println(fi.deleteFoodDetails(id) + " Deleted successfully");
				System.out.println("\n");
			}
				break;
			case 4: {
				System.out.println("select the option" + "\n 1.Find by Food ID" + "\n 2.Find by Food Name");
				int option2 = sc.nextInt();
				switch (option2) {
				case 1: {
					System.out.print("Enter Food ID to find:");
					int id = sc.nextInt();
					if (id > 0) {
						fi.findById(id);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				case 2: {
					System.out.print("Enter Food Name to find:");
					String name = sc.next();
					Pattern p = Pattern.compile("[a-zA-Z]+");
					Matcher m = p.matcher(name);
					boolean b = m.matches();
					if (b && name != null) {
						fi.findByName(name);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				}
			}
				break;
			case 5: {
				System.out.println(fi.foodList());
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