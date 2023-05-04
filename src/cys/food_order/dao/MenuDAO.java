package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Menu;


public interface MenuDAO {
	public void insertMenuDetails(Menu menu)throws ClassNotFoundException, SQLException;
	public int delete(int id)throws ClassNotFoundException, SQLException;
	public void findByFoodId(int food_id)throws ClassNotFoundException, SQLException;
	public void findById(int id)throws ClassNotFoundException, SQLException;
	public List<Menu> menuList()throws ClassNotFoundException, SQLException;
}
