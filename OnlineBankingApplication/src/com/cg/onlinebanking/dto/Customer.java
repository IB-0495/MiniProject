package com.cg.onlinebanking.bean;

public class Customer {
private int customerid;
private String customerName;
private String email;
private String address;
private String panCard;
private String userid;
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPanCard() {
	return panCard;
}
public void setPanCard(String panCard) {
	this.panCard = panCard;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
@Override
public String toString() {
	return "Customer [customerid=" + customerid + ", customerName=" + customerName + ", email=" + email + ", address="
			+ address + ", panCard=" + panCard + ", userid=" + userid + "]";
}

}
