package cys.food_order.model;

public class FoodItem {
	private Integer id;
	private String name;
	private Integer quantity;
	private Integer unitPrice;
	private String itemCategory;

	public FoodItem() {
	}

	public FoodItem(Integer id, String name, Integer quantity, Integer unitPrice, String itemCategory) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.itemCategory = itemCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public String toString() {
		return "Food Items [food id= " + id + ", Name= " + name + ", Quantity = " + quantity + ", Unit Price= " + unitPrice
				+ ", Item Category= " + itemCategory + "]";
	}
}
