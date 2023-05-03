package cys.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.foodOrder.model.FoodItem;
import cys.foodOrder.util.ConnectionUtil;


public class FoodItemImpl implements FoodItemDAO{

	@Override
	public int insertFoodDetails(FoodItem food) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into fooditem(id,name,quantity,unit_price,item_category) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		ps.setInt(1, food.getId());
		ps.setString(2, food.getName());
		ps.setInt(3, food.getQuantity());
		ps.setInt(4, food.getUnitPrice());
		ps.setString(5, food.getItemCategory());

		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public int updateQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update fooditem set quantity =? where id=?";
		PreparedStatement ps = con.prepareStatement(update);
		
		ps.setInt(1, quantity);
		ps.setInt(2, id);
		
		int executeUpdate = ps.executeUpdate();
		return executeUpdate;
	}

	@Override
	public int deleteFoodDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "delete from fooditem where id=?";
		PreparedStatement ps = con.prepareStatement(update);
		
		ps.setInt(1, id);
		
		int executeUpdate = ps.executeUpdate();
		return executeUpdate;
	}

	@Override
	public void findByName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,name,quantity,unit_price,item_category from fooditem where name=?";
		PreparedStatement ps = con.prepareStatement(find);
		
		ps.setString(1,name);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getInt(4)+ "\s" + rs.getString(5));
		}
	}

	@Override
	public void findById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,name,quantity,unit_price,item_category from fooditem where id=?";
		PreparedStatement ps = con.prepareStatement(find);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getInt(4)+ "\s" + rs.getString(5));
		}
		
	}

	@Override
	public List<FoodItem> foodList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,name,quantity,unit_price,item_category from fooditem";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<FoodItem> List = new ArrayList<FoodItem>();
		while (rs.next()) {
			int id= rs.getInt(1);
			String name = rs.getString(2);
			int quantity = rs.getInt(3);
			int unitPrice = rs.getInt(4);
			String itemCategory = rs.getString(5);
			FoodItem food = new FoodItem();
			food.setId(id);
			food.setName(name);
			food.setQuantity(quantity);
			food.setUnitPrice(unitPrice);
			food.setItemCategory(itemCategory);
			List.add(food);
		}
		return List;
	}

}
