package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Customer;

public interface CustomerDAO {
	public void insertCustomerDetails(Customer customer)throws ClassNotFoundException, SQLException;
	public int deleteCustomerDetails(int id)throws ClassNotFoundException, SQLException;
	public List<Customer> customerList()throws ClassNotFoundException, SQLException;
	public boolean adminLogin(String userName,String password) throws ClassNotFoundException, SQLException;
}
