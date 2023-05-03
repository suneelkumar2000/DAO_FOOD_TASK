package cys.foodOrder.dao;

import java.sql.SQLException;
import java.util.List;

import cys.foodOrder.model.Order;

public interface OrderDAO {
	public int insertOrder(Order order) throws ClassNotFoundException, SQLException;
	public int updateOrderQuantity(int id,int quantity) throws ClassNotFoundException, SQLException;
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException;
	public List<Order> orderList() throws ClassNotFoundException, SQLException;
	public void findById(int id) throws ClassNotFoundException, SQLException;
}
