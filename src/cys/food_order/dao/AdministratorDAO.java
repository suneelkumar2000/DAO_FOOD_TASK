package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Administrator;

public interface AdministratorDAO {
	public void insertAdministratorDetails(Administrator admin)throws ClassNotFoundException, SQLException;
	public int deleteAdministratorDetails(int id)throws ClassNotFoundException, SQLException;
	public List<Administrator> administratorList()throws ClassNotFoundException, SQLException;
}
