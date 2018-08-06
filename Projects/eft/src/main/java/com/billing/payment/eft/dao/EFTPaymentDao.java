package com.billing.payment.eft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.billing.payment.eft.bean.Payment;
@Repository
public class EFTPaymentDao {

	private final static String UPDATE_SQL = "UPDATE payments set BANK_HOLDER_NAME=?,BANK_ACCT_NO=?,BANK_NAME=?,ACCOUN_TYPE=? where POLICY_NO = ?";

		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int update(final Payment payment) {


		int rows  = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, payment.getBankHolderName());
				ps.setString(2, payment.getBankAccountNo());
				ps.setString(3, payment.getBankName());
				ps.setString(4, payment.getAccountType());
				ps.setString(5, payment.getPolicyNumber());
				return ps;
			}
		});


		return rows;
	}
}
