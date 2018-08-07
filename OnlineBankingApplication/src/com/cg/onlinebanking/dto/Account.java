package com.cg.onlinebanking.bean;

public class Account {
private int accountId;
private String accounttype;
private double accountbalance;
private String userid;
private int customerid;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
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
public double getAccountbalance() {
	return accountbalance;
}
public void setAccountbalance(double accountbalance) {
	this.accountbalance = accountbalance;
}


}
