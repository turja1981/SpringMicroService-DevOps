package com.billing.payment.card.bean;

public class Payment {
	
	private int Id ;
	//Policy Number 
	private String policyNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String status ;
	
	private String payPlan ;
	
	private double dueAmount ;
	
	private double accountBalance ;
	
	private String addressLine1 ;
	
	private String state ;
	
	private String city ;
	
	private String zip ;
	
	private String cardHolderName ;
	
	private String cardNo ;
	
	private String  expirationDate ;
	
	private String cardZip ;
	
	
	private String bankHolderName ;
	
	private String bankAccountNo ;
	
	private String bankName ;
	
	private String accountType ;
	
	
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

	public String getBankHolderName() {
		return bankHolderName;
	}

	public void setBankHolderName(String bankHolderName) {
		this.bankHolderName = bankHolderName;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setPayPlan(String payPlan) {
		this.payPlan = payPlan;
	}

	public String getPayPlan() {
		return payPlan;
	}

	public void setPayplan(String payPlan) {
		this.payPlan = payPlan;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	//This is Amount Field
	private double amount ;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	

}
