package cys.foodOrder.model;

public class Customer {
	private Integer id;
	private String email;
	private Long phoneNo;
	private String Fname;
	private String Lname;

	public Customer() {
	}

	public Customer(Integer id, String email, Long phoneNo, String Fname, String Lname) {
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.Fname = Fname;
		this.Lname = Lname;
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
	
	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo =phoneNo;
	}
	public String getFname() {
		return Fname;
	}

	public void setFname(String Fname) {
		this.Fname = Fname;
	}
	public String getLname() {
		return Lname;
	}

	public void setLname(String Lname) {
		this.Lname = Lname;
	}
	
	public String toString() {
		return "Customers [Customer id= " + id + ", email= " + email + ", phoneNo = " + phoneNo + ", Fname= " + Fname+ ", Lname = " + Lname +"]";
	}
}
