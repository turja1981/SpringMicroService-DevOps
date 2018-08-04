package com.billing.payment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.billing.payment.bean.Payment;
@Repository
public class BillingInfoDao {


	private final String FETCH_SQL_BY_ID = "select ID, FIRSTNAME, LASTNAME, POLICY_NO,DUE_AMOUNT,PAY_PLAN, "
			+ "ACCOUNT_BALANCE,ADDRESSlINE_1, STATE, CITY, ZIP , "
			+ "BANK_HOLDER_NAME , BANK_ACCT_NO , BANK_NAME, "
			+ "CARD_HOLDER_NAME, CARD_NO,EXPIRATION_DATE ,CARD_ZIP,DUE_DATE"
			+ ",STATUS from payments where POLICY_NO = ?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Payment findBillingInfoByPolicyNo(String policyNo) {
		return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { policyNo }, new PaymentMapper());
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
		payment.setDueAmount(rs.getDouble("DUE_AMOUNT"));
		payment.setAccountBalance(rs.getDouble("ACCOUNT_BALANCE"));
		payment.setPayplan(rs.getString("PAY_PLAN"));
		payment.setAddressLine1(rs.getString("ADDRESSlINE_1"));
		payment.setState(rs.getString("STATE"));
		payment.setCity(rs.getString("CITY"));
		payment.setZip(rs.getString("ZIP"));

		return payment;
	}

}
