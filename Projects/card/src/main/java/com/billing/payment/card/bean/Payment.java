package com.billing.payment.card.bean;

public class Payment {
	
	private int Id ;
	//Policy Number 
	private String policyNumber;
	

	private String cardHolderName ;
	
	private String cardNo ;
	
	private String  expirationDate ;
	
	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardZip() {
		return cardZip;
	}

	public void setCardZip(String cardZip) {
		this.cardZip = cardZip;
	}

	public void setId(int id) {
		Id = id;
	}

	private String cardZip ;

	public int getId() {
		return Id;
	}



}
