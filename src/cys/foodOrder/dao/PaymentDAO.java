package cys.foodOrder.dao;

import java.sql.SQLException;
import java.util.List;

import cys.foodOrder.model.Payment;

public interface PaymentDAO {
	public int insertPayment(Payment pay) throws ClassNotFoundException, SQLException;
	public List<Payment> paymentList() throws ClassNotFoundException, SQLException;
}
