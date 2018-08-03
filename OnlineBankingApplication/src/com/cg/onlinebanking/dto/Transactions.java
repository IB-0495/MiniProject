package com.cg.onlinebanking.dto;

import java.time.LocalDate;

public class Transactions {
	
	private int transId;
	private String transDecription;
	private LocalDate dateofTransaction;
	private String transType;
	private int transAmount;
	private int accNo;
	
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getTransDecription() {
		return transDecription;
	}
	public void setTransDecription(String transDecription) {
		this.transDecription = transDecription;
	}
	public LocalDate getDateofTransaction() {
		return dateofTransaction;
	}
	public void setDateofTransaction(LocalDate dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public int getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(int transAmount) {
		this.transAmount = transAmount;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	@Override
	public String toString() {
		return "Transactions [transId=" + transId + ", transDecription=" + transDecription + ", dateofTransaction="
				+ dateofTransaction + ", transType=" + transType + ", transAmount=" + transAmount + ", accNo=" + accNo
				+ "]";
	}
	
	

}
