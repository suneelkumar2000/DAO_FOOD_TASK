package cys.foodOrder.model;

public class OrderItem {
	private Integer id;
	private Integer foodId;
	private Integer quantity;
	private Integer unitPrice;
	
	public OrderItem(){}
	
	public OrderItem(Integer id,Integer foodId,Integer quantity,Integer unitPrice){
		this.id=id;
		this.foodId=foodId;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
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
	
	@Override
	public String toString() {
		return "Order Items [Main id = " + id + ", Food Id = " + foodId + ", Quantity = "+ quantity + ", Unit Price = " + unitPrice + "]";
	}
}
