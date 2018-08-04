package com.billing.payment.bean;

public class Payment {
	
	private int Id ;
	//Policy Number 
	private String policyNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String status ;
	
	private String payplan ;
	
	private double dueAmount ;
	
	private double accountBalance ;
	
	private String addressLine1 ;
	
	private String state ;
	
	private String city ;
	
	private String zip ;
	
	private String bankHolderName ;
	
	private String bankAcctNo ;
	
	private String bankName ;
	
	private String accountType ;
	
	private String cardHolderName ;
	private String cardNo ;
	
	private String expirationDate ;
	
	private String cardZip ;
	
	private String dueDate ;
	
	
	
	
	
	public String getPayplan() {
		return payplan;
	}

	public void setPayplan(String payplan) {
		this.payplan = payplan;
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
