package com.cg.onlinebanking.dto;

public class Account {
private int accountId;
private String accounttype;
private double accountbalance;
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public String getAccounttype() {
	return accounttype;
}
public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}
public double getAccountbalance() {
	return accountbalance;
}
public void setAccountbalance(double accountbalance) {
	this.accountbalance = accountbalance;
}


}
