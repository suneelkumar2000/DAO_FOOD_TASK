package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.food_order.model.Customer;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class CustomerImpl implements CustomerDAO {

	Validation val = new Validation();

	@Override
	public void insertCustomerDetails(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into customer(email,phone_number,first_name,last_name) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean email = val.emailValidation(customer.getEmail());
		boolean phone = val.phoneValidation(customer.getPhoneNumber());
		boolean firstName = val.nameValidation(customer.getFirstName());
		boolean lastName = val.nameValidation(customer.getLastName());

		if (email == true && phone == true && firstName == true && lastName == true) {
			ps.setString(1, customer.getEmail());
			ps.setLong(2, customer.getPhoneNumber());
			ps.setString(3, customer.getFirstName());
			ps.setString(4, customer.getLastName());
			int execute = ps.executeUpdate();
			System.out.println(execute + " Inserted successfully");

			String customerId = "select id from customer where email=?";
			PreparedStatement ps1 = con.prepareStatement(customerId);
			ps1.setString(1, customer.getEmail());
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println("your Customer id is : " + id);
			}
		} else
			System.out.println("Invalid Input");
	}

	@Override
	public int deleteCustomerDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from customer where id=?";
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
	public List<Customer> customerList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select id,email,phone_number,first_name,last_name from customer";
		PreparedStatement ps = con.prepareStatement(display);
		ResultSet rs = ps.executeQuery();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String email = rs.getString(2);
			Long phoneNo = rs.getLong(3);
			String firstName = rs.getString(4);
			String lastName = rs.getString(5);
			Customer customer = new Customer();
			customer.setId(id);
			customer.setEmail(email);
			customer.setPhoneNumber(phoneNo);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerList.add(customer);
		}
		return customerList;
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
