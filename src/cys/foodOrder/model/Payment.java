package cys.foodOrder.model;

public class Payment {
	private int id;
	private String date;
	private int orderId;
	private int customerId;
	private int amount;
	
	public Payment() {}
	
	public Payment(int id,String date,int orderId,int customerId,int amount) {
		this.id=id;
		this.date=date;
		this.orderId=orderId;
		this.customerId=customerId;
		this.amount=amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override

	public String toString() {
		return "Order [id = " + id + ", date = " + date + " order Id = " + orderId+ ", customerId = " + customerId + ", amount = " + amount + "]";
	}
}
