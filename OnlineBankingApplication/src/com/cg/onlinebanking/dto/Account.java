package com.cg.onlinebanking.dto;

public class Account {
private int accountId;
private String accounttype;
private int accountbalance;
private int customerid;

public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
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
public int getAccountbalance() {
	return accountbalance;
}
public void setAccountbalance(int d) {
	this.accountbalance = d;
}


}
