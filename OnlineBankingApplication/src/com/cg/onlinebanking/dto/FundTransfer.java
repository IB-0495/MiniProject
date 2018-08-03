package com.cg.onlinebanking.dto;

public class FundTransfer 
{
	private int fundTransferid;
	private int accountId;
    private int payeeaccId;
    private double amount;
	public int getFundTransferid() {
		return fundTransferid;
	}
	public void setFundTransferid(int fundTransferid) {
		this.fundTransferid = fundTransferid;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPayeeaccId() {
		return payeeaccId;
	}
	public void setPayeeaccId(int payeeaccId) {
		this.payeeaccId = payeeaccId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
 
}
