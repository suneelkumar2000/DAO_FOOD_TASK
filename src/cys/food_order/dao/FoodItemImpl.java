package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.food_order.model.FoodItem;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class FoodItemImpl implements FoodItemDAO {

	Validation val = new Validation();

	@Override
	public void insertFoodDetails(FoodItem food) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into fooditem(name,quantity,unit_price,item_category) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean name = val.nameValidation(food.getName());
		boolean quantity = val.numberValidation(food.getQuantity());
		boolean unitPrice = val.numberValidation(food.getUnitPrice());
		boolean itemCategory = val.nameValidation(food.getItemCategory());

		if (name == true && quantity == true && unitPrice == true && itemCategory == true) {
			ps.setString(1, food.getName());
			ps.setInt(2, food.getQuantity());
			ps.setInt(3, food.getUnitPrice());
			ps.setString(4, food.getItemCategory());

			int execute = ps.executeUpdate();
			System.out.println(execute + " Inserted successfully");
		} else
			System.out.println("Invalid Input");
	}

	@Override
	public int updateQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update fooditem set quantity =? where id=?";
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
	public int deleteFoodDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from fooditem where id=?";
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
	public void findByName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,name,quantity,unit_price,item_category from fooditem where name=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getInt(4) + "\s"
					+ rs.getString(5));
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
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getInt(4) + "\s"
					+ rs.getString(5));
		}

	}

	@Override
	public List<FoodItem> foodList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,name,quantity,unit_price,item_category from fooditem";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
		while (rs.next()) {
			int id = rs.getInt(1);
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
			foodList.add(food);
		}
		return foodList;
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
