package com.tcs.showPayment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tcs.showPayment.bean.Payment;
@Repository
public class GetPaymentDao {


	private final String FETCH_SQL = "select ID, FIRSTNAME, LASTNAME, POLICY_NO,AMOUNT,STATUS from payments";
	private final String FETCH_SQL_BY_ID = "select ID, FIRSTNAME, LASTNAME, POLICY_NO,AMOUNT,STATUS from payments where ID = ?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Payment> findAll() {
		return jdbcTemplate.query(FETCH_SQL, new PaymentMapper());
	}

	public Payment findPaymentById(int id) {
		return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new PaymentMapper());
	}
	
}

class PaymentMapper implements RowMapper<Payment> {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payment payment = new Payment();
		payment.setId(rs.getInt("ID"));
		payment.setFirstName(rs.getString("FIRSTNAME"));
		payment.setLastName(rs.getString("LASTNAME"));
		payment.setPolicyNumber(rs.getString("POLICY_NO"));
		payment.setStatus(rs.getString("STATUS"));
		payment.setAmount(rs.getDouble("AMOUNT"));
		return payment;
	}

}
