package com.cg.onlinebanking.dto;

public class Customer {
	
	private int accNo;
	private String customerName; 
	private String email;
	private String address;
	private String pancard;
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
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
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", customerName=" + customerName + ", email=" + email + ", address="
				+ address + ", pancard=" + pancard + "]";
	}

}
