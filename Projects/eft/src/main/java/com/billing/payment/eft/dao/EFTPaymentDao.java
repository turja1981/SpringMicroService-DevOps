package com.billing.payment.eft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.billing.payment.eft.bean.Payment;

@Repository
public class EFTPaymentDao {

	private final static String UPDATE_SQL = "UPDATE payments set BANK_HOLDER_NAME=?,BANK_ACCT_NO=?,BANK_ROUTING_NO=? , BANK_NAME=?,ACCOUN_TYPE=? where POLICY_NO = ?";

	private final static String BANK_NAME_SQL = "SELECT BANK_NAME FROM bank_routing_mapping where BANK_ROUTING_NO = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int update(final Payment payment) {

		int rows = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, payment.getBankHolderName());
				ps.setString(2, payment.getBankAccountNo());
				ps.setString(3, payment.getBankRoutingNo());
				ps.setString(4, payment.getBankName());
				ps.setString(5, payment.getAccountType());
				ps.setString(6, payment.getPolicyNumber());
				return ps;
			}
		});

		return rows;
	}

	public String findBankNameByRoutingNo(String routingNo) {
		try {
			return jdbcTemplate.queryForObject(BANK_NAME_SQL, new Object[] { routingNo }, new PaymentMapper());
		} catch (EmptyResultDataAccessException ex) {
			return "Not Found";
		}
	}

	class PaymentMapper implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {

			String bankName;
			bankName = rs.getString("BANK_NAME");

			return bankName;
		}
	}
}
