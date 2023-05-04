package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Order;

public interface OrderDAO {
	public void insertOrder(Order order) throws ClassNotFoundException, SQLException;
	public int updateOrderQuantity(int id,int quantity) throws ClassNotFoundException, SQLException;
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException;
	public List<Order> orderList() throws ClassNotFoundException, SQLException;
	public void findById(int id) throws ClassNotFoundException, SQLException;
}
