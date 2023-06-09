package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cys.food_order.model.FoodItem;
import cys.food_order.model.Menu;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class MenuImpl implements MenuDAO {

	Validation val = new Validation();
	Date date = new Date();
	java.sql.Date sqldate = new java.sql.Date(date.getTime());

	@Override
	public void insertMenuDetails(Menu menu) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into menu(date,food_id) values(?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean FoodId = val.numberValidation(menu.getFoodId());

		if (FoodId == true) {
			ps.setDate(1, sqldate);
			ps.setInt(2, menu.getFoodId());
			int execute = ps.executeUpdate();

			String price = "select unit_price from fooditem where id=?";
			PreparedStatement ps1 = con.prepareStatement(price);
			ps1.setInt(1, menu.getFoodId());
			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				int p = rs.getInt(1);
				String insert1 = "update menu set price=? where food_id=?";
				PreparedStatement ps2 = con.prepareStatement(insert1);
				ps2.setInt(1, p);
				ps2.setInt(2, menu.getFoodId());
				ps2.executeUpdate();
			}
			System.out.println(execute + " Inserted successfully");
		} else
			System.out.println("Invalid Input");
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from menu where id=?";
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
	public void findByFoodId(int foodId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,price,date,food_id from menu where food_id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, foodId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getInt(2) + "\s" + rs.getDate(3) + "\s" + rs.getInt(4));
		}
	}

	@Override
	public void findById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,price,date,food_id from menu where id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getInt(2) + "\s" + rs.getDate(3) + "\s" + rs.getInt(4));
		}
	}

	@Override
	public List<Menu> menuList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,price,date,food_id from menu ;";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		while (rs.next()) {
			int id = rs.getInt(1);
			int price = rs.getInt(2);
			Date date = rs.getDate(3);
			int foodId = rs.getInt(4);
			Menu m = new Menu();
			m.setId(id);
			m.setPrice(price);
			m.setDate((java.sql.Date) date);
			m.setFoodId(foodId);
			menuList.add(m);
		}
		return menuList;
	}

	@Override
	public void display() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select menu.id,price ,fooditem.id,name from fooditem cross join menu;";
		PreparedStatement ps = con.prepareStatement(find);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("menuId: " + rs.getInt(1) + "\t" + "FoodId: " + rs.getInt(3) + "\t" + "Food name: "
					+ rs.getString(4) + "\t" + "Price: " + rs.getInt(2));
		}
	}

	@Override
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