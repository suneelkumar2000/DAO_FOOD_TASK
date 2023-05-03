package cys.foodOrder.dao;

import java.sql.SQLException;
import java.util.List;

import cys.foodOrder.model.OrderItem;

public interface OrderItemDAO {
	public int insertOrder(OrderItem order) throws ClassNotFoundException, SQLException;
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException;
	public List<OrderItem> orderList() throws ClassNotFoundException, SQLException;
	public void findById(int id) throws ClassNotFoundException, SQLException;
}
