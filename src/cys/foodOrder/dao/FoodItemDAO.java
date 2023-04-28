package cys.foodOrder.dao;

import java.sql.SQLException;
import java.util.List;

import cys.foodOrder.model.FoodItem;



public interface FoodItemDAO {
	public int insertFoodDetails(FoodItem food)throws ClassNotFoundException, SQLException;
	public int updateQuantity(int id,int quantity)throws ClassNotFoundException, SQLException;
	public int deleteFoodDetails(int id)throws ClassNotFoundException, SQLException;
	public void findByName(String name)throws ClassNotFoundException, SQLException;
	public void findById(int id)throws ClassNotFoundException, SQLException;
	public List<FoodItem> foodList()throws ClassNotFoundException, SQLException;
}
