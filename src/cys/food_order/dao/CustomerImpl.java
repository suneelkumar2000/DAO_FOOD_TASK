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
		String insert = "insert into customer(id,email,phone_number,first_name,last_name) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean num = val.numberValidation(customer.getId());
		boolean email = val.emailValidation(customer.getEmail());
		boolean phone = val.phoneValidation(customer.getPhoneNumber());
		boolean firstName = val.nameValidation(customer.getFirstName());
		boolean lastName = val.nameValidation(customer.getFirstName());

		if (num == true && email == true && phone == true && firstName == true && lastName == true) {
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getPhoneNumber());
			ps.setString(4, customer.getFirstName());
			ps.setString(5, customer.getLastName());
			int execute = ps.executeUpdate();
			System.out.println(execute + " Inserted successfully");
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
			int foodId = rs.getInt(6);
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
}
