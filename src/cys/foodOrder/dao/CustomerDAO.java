package cys.foodOrder.dao;

import java.sql.SQLException;
import java.util.List;

import cys.foodOrder.model.Customer;

public interface CustomerDAO {
	public int insertCustomerDetails(Customer customer)throws ClassNotFoundException, SQLException;
	public int deleteCustomerDetails(int id)throws ClassNotFoundException, SQLException;
	public List<Customer> customerList()throws ClassNotFoundException, SQLException;
}
