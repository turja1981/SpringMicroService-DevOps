package com.billing.payment.card.dao;

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

import com.billing.payment.card.bean.Payment;

@Repository
public class CardPaymentDao {

	private final static String UPDATE_SQL = "UPDATE payments set CARD_HOLDER_NAME=?, CARD_NO=?, EXPIRATION_DATE=? , CARD_ZIP =? where POLICY_NO = ?";


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int update(final Payment payment) {

		int rows = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
				ps.setString(1, payment.getCardHolderName());
				ps.setString(2, payment.getCardNo());
				ps.setString(3, payment.getExpirationDate());
				ps.setString(4, payment.getCardZip());
				ps.setString(5, payment.getPolicyNumber());
				return ps;
			}
		});

		return rows;
	}

}
