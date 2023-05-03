package cys.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.foodOrder.model.FoodItem;
import cys.foodOrder.model.Menu;
import cys.foodOrder.util.ConnectionUtil;

public class MenuImpl implements MenuDAO {

	@Override
	public int insertMenuDetails(Menu menu) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into menu(id,start_date,end_date,food_id) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		ps.setInt(1, menu.getId());
		ps.setString(2, menu.getStartDate());
		ps.setString(3, menu.getEndDate());
		ps.setInt(4, menu.getFoodId());
		int execute = ps.executeUpdate();
		
		String price = "select unit_price from fooditem where id=?";
		PreparedStatement ps1 = con.prepareStatement(price);
		ps1.setInt(1, menu.getFoodId());
		ResultSet rs = ps1.executeQuery();
		while (rs.next()) {
			int p = rs.getInt(1);
			String insert1 = "update menu set price=? where id=?";
			PreparedStatement ps2 = con.prepareStatement(insert1);
			ps2.setInt(1, p);
			ps2.setInt(2, menu.getId());
			ps2.executeUpdate();
		}
		return execute;
	}

	@Override
	public int updateStartDate(int id, String startDate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update menu set start_date=? where id=?";
		PreparedStatement ps = con.prepareStatement(update);

		ps.setString(1, startDate);
		ps.setInt(2, id);

		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public int updateEndDate(int id, String endDate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update menu set end_date=? where id=?";
		PreparedStatement ps = con.prepareStatement(update);

		ps.setString(1, endDate);
		ps.setInt(2, id);

		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from menu where id=?";
		PreparedStatement ps = con.prepareStatement(delete);

		ps.setInt(1, id);

		int executeUpdate = ps.executeUpdate();
		return executeUpdate;
	}

	@Override
	public void findByFoodId(int foodId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,price,start_date,end_date,food_id from menu where food_id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, foodId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getInt(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4)
					+ "\s" + rs.getInt(5));
		}
	}

	@Override
	public void findById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,price,start_date,end_date,food_id from menu where id=?";
		PreparedStatement ps = con.prepareStatement(find);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getInt(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4)
					+ "\s" + rs.getInt(5));
		}
	}

	@Override
	public List<Menu> menuList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select menu.*,fooditem.unit_price from fooditem left join menu on fooditem.id =menu.food_id ;";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList List = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt(1);
			int price = rs.getInt(2);
			String startDate = rs.getString(3);
			String endDate = rs.getString(4);
			int foodId = rs.getInt(5);
			Menu m = new Menu();
			m.setId(id);
			m.setPrice(price);
			m.setStartDate(startDate);
			m.setEndDate(endDate);
			m.setFoodId(foodId);
			List.add(m);
		}
		return List;
	}

}
