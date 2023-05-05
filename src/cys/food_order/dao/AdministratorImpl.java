package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.food_order.model.Administrator;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class AdministratorImpl implements AdministratorDAO{

	Validation val = new Validation();
	@Override
	public void insertAdministratorDetails(Administrator admin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into administrator(name,user_name,password) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean name = val.nameValidation(admin.getName());

		if (name == true) {
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUserName());
			ps.setString(3, admin.getPassword());
			int execute = ps.executeUpdate();
			System.out.println(execute + " Inserted successfully");

			String price = "select id from administrator where user_name=?";
			PreparedStatement ps1 = con.prepareStatement(price);
			ps1.setString(1, admin.getUserName());
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println("your Admin id is : " + id);
			}
		} else
			System.out.println("Invalid Input");
	}

	@Override
	public int deleteAdministratorDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from administrator where id=?";
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
	public List<Administrator> administratorList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,name,user_name,password from administrator";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<Administrator> AdminList = new ArrayList<Administrator>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String userName = rs.getString(3);
			String password = rs.getString(4);
			Administrator admin = new Administrator();
			admin.setId(id);
			admin.setName(name);
			admin.setUserName(userName);
			admin.setPassword(password);
			AdminList.add(admin);
		}
		return AdminList;
	}

}
