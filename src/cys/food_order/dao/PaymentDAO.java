package cys.food_order.dao;

import java.sql.SQLException;
import java.util.List;

import cys.food_order.model.Payment;

public interface PaymentDAO {
	public void insertPayment(Payment pay) throws ClassNotFoundException, SQLException;
	public List<Payment> paymentList() throws ClassNotFoundException, SQLException;
}
