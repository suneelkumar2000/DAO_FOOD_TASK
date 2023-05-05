package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cys.food_order.model.Order;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class OrderImpl implements OrderDAO {

	Validation val = new Validation();
	Date date=new Date();
	java.sql.Date sqldate=new java.sql.Date(date.getTime());
	
	@Override
	public void insertOrder(Order order) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into orders(id,date,customer_id,food_id,quantity)values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		
		boolean customerId = val.numberValidation(order.getCustomerId());
		boolean foodId = val.numberValidation(order.getFoodId());
		boolean quantity = val.numberValidation(order.getQuantity());
		
		if (customerId == true && foodId == true && quantity == true) {
		ps.setInt(1, order.getId());
		ps.setDate(2,sqldate);
		ps.setInt(3, order.getCustomerId());
		ps.setInt(4, order.getFoodId());
		ps.setInt(5, order.getQuantity());
		int execute = ps.executeUpdate();
		System.out.println(execute + " Inserted successfully");
		} else
			System.out.println("Invalid Input");
	}

	@Override
	public int updateOrderQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update orders set quantity=? where id=?";
		PreparedStatement ps = con.prepareStatement(update);
		boolean num = val.numberValidation(id);
		boolean quan = val.numberValidation(quantity);
		if (num == true && quan == true) {
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}

	@Override
	public int deleteOrder(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from orders where id=?";
		PreparedStatement ps = con.prepareStatement(delete);

		boolean num = val.numberValidation(id);
		if (num == true) {
			ps.setInt(1, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate;
		} else
			return 0;
	}

	@Override
	public List<Order> orderList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,date,customer_id,food_id,quantity from orders";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<Order> orderList = new ArrayList<Order>();
		while (rs.next()) {
			int id = rs.getInt(1);
			Date date = rs.getDate(2);
			int customerId = rs.getInt(3);
			int foodId = rs.getInt(4);
			int quantity = rs.getInt(5);
			Order order = new Order();
			order.setId(id);
			order.setDate((java.sql.Date)date);
			order.setCustomerId(customerId);
			order.setFoodId(foodId);
			order.setQuantity(quantity);
			orderList.add(order);
		}
		return orderList;
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
			System.out.println(rs.getInt(1) + "\s" + rs.getDate(2) + "\s" + rs.getInt(3) + "\s" + rs.getInt(4)+ "\s" + rs.getInt(5));
		}
	}

	@Override
	public void display() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select food_id from menu";
		PreparedStatement ps = con.prepareStatement(find);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Food id: "+rs.getInt(1));
		}
	}
	
	public boolean customerLogin(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id from customer where id=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setInt(1, customerId);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			if (customerId == id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean adminLogin(String userName,String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select password from administrator where user_name=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setString(1, userName);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String pass = rs.getString(1);
			if (password.equals(pass)) {
				return true;
			}
		}
		return false;
	}

}
