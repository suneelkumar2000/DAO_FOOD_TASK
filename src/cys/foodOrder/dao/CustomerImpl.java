package cys.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.foodOrder.model.Customer;
import cys.foodOrder.util.ConnectionUtil;

public class CustomerImpl implements CustomerDAO{

	@Override
	public int insertCustomerDetails(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into customer(id,email,phoneNo,Fname,Lname) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		ps.setInt(1, customer.getId());
		ps.setString(2, customer.getEmail());
		ps.setLong(3, customer.getPhoneNo());
		ps.setString(4, customer.getFname());
		ps.setString(5, customer.getLname());

		int execute = ps.executeUpdate();
		return execute;
	}

	@Override
	public int deleteCustomerDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from customer where id=?";
		PreparedStatement ps = con.prepareStatement(delete);

		ps.setInt(1, id);

		int executeUpdate = ps.executeUpdate();
		return executeUpdate;
	}

	@Override
	public List<Customer> customerList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,email,phoneNo,Fname,Lname from customer";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList List = new ArrayList();
		while (rs.next()) {
			int id= rs.getInt(1);
			String email = rs.getString(2);
			Long phoneNo = rs.getLong(3);
			String Fname = rs.getString(4);
			String Lname = rs.getString(5);
			int foodId = rs.getInt(6);
			Customer customer = new Customer();
			customer.setId(id);
			customer.setEmail(email);
			customer.setPhoneNo(phoneNo);
			customer.setFname(Fname);
			customer.setLname(Lname);
			List.add(customer);
		}
		return List;
	}

}
