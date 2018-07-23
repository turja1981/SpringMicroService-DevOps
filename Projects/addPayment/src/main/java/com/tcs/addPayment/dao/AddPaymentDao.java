package com.tcs.addPayment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tcs.addPayment.bean.Payment;
@Repository
public class AddPaymentDao {

	private final static String INSERT_SQL = "INSERT INTO payments(FIRSTNAME,LASTNAME,POLICY_NO,AMOUNT,STATUS) values(?,?,?,?,?)";

		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Payment create(final Payment payment) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, payment.getFirstName());
				ps.setString(2, payment.getLastName());
				ps.setString(3, payment.getPolicyNumber());
				ps.setDouble(4, payment.getAmount());
				ps.setString(5, "Success");
				return ps;
			}
		}, holder);

		int newUserId = holder.getKey().intValue();
		payment.setId(newUserId);
		payment.setStatus("Success");
		return payment;
	}
}
