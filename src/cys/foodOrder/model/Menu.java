package cys.foodOrder.model;

public class Menu {
	private Integer id;
	private Integer price;
	private String startDate;
	private String endDate;
	private Integer foodId;

	public Menu() {}

	public Menu(Integer id, Integer price, String startDate, String endDate, Integer foodId) {
		this.id = id;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "Menu [Menu id= " + id + ", Price = " + price + ", Start date = " + startDate + ", End date = "
				+ endDate + ", Food id= " + foodId + "]";
	}
}
