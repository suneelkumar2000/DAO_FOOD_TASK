package cys.food_order.model;

public class Customer {
	private Integer id;
	private String email;
	private Long phoneNumber;
	private String firstName;
	private String lastname;

	public Customer() {
	}

	public Customer(Integer id, String email, Long phoneNumber, String firstName, String lastname) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber =phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String toString() {
		return "Customers [Customer id= " + id + ", email= " + email + ", Phone Number = " + phoneNumber + ", FirstName = " + firstName + ", LastName = " + lastname +"]";
	}
}
