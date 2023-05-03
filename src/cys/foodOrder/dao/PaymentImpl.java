package cys.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.foodOrder.model.Payment;
import cys.foodOrder.util.ConnectionUtil;

public class PaymentImpl implements PaymentDAO {

	@Override
	public int insertPayment(Payment payment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String insert = "insert into payment(id,date,customer_id,order_id)values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, payment.getId());
		ps.setString(2, payment.getDate());
		ps.setInt(3, payment.getCustomerId());
		ps.setInt(4, payment.getOrderId());
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
		return execute;
	}

	@Override
	public List<Payment> paymentList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String s = "select id,date,customer_id,order_id,amount from payment";
		PreparedStatement ps = con.prepareStatement(s);
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String date = rs.getString(2);
			int customerId = rs.getInt(3);
			int orderId = rs.getInt(4);
			int amount = rs.getInt(5);

			Payment payment = new Payment();
			payment.setId(id);
			payment.setDate(date);
			payment.setCustomerId(customerId);
			payment.setOrderId(orderId);
			payment.setAmount(amount);
			list.add(payment);
		}
		return list;
	}

}
