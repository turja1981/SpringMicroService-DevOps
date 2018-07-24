package com.tcs.addPayment.bean;

public class Payment {
	
	//This is Id Field
	private int Id ;
	
	private String policyNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String status ;
	
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
