package cys.foodOrder.dao;

import java.sql.SQLException;
import java.util.List;

import cys.foodOrder.model.Menu;


public interface MenuDAO {
	public int insertMenuDetails(Menu menu)throws ClassNotFoundException, SQLException;
	public int updateStartDate(int id,String start_date)throws ClassNotFoundException, SQLException;
	public int updateEndDate(int id,String end_date)throws ClassNotFoundException, SQLException;
	public int delete(int id)throws ClassNotFoundException, SQLException;
	public void findByFoodId(int food_id)throws ClassNotFoundException, SQLException;
	public void findById(int id)throws ClassNotFoundException, SQLException;
	public List<Menu> menuList()throws ClassNotFoundException, SQLException;
}
