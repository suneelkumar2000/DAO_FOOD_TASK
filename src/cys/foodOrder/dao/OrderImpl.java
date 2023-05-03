package cys.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.foodOrder.model.Order;
import cys.foodOrder.util.ConnectionUtil;

public class OrderImpl implements OrderDAO {

	@Override
	public int insertOrder(Order order) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into orders(id,date,customer_id,food_id,quantity)values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, order.getId());
		ps.setString(2, order.getDate());
		ps.setInt(3, order.getCustomerId());
		ps.setInt(4, order.getFoodId());
		ps.setInt(5, order.getQuantity());
		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public int updateOrderQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update orders set quantity=? where id=?";
		PreparedStatement ps = con.prepareStatement(update);

		ps.setInt(1, quantity);
		ps.setInt(2, id);

		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from orders where id=?";
		PreparedStatement ps = con.prepareStatement(delete);

		ps.setInt(1, id);

		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public List<Order> orderList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,date,customer_id,food_id,quantity from orders";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String date = rs.getString(2);
			int customerId = rs.getInt(3);
			int foodId = rs.getInt(4);
			int quantity = rs.getInt(5);
			Order order = new Order();
			order.setId(id);
			order.setDate(date);
			order.setCustomerId(customerId);
			order.setFoodId(foodId);
			order.setQuantity(quantity);
			list.add(order);
		}
		return list;
	}

	@Override
	public void findById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,date,customer_id,food_id,quantity from orders where id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getInt(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4)
					+ "\s" + rs.getInt(5));
		}
	}

}
