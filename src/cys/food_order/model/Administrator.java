package cys.food_order.model;

public class Administrator {
	private Integer id;
	private String name;
	private String userName;
	private String password;
	
public Administrator() {}

public Administrator(Integer id, String name, String userName,String password ) {
	this.setId(id);
	this.setName(name);
	this.setUserName(userName);
	this.setPassword(password);
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String toString() {
	return "Customers [Customer id= " + id + ", Name= " + name + ", userName = " + userName + ", password = " + password + "]";
}
}