package cys.food_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cys.food_order.model.Payment;
import cys.food_order.util.ConnectionUtil;
import cys.food_order.validation.Validation;

public class PaymentImpl implements PaymentDAO {

	Validation val = new Validation();
	Date date = new Date();
	java.sql.Date sqldate = new java.sql.Date(date.getTime());

	@Override
	public void insertPayment(Payment payment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into payment(date,customer_id,order_id)values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		boolean customerId = val.numberValidation(payment.getCustomerId());
		boolean orderId = val.numberValidation(payment.getOrderId());
		if (customerId == true && orderId == true) {
			ps.setDate(1, sqldate);
			ps.setInt(2, payment.getCustomerId());
			ps.setInt(3, payment.getOrderId());
			int execute = ps.executeUpdate();

			String find = "select quantity,unit_price from Orderiteam where order_id=?";
			PreparedStatement ps1 = con.prepareStatement(find);
			ps1.setInt(1, payment.getOrderId());
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int quantity = rs.getInt(1);
				int Price = rs.getInt(2);
				int amount = quantity * Price;
				String insert1 = "update payment set amount = ? where order_id = ?";
				PreparedStatement ps2 = con.prepareStatement(insert1);
				ps2.setInt(1, amount);
				ps2.setInt(2, payment.getOrderId());
				ps2.executeUpdate();
			}
			System.out.println(execute + " Inserted successfully");
		} else
			System.out.println("Invalid Input");
	}

	@Override
	public List<Payment> paymentList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String s = "select id,date,customer_id,order_id,amount from payment";
		PreparedStatement ps = con.prepareStatement(s);
		ResultSet rs = ps.executeQuery();
		ArrayList paymentList = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			Date date = rs.getDate(2);
			int customerId = rs.getInt(3);
			int orderId = rs.getInt(4);
			int amount = rs.getInt(5);

			Payment payment = new Payment();
			payment.setId(id);
			payment.setDate((java.sql.Date) date);
			payment.setCustomerId(customerId);
			payment.setOrderId(orderId);
			payment.setAmount(amount);
			paymentList.add(payment);
		}
		return paymentList;
	}

}
