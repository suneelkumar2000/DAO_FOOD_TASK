package cys.food_order.model;

import java.sql.Date;

public class Menu {
	private Integer id;
	private Integer price;
	private Date date;
	private Integer foodId;

	public Menu() {}

	public Menu(Integer id, Integer price,Date date, Integer foodId) {
		this.id = id;
		this.price = price;
		this.date = date;
		this.foodId = foodId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "Menu [Menu id= " + id + ", Price = " + price + ", date = " + date +", Food id= " + foodId + "]";
	}
}
